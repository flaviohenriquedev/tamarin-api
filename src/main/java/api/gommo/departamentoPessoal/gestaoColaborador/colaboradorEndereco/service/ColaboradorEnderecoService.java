package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.dto.ColaboradorEnderecoDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.model.ColaboradorEndereco;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.repository.ColaboradorEnderecoRepository;
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
    protected DefaultRepository<ColaboradorEndereco, UUID> getRepository() {
        return colaboradorEnderecoRepository;
    }

    @Override
    protected DtoMapper<ColaboradorEndereco, ColaboradorEnderecoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, ColaboradorEndereco.class, ColaboradorEnderecoDTO.class);
    }

    public ColaboradorEnderecoDTO getByIdColaborador(UUID id) {
        return getMapper().toDto(colaboradorEnderecoRepository.getByColaboradorId(id));
    }
}
