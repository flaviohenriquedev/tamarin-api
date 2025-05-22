package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.repository.PerfilRepository;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.service.PerfilSistemaService;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.service.PerfilSistemaModuloService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class PerfilService extends DefaultServiceImpl<Perfil, PerfilDTO> {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PerfilSistemaService perfilSistemaService;

    @Autowired
    private PerfilSistemaModuloService perfilSistemaModuloService;

    @Override
    protected JpaRepository<Perfil, UUID> getPerfilRepository() {
        return perfilRepository;
    }

    @Override
    protected DtoMapper<Perfil, PerfilDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Perfil.class, PerfilDTO.class);
    }

    @Override
    public PerfilDTO salvar(PerfilDTO perfil) {
        if (!perfil.getSistemas().isEmpty()) {
            perfil.getSistemas().forEach(perfilSistema -> {
                perfilSistema.setPerfil(perfil);
                if (!perfilSistema.getRotas().isEmpty()) {
                    perfilSistema.getRotas().forEach(perfilSistemaModulo -> perfilSistemaModulo.setPerfilSistema(perfilSistema));
                }
            });
        }
        return super.salvar(perfil);
    }

    public Set<PerfilDTO> buscarPorIdCliente(UUID idCliente) {
        List<Perfil> listaPerfil = perfilRepository.findByClienteId(idCliente);
        List<PerfilDTO> listaPerfilDTO = getMapper().toDtoList(listaPerfil);
        for (PerfilDTO perfil : listaPerfilDTO) {
            if (!perfil.getSistemas().isEmpty()) {
                perfil.getSistemas().forEach(sistema -> sistema.setRotas(perfilSistemaModuloService.findByPerfilSistemaId(sistema.getId()).stream().toList()));
            }
        }
        return listaPerfil.isEmpty() ? Set.of() : new HashSet<>(getMapper().toDtoList(listaPerfil));
    }

    @EntityGraph(attributePaths = "sistemas")
    public Set<PerfilDTO> buscarPorIdClienteSistema(UUID idClienteSistema) {
        List<Perfil> listaPerfil = perfilRepository.findBySistemasClienteSistemaId(idClienteSistema);
        List<PerfilDTO> listaPerfilDTO = getMapper().toDtoList(listaPerfil);
        for (PerfilDTO perfil : listaPerfilDTO) {
            if (!perfil.getSistemas().isEmpty()) {
                perfil.getSistemas().forEach(sistema -> sistema.setRotas(perfilSistemaModuloService.findByPerfilSistemaId(sistema.getId()).stream().toList()));
            }
        }

        return listaPerfil.isEmpty() ? Set.of() : new HashSet<>(getMapper().toDtoList(listaPerfil));
    }

}
