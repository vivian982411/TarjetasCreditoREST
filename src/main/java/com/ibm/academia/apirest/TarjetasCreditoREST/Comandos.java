package com.ibm.academia.apirest.TarjetasCreditoREST;

import com.ibm.academia.apirest.TarjetasCreditoREST.entities.Tarjeta;
import com.ibm.academia.apirest.TarjetasCreditoREST.enums.Passion;
import com.ibm.academia.apirest.TarjetasCreditoREST.repositories.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Comandos implements CommandLineRunner {

    @Autowired
    private TarjetaRepository tarjetaRepository;
    @Override
    public void run(String... args) throws Exception {
        /*Iterable<Tarjeta> tarjetas=tarjetaRepository.encontrarTarjetas(Passion.SHOPPING,20000.0,24);
        tarjetas.forEach(System.out::println);
        System.out.println(((ArrayList)tarjetas).size());*/

    }
}
