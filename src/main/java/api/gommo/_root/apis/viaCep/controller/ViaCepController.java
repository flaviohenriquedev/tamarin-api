package api.gommo._root.apis.viaCep.controller;

import api.gommo._root.apis.viaCep.dto.EnderecoViaCep;
import api.gommo._root.apis.viaCep.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/via-cep")
public class ViaCepController {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public EnderecoViaCep getEndereco(@PathVariable String cep) {
        return viaCepService.getEndereco(cep);
    }
}
