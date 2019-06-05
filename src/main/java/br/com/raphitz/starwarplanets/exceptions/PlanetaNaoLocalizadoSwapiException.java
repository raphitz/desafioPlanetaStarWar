package br.com.raphitz.starwarplanets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class PlanetaNaoLocalizadoSwapiException extends Exception{

    public PlanetaNaoLocalizadoSwapiException(String mensagem){
        super(mensagem);
    }

}
