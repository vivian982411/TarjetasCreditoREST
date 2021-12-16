package com.ibm.academia.apirest.TarjetasCreditoREST.services;

import com.ibm.academia.apirest.TarjetasCreditoREST.entities.Tarjeta;
import com.ibm.academia.apirest.TarjetasCreditoREST.enums.Passion;
import com.ibm.academia.apirest.TarjetasCreditoREST.exceptions.NotFoundException;
import com.ibm.academia.apirest.TarjetasCreditoREST.repositories.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TarjetaDAOImpl extends GenericoDAOImpl<Tarjeta,TarjetaRepository> implements TarjetaDAO {
    @Autowired
    public TarjetaDAOImpl(TarjetaRepository repository)
    {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Tarjeta> encontrarTarjetas(Passion passion, Double salario, Integer edad) {
        return repository.encontrarTarjetas(passion,salario,edad);
    }

    @Override
    public List<Tarjeta> findCard(Passion passion, Double salary, Integer age) throws com.ibm.academia.apirest.TarjetasCreditoREST.exceptions.NotFoundException {

        if (salary<7000)
            throw new NotFoundException("No existen tarjetas con un salario por debajo de 7000");
        if (age<18)
            throw new NotFoundException("No existen tarjetas para menores de edad");
        if (age>80)
            throw new NotFoundException("No existen tarjetas para mayores de 80");

        List<Tarjeta> tarjetas = (List<Tarjeta>) encontrarTarjetas(passion,salary,age);
        return tarjetas;
    }
}
