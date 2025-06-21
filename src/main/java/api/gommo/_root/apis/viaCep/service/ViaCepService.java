package api.gommo._root.apis.viaCep.service;

import api.gommo._root.apis.viaCep.client.ViaCepClient;
import api.gommo._root.apis.viaCep.dto.EnderecoViaCep;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ViaCepService {

    @Autowired
    private CidadeService cidadeService;

    public EnderecoViaCep getEndereco(String cep) {
        try {
            EnderecoViaCep retorno = ViaCepClient.getEndereco(cep);
            if (Objects.nonNull(retorno) && Objects.nonNull(retorno.getIbge())) {
                retorno.setCidade(cidadeService.buscarPorCodigoIBGE(Integer.valueOf(retorno.getIbge())));
            }
            return retorno;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
