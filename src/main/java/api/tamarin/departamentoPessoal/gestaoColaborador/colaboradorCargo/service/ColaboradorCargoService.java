package api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.dto.ColaboradorCargoDTO;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.model.ColaboradorCargo;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.repository.ColaboradorCargoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ColaboradorCargoService extends DefaultServiceImpl<ColaboradorCargo, ColaboradorCargoDTO> {

    @Autowired
    private ColaboradorCargoRepository colaboradorCargoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<ColaboradorCargo, UUID> getRepository() {
        return colaboradorCargoRepository;
    }

    @Override
    protected DtoMapper<ColaboradorCargo, ColaboradorCargoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, ColaboradorCargo.class, ColaboradorCargoDTO.class);
    }
}
