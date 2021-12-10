package com.ibm.academia.apirest.TarjetasCreditoREST.repositories;

import com.ibm.academia.apirest.TarjetasCreditoREST.entities.Tarjeta;
import com.ibm.academia.apirest.TarjetasCreditoREST.enums.Passion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta, Integer> {
    @Query("select t from Tarjeta t join t.perfiles p where p.pasion=?1 and ?2 between p.minimoSalario and p.maximoSalario and ?3 between p.minimoEdad and p.maximoEdad ")
    public Iterable<Tarjeta> encontrarTarjetas(Passion passion,Double salario, Integer edad);
}
