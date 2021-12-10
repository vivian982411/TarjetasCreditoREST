package com.ibm.academia.apirest.TarjetasCreditoREST.controllers;

import com.ibm.academia.apirest.TarjetasCreditoREST.dto.request.FindCardRequest;
import com.ibm.academia.apirest.TarjetasCreditoREST.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/findCard")
    public ResponseEntity<?> findCard(FindCardRequest request){
        //System.out.println(request);
        return new ResponseEntity<>(cardService.findCard(request),HttpStatus.OK);
    }
}
