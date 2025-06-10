package api.gommo.departamentoPessoal.gestaoColaborador.colaborador.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.repository.ColaboradorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ColaboradorService extends DefaultServiceImpl<Colaborador, ColaboradorDTO> {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<Colaborador, UUID> getRepository() {
        return colaboradorRepository;
    }

    @Override
    protected DtoMapper<Colaborador, ColaboradorDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Colaborador.class, ColaboradorDTO.class);
    }

    public Set<ColaboradorDTO> listarColaboradoresAtivos() {
        List<Colaborador> result = colaboradorRepository.findByStatusColaborador(StatusColaboradorENUM.ATIVO);
        return new HashSet<>(getMapper().toDtoList(result));
    }
}
