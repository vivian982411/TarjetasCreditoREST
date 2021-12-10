package com.ibm.academia.apirest.TarjetasCreditoREST.services;

import com.ibm.academia.apirest.TarjetasCreditoREST.dto.request.FindCardRequest;
import com.ibm.academia.apirest.TarjetasCreditoREST.dto.response.FindCardResponse;
import com.ibm.academia.apirest.TarjetasCreditoREST.entities.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CardService {
    @Autowired
    private TarjetaDAO tarjetaDAO;

    public FindCardResponse findCard(FindCardRequest request){
        FindCardResponse response = new FindCardResponse();
        Iterable<Tarjeta> tarjetas = tarjetaDAO.encontrarTarjetas(request.getPassion(),request.getSalary(),request.getAge());
        response.setTipoTarjeta((List<Tarjeta>) tarjetas);
        return response;
    }
}
