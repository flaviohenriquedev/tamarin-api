package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.repository.impl.DefaultRepositoryImpl;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.dto.ColaboradorCargoDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.model.ColaboradorCargo;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.repository.ColaboradorCargoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ColaboradorCargoService extends DefaultServiceImpl<ColaboradorCargo, ColaboradorCargoDTO> {

    @Autowired
    private ColaboradorCargoRepository colaboradorCargoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<ColaboradorCargo, UUID> getRepository() {
        return colaboradorCargoRepository;
    }

    @Override
    protected DtoMapper<ColaboradorCargo, ColaboradorCargoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, ColaboradorCargo.class, ColaboradorCargoDTO.class);
    }

    public List<ColaboradorCargoDTO> getCargosPorColaboradorId(UUID idColaborador) {
        return getMapper().toDtoList(colaboradorCargoRepository.findByColaboradorId(idColaborador));
    }
}
