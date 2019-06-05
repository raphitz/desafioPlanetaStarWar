package br.com.raphitz.starwarplanets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NomeDuplicadoException extends RuntimeException{

    public NomeDuplicadoException(String mensagem){
        super(mensagem);
    }

}
