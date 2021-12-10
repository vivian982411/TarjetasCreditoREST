package com.ibm.academia.apirest.TarjetasCreditoREST.dto;

import com.ibm.academia.apirest.TarjetasCreditoREST.enums.Passion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilDTO {
    @Valid
    @NotEmpty
    @NotNull
    private Passion passion;
    @Positive
    private Double salary;
    @Positive
    @Min(5)
    @Max(75)
    private Integer age;
}
