package api.tamarin.departamentoPessoal.administracao.cargo.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.departamentoPessoal.administracao.cargo.dto.CargoDTO;
import api.tamarin.departamentoPessoal.administracao.cargo.model.Cargo;
import api.tamarin.departamentoPessoal.administracao.cargo.repository.CargoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CargoService extends DefaultServiceImpl<Cargo, CargoDTO> {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<Cargo, UUID> getRepository() {
        return cargoRepository;
    }

    @Override
    protected DtoMapper<Cargo, CargoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Cargo.class, CargoDTO.class);
    }
}
