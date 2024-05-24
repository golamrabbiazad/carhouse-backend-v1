package com.golamrabbiazad.fullstackcarhouse;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .scheme("bearer");
    }

    @Bean
    public OpenAPI carDatabaseOpenApi() {
        return new OpenAPI()
                .specVersion(SpecVersion.V31)
                .components(new Components().
                        addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info()
                        .title("Car REST API")
                        .description("Car Stock")
                        .version("1.0")
                        .license(new License().name("MIT"))
                )
                .addTagsItem(new Tag().name("car"));
    }
}
