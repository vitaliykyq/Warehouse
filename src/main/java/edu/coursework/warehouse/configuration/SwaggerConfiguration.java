package edu.coursework.warehouse.configuration;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    SwaggerConfiguration
    @version:    1.0.0
    @since:    14.04.2021
*/

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    //@Bean
    public OpenAPI warehouseOpenApi(){

        return new OpenAPI().
                info(
                        new Info()
                                .title("Курсовий проект")
                                .version("1.0")
                                .contact(new Contact()
                                        .name("Sasha")
                                        .url("my-site.cv.ua"))

                );
    }
}
