package com.example.Usuario.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Usuario/Cliente - PetShop")
                        .version("1.0")
                        .description("Documentação da API responsável pela gestão de usuarios no sistema PetShop."));
    }
}
