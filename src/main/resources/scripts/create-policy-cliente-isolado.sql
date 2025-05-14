DO $$
    DECLARE
        r RECORD;
        policy_name TEXT := 'cliente_isolado';
        column_exists BOOLEAN;
        sql_policy TEXT;
    BEGIN
        FOR r IN
            SELECT table_schema, table_name
            FROM information_schema.tables
            WHERE table_schema = 'public'
              AND table_type = 'BASE TABLE'
            LOOP
                -- Verifica se a tabela tem a coluna 'cliente_id'
                EXECUTE format(
                        'SELECT EXISTS (
                            SELECT 1
                            FROM information_schema.columns
                            WHERE table_schema = %L
                              AND table_name = %L
                              AND column_name = %L
                        )',
                        r.table_schema, r.table_name, 'cliente_id'
                        ) INTO column_exists;

                IF column_exists THEN
                    RAISE NOTICE 'Aplicando RLS na tabela: %.%', r.table_schema, r.table_name;

                    -- Habilita RLS
                    EXECUTE format('ALTER TABLE %I.%I ENABLE ROW LEVEL SECURITY;', r.table_schema, r.table_name);

                    -- Verifica se já existe a política
                    IF NOT EXISTS (
                        SELECT 1
                        FROM pg_policies
                        WHERE schemaname = r.table_schema
                          AND tablename = r.table_name
                          AND policyname = policy_name
                    ) THEN
                        -- Monta e executa a criação da política
                        sql_policy := format(
                                'CREATE POLICY %I ON %I.%I USING (cliente_id::text = current_setting(''app.current_cliente_id'', true));',
                                policy_name, r.table_schema, r.table_name
                                      );
                        EXECUTE sql_policy;
                    END IF;
                END IF;
            END LOOP;
    END
$$;