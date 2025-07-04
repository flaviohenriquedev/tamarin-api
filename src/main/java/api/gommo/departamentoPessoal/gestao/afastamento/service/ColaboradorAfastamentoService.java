package api.gommo.departamentoPessoal.gestao.afastamento.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.gestao.afastamento.dto.ColaboradorAfastamentoDTO;
import api.gommo.departamentoPessoal.gestao.afastamento.model.ColaboradorAfastamento;
import api.gommo.departamentoPessoal.gestao.afastamento.repository.ColaboradorAfastamentoRepository;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.service.ColaboradorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ColaboradorAfastamentoService extends DefaultServiceImpl<ColaboradorAfastamento, ColaboradorAfastamentoDTO> {

    @Autowired
    private ColaboradorAfastamentoRepository colaboradorAfastamentoRepository;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<ColaboradorAfastamento, UUID> getRepository() {
        return colaboradorAfastamentoRepository;
    }

    @Override
    protected DtoMapper<ColaboradorAfastamento, ColaboradorAfastamentoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, ColaboradorAfastamento.class, ColaboradorAfastamentoDTO.class);
    }

    @Override
    public ColaboradorAfastamentoDTO salvar(ColaboradorAfastamentoDTO colaboradorAfastamentoDTO) {
        ColaboradorDTO colaboradorDTO = colaboradorAfastamentoDTO.getColaborador();
        colaboradorDTO.setStatusColaborador(StatusColaboradorENUM.AFASTADO);
        colaboradorService.salvar(colaboradorDTO);

        return super.salvar(colaboradorAfastamentoDTO);
    }
}
