package com.ibm.academia.apirest.TarjetasCreditoREST.dto.request;

import com.ibm.academia.apirest.TarjetasCreditoREST.enums.Passion;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
@Data
public class FindCardRequest {
    private Passion passion;
    private Double salary;
    private Integer age;
}
