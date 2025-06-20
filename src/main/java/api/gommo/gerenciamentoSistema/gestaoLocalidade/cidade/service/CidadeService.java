package api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.dto.CidadeDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.model.Cidade;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.repository.CidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.UUID;

@Service
public class CidadeService extends DefaultServiceImpl<Cidade, CidadeDTO> {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<Cidade, UUID> getRepository() {
        return cidadeRepository;
    }

    @Override
    protected DtoMapper<Cidade, CidadeDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Cidade.class, CidadeDTO.class);
    }

    public List<CidadeDTO> buscarPorNomeIniciadoCom(String nome) {
        String nomeTratado = Normalizer
                .normalize(nome.trim(), Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "") // tira acento
                .replaceAll("[^a-zA-Z0-9\\s]", "") // tira símbolos
                .toLowerCase();

        return getMapper().toDtoList(cidadeRepository.findByNomeStartingWithIgnoreCase(nomeTratado));
    }
}
