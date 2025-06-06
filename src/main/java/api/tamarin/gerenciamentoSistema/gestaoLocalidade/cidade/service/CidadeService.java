package api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.dto.CidadeDTO;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.model.Cidade;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.repository.CidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CidadeService extends DefaultServiceImpl<Cidade, CidadeDTO> {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<Cidade, UUID> getRepository() {
        return cidadeRepository;
    }

    @Override
    protected DtoMapper<Cidade, CidadeDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Cidade.class, CidadeDTO.class);
    }
}
