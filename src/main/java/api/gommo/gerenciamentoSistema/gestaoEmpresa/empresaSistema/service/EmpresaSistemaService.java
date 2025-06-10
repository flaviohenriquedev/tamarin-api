package api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.dto.EmpresaSistemaDTO;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.model.EmpresaSistema;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.repository.EmpresaSistemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmpresaSistemaService extends DefaultServiceImpl<EmpresaSistema, EmpresaSistemaDTO> {

    @Autowired
    private EmpresaSistemaRepository empresaSistemaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<EmpresaSistema, UUID> getRepository() {
        return empresaSistemaRepository;
    }

    @Override
    protected DtoMapper<EmpresaSistema, EmpresaSistemaDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, EmpresaSistema.class, EmpresaSistemaDTO.class);
    }

    public List<EmpresaSistemaDTO> listarPorIdEmpresa(UUID idEmpresa) {
        return getMapper().toDtoList(empresaSistemaRepository.findByEmpresaId(idEmpresa));
    }
}
