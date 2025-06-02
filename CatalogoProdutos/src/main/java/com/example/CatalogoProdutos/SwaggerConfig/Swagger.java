package com.example.CatalogoProdutos.SwaggerConfig;

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
                        .title("API de Rações ou catalogo de produtos - PetShop")
                        .version("1.0")
                        .description("Documentação da API responsável pela gestão de produtos(Rações) no sistema PetShop."));
    }
}
