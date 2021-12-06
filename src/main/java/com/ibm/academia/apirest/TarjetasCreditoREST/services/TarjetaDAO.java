package com.ibm.academia.apirest.TarjetasCreditoREST.services;

import com.ibm.academia.apirest.TarjetasCreditoREST.entities.Tarjeta;
import com.ibm.academia.apirest.TarjetasCreditoREST.enums.Passion;

public interface TarjetaDAO  extends GenericoDAO<Tarjeta>{
    public Iterable<Tarjeta> encontrarTarjetas(Passion passion, Double salario, Integer edad);
}
