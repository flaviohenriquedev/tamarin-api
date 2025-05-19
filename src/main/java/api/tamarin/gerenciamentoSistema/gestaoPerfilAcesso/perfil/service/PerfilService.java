package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.dto.ClienteDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.repository.PerfilRepository;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.service.PerfilSistemaService;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.service.PerfilSistemaModuloService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PerfilService extends DefaultServiceImpl<Perfil, PerfilDTO> {

    @Autowired
    private PerfilRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PerfilSistemaService perfilSistemaService;

    @Autowired
    private PerfilSistemaModuloService perfilSistemaModuloService;

    @Override
    protected JpaRepository<Perfil, UUID> getRepository() {
        return repository;
    }

    @Override
    protected DtoMapper<Perfil, PerfilDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Perfil.class, PerfilDTO.class);
    }

    @Override
    public PerfilDTO salvar(PerfilDTO perfil) {
        PerfilDTO perfilDTO = new PerfilDTO();
        perfilDTO.setDescricao(perfil.getDescricao());
        perfilDTO.setCliente(new ClienteDTO(perfil.getCliente().getId()));
        PerfilDTO perfilSalvo = super.salvar(perfilDTO);
        if (!perfil.getSistemas().isEmpty()) {
            for (PerfilSistemaDTO sistema : perfil.getSistemas()) {
                sistema.setPerfil(perfilSalvo);
                perfilSistemaService.salvar(sistema);
            }
        }

        return perfil;
    }
}
