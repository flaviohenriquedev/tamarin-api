package api.gommo.departamentoPessoal.administracao.tipoContrato.service;

import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.administracao.tipoContrato.dto.TipoContratoDTO;
import api.gommo.departamentoPessoal.administracao.tipoContrato.model.TipoContrato;
import api.gommo.departamentoPessoal.administracao.tipoContrato.repository.TipoContratoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TipoContratoService extends DefaultServiceImpl<TipoContrato, TipoContratoDTO> {

    @Autowired
    private TipoContratoRepository tipoContratoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<TipoContrato, UUID> getRepository() {
        return tipoContratoRepository;
    }

    @Override
    protected DtoMapper<TipoContrato, TipoContratoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, TipoContrato.class, TipoContratoDTO.class);
    }
}
