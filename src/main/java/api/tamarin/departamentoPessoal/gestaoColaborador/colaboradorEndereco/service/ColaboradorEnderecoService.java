package api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorEndereco.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorEndereco.dto.ColaboradorEnderecoDTO;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorEndereco.model.ColaboradorEndereco;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorEndereco.repository.ColaboradorEnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ColaboradorEnderecoService extends DefaultServiceImpl<ColaboradorEndereco, ColaboradorEnderecoDTO> {

    @Autowired
    private ColaboradorEnderecoRepository colaboradorEnderecoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<ColaboradorEndereco, UUID> getRepository() {
        return colaboradorEnderecoRepository;
    }

    @Override
    protected DtoMapper<ColaboradorEndereco, ColaboradorEnderecoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, ColaboradorEndereco.class, ColaboradorEnderecoDTO.class);
    }
}
