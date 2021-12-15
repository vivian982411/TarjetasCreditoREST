package com.ibm.academia.apirest.TarjetasCreditoREST.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxSwagger {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ibm.academia.apirest.TarjetasCreditoREST"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Tarjetas de Credito Backend API",
                "API para encontrar una tarjeta que corresponda a un perfil",
                "V1",
                "Terminos del servicio",
                new Contact("Vivian Juarez", "https://github.com/vivian982411", "vivian982411@gmail.com"),
                "Licencia de API", "API licencia URL", Collections.emptyList()
        );
    }
}
