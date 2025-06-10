package api.gommo.departamentoPessoal.administracao.cargaHoraria.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.administracao.cargaHoraria.dto.CargaHorariaDTO;
import api.gommo.departamentoPessoal.administracao.cargaHoraria.model.CargaHoraria;
import api.gommo.departamentoPessoal.administracao.cargaHoraria.repository.CargaHorariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CargaHorariaService extends DefaultServiceImpl<CargaHoraria, CargaHorariaDTO> {

    @Autowired
    private CargaHorariaRepository cargaHorariaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<CargaHoraria, UUID> getRepository() {
        return cargaHorariaRepository;
    }

    @Override
    protected DtoMapper<CargaHoraria, CargaHorariaDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, CargaHoraria.class, CargaHorariaDTO.class);
    }
}
