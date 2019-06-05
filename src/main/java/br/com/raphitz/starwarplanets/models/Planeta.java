package br.com.raphitz.starwarplanets.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planetas")
public class Planeta {


    @Id
    private String _id;

    @Indexed(unique=true)
    private String nome;
    private String clima;
    private String terreno;

    @Transient
    private int qtdAparicoes; //para mostrar no retorno.. varivel verificada ao carregar dados do planeta

    public Planeta(){}

    public Planeta(String nome, String clima, String terreno){
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
    }
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getTerreno() {
    return terreno;
    }

    public void setTerreno(String terreno) {
    this.terreno = terreno;
    }

    @Override
    public String toString(){
        return String.format("Planeta{planetaId='%s', nome='%s', clima='%s', terreno='%s'}\n", _id, nome, clima, terreno);
    }


    public int getQtdAparicoes() {
return qtdAparicoes;
}

    public void setQtdAparicoes(int qtdAparicoes) {
this.qtdAparicoes = qtdAparicoes;
}
}
