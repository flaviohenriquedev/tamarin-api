package api.tamarin.recursosHumanos.gestaoColaborador.colaborador.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.recursosHumanos.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.tamarin.recursosHumanos.gestaoColaborador.colaborador.model.Colaborador;
import api.tamarin.recursosHumanos.gestaoColaborador.colaborador.repository.ColaboradorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ColaboradorService extends DefaultServiceImpl<Colaborador, ColaboradorDTO> {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<Colaborador, UUID> getRepository() {
        return colaboradorRepository;
    }

    @Override
    protected DtoMapper<Colaborador, ColaboradorDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Colaborador.class, ColaboradorDTO.class);
    }
}
