package api.gommo.departamentoPessoal.administracao.setor.service;

import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.departamentoPessoal.administracao.setor.dto.SetorDTO;
import api.gommo.departamentoPessoal.administracao.setor.model.Setor;
import api.gommo.departamentoPessoal.administracao.setor.repository.SetorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SetorService extends DefaultServiceImpl<Setor, SetorDTO> {

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<Setor, UUID> getRepository() {
        return setorRepository;
    }

    @Override
    protected DtoMapper<Setor, SetorDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Setor.class, SetorDTO.class);
    }
}
