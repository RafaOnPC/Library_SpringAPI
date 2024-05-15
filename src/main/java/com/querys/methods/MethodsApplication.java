package com.querys.methods;

import com.querys.methods.conexion.ConnectionTest;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MethodsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MethodsApplication.class, args);
        ConnectionTest connectionTest = context.getBean(ConnectionTest.class);
        connectionTest.run();
    }
}

