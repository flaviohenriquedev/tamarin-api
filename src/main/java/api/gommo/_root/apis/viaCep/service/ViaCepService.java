package api.gommo._root.apis.viaCep.service;

import api.gommo._root.apis.viaCep.client.ViaCepClient;
import api.gommo._root.apis.viaCep.dto.EnderecoViaCep;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    public EnderecoViaCep getEndereco(String cep) {
        try {
            return ViaCepClient.getEndereco(cep);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
