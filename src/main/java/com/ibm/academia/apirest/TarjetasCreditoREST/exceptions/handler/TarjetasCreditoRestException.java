package com.ibm.academia.apirest.TarjetasCreditoREST.exceptions.handler;

import com.ibm.academia.apirest.TarjetasCreditoREST.exceptions.BadRequestException;
import com.ibm.academia.apirest.TarjetasCreditoREST.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TarjetasCreditoRESTException {
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<?> noExisteException(NotFoundException exception){
        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("error",exception.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<?> malFormedException(BadRequestException exception){
        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("error",exception.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);

    }
}
