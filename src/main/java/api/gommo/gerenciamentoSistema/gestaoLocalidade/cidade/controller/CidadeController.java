package api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.dto.CidadeDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeController extends DefaultController<CidadeDTO> {

    @Autowired
    private CidadeService cidadeService;

    @Override
    protected DefaultService<CidadeDTO> getService() {
        return cidadeService;
    }

    @GetMapping("/buscar-por-nome-iniciado-com/{nome}")
    public ResponseEntity<List<CidadeDTO>> buscarPorNomeIniciadoCom(@PathVariable String nome) {
        return ResponseEntity.ok(cidadeService.buscarPorNomeIniciadoCom(nome));
    }
}
