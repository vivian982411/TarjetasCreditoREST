package com.ibm.academia.apirest.TarjetasCreditoREST.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super((message));
    }
}
