package com.pablo.salazar.Api.resources.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreateProductoException extends  Exception{

    private static final long serialVersionUID=-7717691994704695707L;

    public CreateProductoException (String message){
        super(message);
    }
}

