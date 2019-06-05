package br.com.raphitz.starwarplanets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlanetaNaoLocalizadoException extends RuntimeException{

    public PlanetaNaoLocalizadoException(String mensagem){
        super(mensagem);
    }

}
