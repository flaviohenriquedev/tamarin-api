package api.gommo.departamentoPessoal.gestaoColaborador.colaborador.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.repository.ColaboradorRepository;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.service.ColaboradorCargoService;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.service.ColaboradorEnderecoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ColaboradorService extends DefaultServiceImpl<Colaborador, ColaboradorDTO> {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ColaboradorEnderecoService colaboradorEnderecoService;

    @Autowired
    private ColaboradorCargoService colaboradorCargoService;

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

    @Override
    public ColaboradorDTO salvar(ColaboradorDTO dto) {
        if (dto.isNew()) {
            dto.setMatricula(this.getProximaMatricula());
            dto.setStatusColaborador(StatusColaboradorENUM.ATIVO);
        }
        ColaboradorDTO colaboradorSalvo = super.salvar(getColaboradorParaSalvar(dto));

        salvarEndereco(dto, colaboradorSalvo);
        salvarCargo(dto, colaboradorSalvo);

        return colaboradorSalvo;
    }

    @Override
    public List<ColaboradorDTO> listar() {
        List<ColaboradorDTO> lista = super.listar();
        getEndereco(lista);
        return lista;
    }

    private void getEndereco(List<ColaboradorDTO> lista) {
        if (!lista.isEmpty()) {
            lista.forEach(colaborador -> colaborador.setColaboradorEndereco(colaboradorEnderecoService.getByIdColaborador(colaborador.getId())));
        }
    }

    private ColaboradorDTO getColaboradorParaSalvar(ColaboradorDTO dto) {
        ColaboradorDTO copia = new ColaboradorDTO();
        BeanUtils.copyProperties(dto, copia);
        copia.setColaboradorEndereco(null);
        copia.setCargoAtivo(null);
        copia.setListaColaboradorCargo(new ArrayList<>());
        return copia;
    }

    private void salvarCargo(ColaboradorDTO dto, ColaboradorDTO colaboradorSalvo) {
        if (!dto.getListaColaboradorCargo().isEmpty()) {
            dto.getListaColaboradorCargo().forEach(colaboradorCargo -> {
                colaboradorCargo.setColaborador(colaboradorSalvo);
                colaboradorCargoService.salvar(colaboradorCargo);
            });
        }
    }

    private void salvarEndereco(ColaboradorDTO dto, ColaboradorDTO colaboradorSalvo) {
        dto.getColaboradorEndereco().setColaborador(colaboradorSalvo);
        colaboradorEnderecoService.salvar(dto.getColaboradorEndereco());
    }

    public Set<ColaboradorDTO> listarColaboradoresAtivos() {
        List<Colaborador> result = colaboradorRepository.findByStatusColaborador(StatusColaboradorENUM.ATIVO);
        return new HashSet<>(getMapper().toDtoList(result));
    }

    public Integer getProximaMatricula() {
        return colaboradorRepository.getProximaMatricula();
    }
}
