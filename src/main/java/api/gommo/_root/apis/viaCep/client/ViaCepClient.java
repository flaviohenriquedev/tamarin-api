package api.gommo._root.apis.viaCep.client;

import api.gommo._root.apis.viaCep.constants.URLViaCep;
import api.gommo._root.apis.viaCep.dto.EnderecoViaCep;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Component;

@Component
public class ViaCepClient {
    public static EnderecoViaCep getEndereco(String cep) throws Exception {
        String jsonResponse = Request
                .Get(new URLViaCep(cep).build())
                .connectTimeout(1000) // tempo limite de conexão
                .socketTimeout(1000)
                .execute() // executando requisição
                .returnContent() // retornando conteudo
                .asString(); // convertendo em string

        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, EnderecoViaCep.class);
    }
}
