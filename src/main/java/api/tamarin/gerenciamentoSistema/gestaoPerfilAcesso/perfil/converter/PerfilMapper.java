package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.converter;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PerfilMapper extends DtoMapper<Perfil, PerfilDTO> {
    // Não precisa implementar nada, MapStruct gera o código na build.
}
