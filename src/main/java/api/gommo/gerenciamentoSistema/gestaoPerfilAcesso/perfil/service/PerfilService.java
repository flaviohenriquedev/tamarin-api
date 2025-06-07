package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service;

import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.repository.PerfilRepository;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.service.PerfilSistemaService;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.service.PerfilSistemaModuloService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

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
    protected JpaRepository<Perfil, UUID> getRepository() {
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

    public PerfilDTO findById(UUID perfilId) {
        Perfil perfil = perfilRepository.findById(perfilId)
                .orElseThrow(() -> new IllegalArgumentException("Perfil não encontrado: " + perfilId));
        return getMapper().toDto(perfil);
    }
}
