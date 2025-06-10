package api.gommo.departamentoPessoal.gestao.admissao.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.gestao.admissao.dto.AdmissaoDTO;
import api.gommo.departamentoPessoal.gestao.admissao.model.Admissao;
import api.gommo.departamentoPessoal.gestao.admissao.repository.AdmissaoRepository;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.service.ColaboradorService;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.dto.ColaboradorCargoDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.service.ColaboradorCargoService;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.dto.ColaboradorEnderecoDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.service.ColaboradorEnderecoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AdmissaoService extends DefaultServiceImpl<Admissao, AdmissaoDTO> {

    @Autowired
    private AdmissaoRepository admissaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private ColaboradorEnderecoService colaboradorEnderecoService;

    @Autowired
    private ColaboradorCargoService colaboradorCargoService;

    @Override
    protected DefaultRepository<Admissao, UUID> getRepository() {
        return admissaoRepository;
    }

    @Override
    protected DtoMapper<Admissao, AdmissaoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Admissao.class, AdmissaoDTO.class);
    }

    @Override
    public AdmissaoDTO salvar(AdmissaoDTO admissaoDTO) {

        ColaboradorDTO colaboradorDTO = getColaboradorDTO(admissaoDTO);
        ColaboradorDTO colaboradorDTOSalvo = colaboradorService.salvar(colaboradorDTO);

        ColaboradorEnderecoDTO colaboradorEnderecoDTO = getColaboradorEnderecoDTO(admissaoDTO, colaboradorDTOSalvo);
        colaboradorEnderecoService.salvar(colaboradorEnderecoDTO);

        ColaboradorCargoDTO colaboradorCargoDTO = getColaboradorCargoDTO(admissaoDTO, colaboradorDTOSalvo);
        colaboradorCargoService.salvar(colaboradorCargoDTO);

        admissaoDTO.setColaborador(colaboradorDTOSalvo);
        return super.salvar(admissaoDTO);
    }

    private static ColaboradorCargoDTO getColaboradorCargoDTO(AdmissaoDTO admissaoDTO, ColaboradorDTO colaboradorDTOSalvo) {
        ColaboradorCargoDTO colaboradorCargoDTO = new ColaboradorCargoDTO();
        colaboradorCargoDTO.setColaborador(colaboradorDTOSalvo);
        colaboradorCargoDTO.setCargo(admissaoDTO.getCargo());
        colaboradorCargoDTO.setTipoContrato(admissaoDTO.getTipoContrato());
        colaboradorCargoDTO.setDepartamento(admissaoDTO.getDepartamento());
        colaboradorCargoDTO.setCargaHoraria(admissaoDTO.getCargaHoraria());
        colaboradorCargoDTO.setVigenciaInicial(new Date());
        return colaboradorCargoDTO;
    }

    private static ColaboradorDTO getColaboradorDTO(AdmissaoDTO admissaoDTO) {
        ColaboradorDTO colaboradorDTO = new ColaboradorDTO();
        colaboradorDTO.setNomeCompleto(admissaoDTO.getNomeCompleto());
        colaboradorDTO.setCpf(admissaoDTO.getCpf());
        colaboradorDTO.setDataNascimento(admissaoDTO.getDataNascimento());
        colaboradorDTO.setNascionalidade(admissaoDTO.getNascionalidade());
        colaboradorDTO.setNomeMae(admissaoDTO.getNomeMae());
        colaboradorDTO.setStatusColaborador(StatusColaboradorENUM.ATIVO);
        return colaboradorDTO;
    }

    private static ColaboradorEnderecoDTO getColaboradorEnderecoDTO(AdmissaoDTO admissaoDTO, ColaboradorDTO colaboradorDTO) {
        ColaboradorEnderecoDTO colaboradorEnderecoDTO = new ColaboradorEnderecoDTO();
        colaboradorEnderecoDTO.setColaborador(colaboradorDTO);
        colaboradorEnderecoDTO.setRua(admissaoDTO.getRua());
        colaboradorEnderecoDTO.setNumero(admissaoDTO.getNumero());
        colaboradorEnderecoDTO.setLote(admissaoDTO.getLote());
        colaboradorEnderecoDTO.setQuadra(admissaoDTO.getQuadra());
        colaboradorEnderecoDTO.setBairro(admissaoDTO.getBairro());
        colaboradorEnderecoDTO.setCidade(admissaoDTO.getCidade());
        return colaboradorEnderecoDTO;
    }
}
