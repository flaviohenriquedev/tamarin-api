# tamarin-api

Repositório Backend Tamarin

CREATE ROLE tamarin WITH LOGIN PASSWORD '68e75b69-7e51-4a51-867d-59de61566c75' CREATEDB CREATEROLE REPLICATION;
GRANT ALL PRIVILEGES ON DATABASE tamarin TO tamarin;

-- Permissões em todas as tabelas existentes
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO tamarin;

-- Permissões em todas as sequências (se houver autoincrementos)
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO tamarin;

-- Permissões em todas as funções
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public TO tamarin;

ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO tamarin;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO tamarin;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON FUNCTIONS TO tamarin;

[11:18, 18/06/2025] Amor ❤️: Campos tela de admissão
Tela 1 (dados pessoais)
Nome
RG
CPF
Data de nascimento
Data de expedição
número do pis
nome da mãe
Nome do pai (campo não obrigatório)
Cor/raça
Cidade de nascimento
Genero (opção masculino e feminino)
Estado civil
Email
Contato
Endereço (deve ter campos separados para CEP, compemento, Rua, número, bairro e cidade)
[11:26, 18/06/2025] Amor ❤️: Tela 2
Dados de admissão
Cargo
data de admissão
valor salarial
Data de admissão
Tipo de admissão (opção: Celetista, PJ ou temporário)
Carga horária (opção: 220)
Forma de pagamento (opção: Mensal, semanal, diário)
Matrícula (número por ordem de cadastros)
Sindicato (opção: possiu ou não possui)
Tipo de Salário (opção: mensalista, horista ou diária)
Campo para período de experiência
[11:28, 18/06/2025] Amor ❤️: Dentro do colaborador que é onde vai editar as informações se necessário, vai trazer os
dados listados em uma tela só. Dai eu quero que tenha outra tela de anotações e uma de anexos de documentos tbm