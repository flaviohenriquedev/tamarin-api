package api.gommo._root.apis.brasilApi.service;

import api.gommo._root.apis.brasilApi.constants.URLBrasilAPI;
import api.gommo._root.apis.brasilApi.dto.CepResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BrasilApiService {

    private final RestTemplate restTemplate;

    public BrasilApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CepResponse getCep(String cep) {
        return restTemplate.getForObject(URLBrasilAPI.URL_BRASILAPI_CEP_V1.concat(cep), CepResponse.class);
    }
}