package api.gommo.departamentoPessoal.gestao.desligamento.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.gestao.desligamento.dto.ColaboradorDesligamentoDTO;
import api.gommo.departamentoPessoal.gestao.desligamento.model.ColaboradorDesligamento;
import api.gommo.departamentoPessoal.gestao.desligamento.repository.ColaboradorDesligamentoRepository;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.service.ColaboradorService;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.service.ColaboradorCargoService;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.service.ColaboradorEnderecoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ColaboradorDesligamentoService extends DefaultServiceImpl<ColaboradorDesligamento, ColaboradorDesligamentoDTO> {

    @Autowired
    private ColaboradorDesligamentoRepository colaboradorDesligamentoRepository;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private ColaboradorEnderecoService colaboradorEnderecoService;

    @Autowired
    private ColaboradorCargoService colaboradorCargoService;

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

    @Override
    public ColaboradorDesligamentoDTO salvar(ColaboradorDesligamentoDTO colaboradorDesligamentoDTO) {
        ColaboradorDTO colaboradorDTO = colaboradorDesligamentoDTO.getColaborador();
        colaboradorDTO.setStatusColaborador(StatusColaboradorENUM.DESLIGADO);
        colaboradorService.salvar(colaboradorDTO);

        return super.salvar(colaboradorDesligamentoDTO);
    }

    @Override
    public List<ColaboradorDesligamentoDTO> listar() {
        List<ColaboradorDesligamentoDTO> listaRetorno = super.listar();
        if (!listaRetorno.isEmpty()) {
            listaRetorno.forEach(item -> {
                item.getColaborador().setColaboradorEndereco(
                        colaboradorEnderecoService.getByIdColaborador(item.getColaborador().getId())
                );
                item.getColaborador().setListaColaboradorCargo(
                        colaboradorCargoService.getCargosPorColaboradorId(item.getColaborador().getId())
                );
            });
        }
        return listaRetorno;
    }
}
