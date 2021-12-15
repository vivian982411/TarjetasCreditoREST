package com.ibm.academia.apirest.TarjetasCreditoREST.controllers;

import com.ibm.academia.apirest.TarjetasCreditoREST.dto.PerfilDTO;
import com.ibm.academia.apirest.TarjetasCreditoREST.entities.Tarjeta;
import com.ibm.academia.apirest.TarjetasCreditoREST.enums.Passion;
import com.ibm.academia.apirest.TarjetasCreditoREST.exceptions.BadRequestException;
import com.ibm.academia.apirest.TarjetasCreditoREST.exceptions.NotFoundException;
import com.ibm.academia.apirest.TarjetasCreditoREST.services.TarjetaDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("card")
@Api(value = "Metodos relacionados con las tarjetas", tags = "Acciones sobre las tarjetas")
public class CardController {

    @Autowired
    private TarjetaDAO tarjetaDAO;

    /**
     *  Endpoint para encontrar las tarjetas de credito que más se adecuen al perfil de una persona
     * @param perfilDTO datos del usuario que se van a evaluar
     * @param result
     * @return Listado de Tarjetas que el usuario puede obtener
     * @BadRequest cuando se los datos ingresados no son validos
     * @NotFoundException si no se encuentran tarjetas que se adecuen a este perfil
     * @author Vivian Juarez 10/12/2021
     */
    @ApiOperation(value = "Consultar las tarjetas disponibles para un perfil de usuario")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ejecutado Exitosamente"),
            @ApiResponse(code = 404, message = "No se encontraron tarjetas para este perfil"),
            @ApiResponse(code = 400, message = "Peticion realizada de forma equivocada")
    })
    @GetMapping("/findCard")
    public ResponseEntity<?> findCard(@RequestBody PerfilDTO perfilDTO, BindingResult result){

        Map<String,Object> validaciones=new HashMap<>();
        if(result.hasErrors()){

            List<String> listaErrores= result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: '" +errores.getField() +"' " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista Errores",listaErrores);
            throw new BadRequestException(validaciones.toString());
        }else{
            List<Tarjeta> tarjetas = tarjetaDAO.findCard(perfilDTO.getPassion(), perfilDTO.getSalary(), perfilDTO.getAge());
            if (tarjetas.isEmpty())
                throw new NotFoundException(String.format("No existen Tarjetas para este perfil"));

            return new ResponseEntity<>(tarjetas,HttpStatus.OK);
        }
    }
}
