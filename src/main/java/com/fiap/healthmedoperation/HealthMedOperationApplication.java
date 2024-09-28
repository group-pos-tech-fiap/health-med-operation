package com.fiap.healthmedoperation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Health Med OPERATION - FIAP", description = "Microservico responsavel pelas operações (agendamentos)", version = "v1"))
public class HealthMedOperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthMedOperationApplication.class, args);
    }

}
