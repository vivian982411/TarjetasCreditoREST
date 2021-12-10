package com.ibm.academia.apirest.TarjetasCreditoREST.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String mensaje){
        super(mensaje);
    }

}
