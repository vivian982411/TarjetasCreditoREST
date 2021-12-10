package com.ibm.academia.apirest.TarjetasCreditoREST.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tarjetas", schema = "tarjetas")
public class Tarjeta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", unique = true, nullable = false, length = 80)
    private String nombre;

    @ManyToMany(mappedBy = "tarjetas", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Perfil> perfiles;

    public Tarjeta(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
