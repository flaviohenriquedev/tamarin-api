package api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.model.EmpresaSistema;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmpresaSistemaRepository extends DefaultRepository<EmpresaSistema, UUID> {
    List<EmpresaSistema> findByEmpresaId(UUID empresaId);
}
