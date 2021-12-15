package com.ibm.academia.apirest.TarjetasCreditoREST.services;

import com.ibm.academia.apirest.TarjetasCreditoREST.datos.DatosDummy;
import com.ibm.academia.apirest.TarjetasCreditoREST.entities.Tarjeta;
import com.ibm.academia.apirest.TarjetasCreditoREST.enums.Passion;
import com.ibm.academia.apirest.TarjetasCreditoREST.repositories.TarjetaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestTarjetaDAOImpl {

    TarjetaDAO tarjetaDAO;
    TarjetaRepository tarjetaRepository;

    @BeforeEach
    void setUp(){
        tarjetaRepository=mock(TarjetaRepository.class);
        tarjetaDAO = new TarjetaDAOImpl(tarjetaRepository);
    }
    @Test
    @DisplayName("Test buscar tarjetas")
    void buscarTarjetasTest(){
        Passion passion= Passion.HELP;
        Double salary=20000.0;
        Integer age=20;
        when(tarjetaRepository.encontrarTarjetas(passion,salary,age)).thenReturn(Arrays.asList(DatosDummy.tarjeta01(),DatosDummy.tarjeta02()));

        List<Tarjeta> tarjetas= (List<Tarjeta>) tarjetaRepository.encontrarTarjetas(passion,salary,age);

        assertThat(tarjetas.size()==2);

    }
}
