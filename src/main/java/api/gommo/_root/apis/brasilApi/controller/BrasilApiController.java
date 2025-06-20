package api.gommo._root.apis.brasilApi.controller;

import api.gommo._root.apis.brasilApi.dto.CepResponse;
import api.gommo._root.apis.brasilApi.service.BrasilApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brasil-api")
public class BrasilApiController {

    @Autowired
    private BrasilApiService brasilApiService;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepResponse> getCep(@PathVariable String cep) {
        CepResponse cepResponse = brasilApiService.getCep(cep);
        return ResponseEntity.ok(cepResponse);
    }
}
