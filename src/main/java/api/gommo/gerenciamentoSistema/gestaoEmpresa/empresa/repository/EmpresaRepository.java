package api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.model.Empresa;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpresaRepository extends DefaultRepository<Empresa, UUID> {
}
