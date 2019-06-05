package br.com.raphitz.starwarplanets.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiEnvioApi extends SwapiRetornoApi {

    private int contagem;

    private SwapiEnvioApi[] resultados;


    public SwapiEnvioApi[] getResultados() {
        return resultados;
    }

    public void setResultados(SwapiEnvioApi[] resultados) {
        this.resultados = resultados;
    }


    public int getContagem() {
        return contagem;
    }

    public void setContagem(int contagem) {
        this.contagem = contagem;
    }
}
