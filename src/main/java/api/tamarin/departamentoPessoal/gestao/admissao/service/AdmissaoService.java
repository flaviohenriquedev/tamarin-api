package api.tamarin.departamentoPessoal.gestao.admissao.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.departamentoPessoal.gestao.admissao.dto.AdmissaoDTO;
import api.tamarin.departamentoPessoal.gestao.admissao.model.Admissao;
import api.tamarin.departamentoPessoal.gestao.admissao.repository.AdmissaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdmissaoService extends DefaultServiceImpl<Admissao, AdmissaoDTO> {

    @Autowired
    private AdmissaoRepository admissaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<Admissao, UUID> getRepository() {
        return admissaoRepository;
    }

    @Override
    protected DtoMapper<Admissao, AdmissaoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Admissao.class, AdmissaoDTO.class);
    }
}
