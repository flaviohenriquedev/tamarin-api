package api.gommo.departamentoPessoal.gestao.ferias.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.gestao.ferias.dto.ColaboradorFeriasDTO;
import api.gommo.departamentoPessoal.gestao.ferias.model.ColaboradorFerias;
import api.gommo.departamentoPessoal.gestao.ferias.repository.ColaboradorFeriasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ColaboradorFeriasService extends DefaultServiceImpl<ColaboradorFerias, ColaboradorFeriasDTO> {

    @Autowired
    private ColaboradorFeriasRepository colaboradorFeriasRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<ColaboradorFerias, UUID> getRepository() {
        return colaboradorFeriasRepository;
    }

    @Override
    protected DtoMapper<ColaboradorFerias, ColaboradorFeriasDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, ColaboradorFerias.class, ColaboradorFeriasDTO.class);
    }
}
