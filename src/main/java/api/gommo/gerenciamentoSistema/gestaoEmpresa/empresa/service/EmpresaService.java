package api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto.EmpresaDTO;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.model.Empresa;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.repository.EmpresaRepository;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.service.EmpresaSistemaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmpresaService extends DefaultServiceImpl<Empresa, EmpresaDTO> {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmpresaSistemaService empresaSistemaService;

    @Override
    protected DefaultRepository<Empresa, UUID> getRepository() {
        return empresaRepository;
    }

    @Override
    protected DtoMapper<Empresa, EmpresaDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Empresa.class, EmpresaDTO.class);
    }

    @Override
    public EmpresaDTO salvar(EmpresaDTO empresa) {
        EmpresaDTO empresaSalva = super.salvar(empresa);
        if (!empresa.getSistemas().isEmpty()) {
            empresa.getSistemas().forEach(sistema -> {
                sistema.setEmpresa(empresaSalva);
                empresaSistemaService.salvar(sistema);
            });
        }
        return empresaSalva;
    }

    @Override
    public List<EmpresaDTO> listar() {
        List<EmpresaDTO> retorno = super.listar();
        if (!retorno.isEmpty()) {
            retorno.forEach(empresa -> empresa.setSistemas(
                    empresaSistemaService.listarPorIdEmpresa(empresa.getId())
            ));
        }
        return retorno;
    }

    public void salvarEmMassa(List<EmpresaDTO> lista) {
        List<Empresa> listaEmpresa = getMapper().toEntityList(lista);
        empresaRepository.saveAll(listaEmpresa);
    }
}
