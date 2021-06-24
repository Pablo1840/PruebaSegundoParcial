package com.pablo.salazar.Api.resources.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EditProductoException extends Exception{
    private static final long serialVersionUID = -7717691994704695707L;

    public EditProductoException(String message) {
        super(message);
    }
}
