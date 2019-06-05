package br.com.raphitz.starwarplanets.util;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Mensagens {

    public static Locale brazil = new Locale("pt","BR");
    private MessageSource ms;

    public String idPlanetaInvalido(String id) {
        return ms.getMessage("idPlanetaInvalido", new Object[] {id}, brazil);
    }

    public String nomeNaoExisteSwapi(String planeta) {
        return ms.getMessage("nomeNaoExisteSwapi", new Object[] {planeta}, brazil);
    }

    public String nomeDuplicado(String nome, String id) {
        return ms.getMessage("nomeDuplicado", new Object[] {id, nome}, brazil);
    }

    public String consultaSemRetorno(String nome) {
        return ms.getMessage("consultaSemRetorno", new Object[] {nome}, brazil);
    }

    public String camposObrigatorio(String nome) {
        return ms.getMessage("campoVazio", new Object[] {nome}, brazil);
    }

}
