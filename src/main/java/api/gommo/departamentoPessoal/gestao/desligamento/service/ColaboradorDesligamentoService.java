package api.gommo.departamentoPessoal.gestao.desligamento.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.gestao.desligamento.dto.ColaboradorDesligamentoDTO;
import api.gommo.departamentoPessoal.gestao.desligamento.model.ColaboradorDesligamento;
import api.gommo.departamentoPessoal.gestao.desligamento.repository.ColaboradorDesligamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ColaboradorDesligamentoService extends DefaultServiceImpl<ColaboradorDesligamento, ColaboradorDesligamentoDTO> {

    @Autowired
    private ColaboradorDesligamentoRepository colaboradorDesligamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<ColaboradorDesligamento, UUID> getRepository() {
        return colaboradorDesligamentoRepository;
    }

    @Override
    protected DtoMapper<ColaboradorDesligamento, ColaboradorDesligamentoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, ColaboradorDesligamento.class, ColaboradorDesligamentoDTO.class);
    }
}
