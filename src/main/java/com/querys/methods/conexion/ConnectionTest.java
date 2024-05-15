package com.querys.methods.conexion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConnectionTest{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ConnectionTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void run() {
        try {
            jdbcTemplate.getDataSource().getConnection(); // Intenta obtener una conexión
            System.out.println("Conexión exitosa!");
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}