package api.gommo.departamentoPessoal.administracao.cargo.service;

import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.administracao.cargo.dto.CargoDTO;
import api.gommo.departamentoPessoal.administracao.cargo.model.Cargo;
import api.gommo.departamentoPessoal.administracao.cargo.repository.CargoRepository;
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
