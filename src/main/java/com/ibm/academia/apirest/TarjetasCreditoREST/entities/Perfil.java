package com.ibm.academia.apirest.TarjetasCreditoREST.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibm.academia.apirest.TarjetasCreditoREST.enums.Passion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "perfiles", schema = "tarjetas")
public class Perfil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pasion")
    @Enumerated(EnumType.STRING)
    private Passion pasion;

    @Column(name = "minimo_salario")
    private Double minimoSalario;

    @Column(name = "maximo_salario")
    private Double maximoSalario;

    @Column(name = "minimo_edad")
    private Integer minimoEdad;

    @Column(name = "maximo_edad")
    private Integer maximoEdad;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "perfil_tarjeta",
            schema = "tarjetas",
            joinColumns = @JoinColumn(name = "perfil_id"),
            inverseJoinColumns = @JoinColumn(name = "tarjeta_id")
    )
    @JsonIgnore
    private Set<Tarjeta> tarjetas;

    public Perfil(Integer id, Passion pasion, Double minimoSalario, Double maximoSalario, Integer minimoEdad, Integer maximoEdad) {
        this.id = id;
        this.pasion = pasion;
        this.minimoSalario = minimoSalario;
        this.maximoSalario = maximoSalario;
        this.minimoEdad = minimoEdad;
        this.maximoEdad = maximoEdad;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", pasion=" + pasion +
                ", minimoSalario=" + minimoSalario +
                ", maximoSalario=" + maximoSalario +
                ", minimoEdad=" + minimoEdad +
                ", maximoEdad=" + maximoEdad +
                '}';
    }

}
