package api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.dto.PaisDTO;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.model.Pais;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.repository.PaisRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaisService extends DefaultServiceImpl<Pais, PaisDTO> {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<Pais, UUID> getRepository() {
        return paisRepository;
    }

    @Override
    protected DtoMapper<Pais, PaisDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Pais.class, PaisDTO.class);
    }
}
