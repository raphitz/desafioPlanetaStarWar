package br.com.raphitz.starwarplanets.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiRetornoApi {


    private String[] filmes;
    private String nome;
    private String clima;
    private int qtdAparicoes;
    private String terreno;



    public int numeroDeAparicoes(){
        if(getFilmes() == null){
            return 0;
        }
        return getFilmes().length;
    }


    public String[] getFilmes() {
        return filmes;
    }

    public void setFilmes(String[] filmes) {
        this.filmes = filmes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public int getQtdAparicoes() {
        return qtdAparicoes;
    }

    public void setQtdAparicoes(int qtdAparicoes) {
        this.qtdAparicoes = qtdAparicoes;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }
}
