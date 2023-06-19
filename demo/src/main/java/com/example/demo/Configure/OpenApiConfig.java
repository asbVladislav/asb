package com.example.demo.Configure;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Rates System Api",
                description = "Rates System", version = "1.0.0",
                contact = @Contact(
                        name = "Naidzin Vladislau",
                        email = "v171577v@gmail.com"
                )
        )
)
public class OpenApiConfig {

}