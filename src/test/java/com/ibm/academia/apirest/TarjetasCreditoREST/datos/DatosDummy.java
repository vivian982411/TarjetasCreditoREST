package com.ibm.academia.apirest.TarjetasCreditoREST.datos;

import com.ibm.academia.apirest.TarjetasCreditoREST.entities.Tarjeta;

public class DatosDummy {
    public static Tarjeta tarjeta01(){
        return new Tarjeta(11,"Banamex Teleton");
    }
    public static Tarjeta tarjeta02(){
        return new Tarjeta(12,"APAC");
    }
}
