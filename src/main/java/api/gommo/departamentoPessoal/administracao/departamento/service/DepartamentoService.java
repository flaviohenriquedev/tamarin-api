package api.gommo.departamentoPessoal.administracao.departamento.service;

import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.administracao.departamento.dto.DepartamentoDTO;
import api.gommo.departamentoPessoal.administracao.departamento.model.Departamento;
import api.gommo.departamentoPessoal.administracao.departamento.repository.DepartamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DepartamentoService extends DefaultServiceImpl<Departamento, DepartamentoDTO> {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<Departamento, UUID> getRepository() {
        return departamentoRepository;
    }

    @Override
    protected DtoMapper<Departamento, DepartamentoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Departamento.class, DepartamentoDTO.class);
    }
}
