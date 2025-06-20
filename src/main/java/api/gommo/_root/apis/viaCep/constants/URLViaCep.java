package api.gommo._root.apis.viaCep.constants;

public class URLViaCep {
    public static final String URL_VIACEP_CEP = "https://viacep.com.br/ws/{cep}/json/";

    private String cep;

    public URLViaCep(String cep) {
        this.cep = cep;
    }

    public String build() {
        return URL_VIACEP_CEP.replace("{cep}", cep);
    }
}