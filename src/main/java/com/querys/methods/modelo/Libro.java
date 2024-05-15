package com.querys.methods.modelo;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Libro")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre_autor", nullable = false, length = 100)
    private String autor;

    @Column(name = "nombre_libro", nullable = false, length = 100)
    private String libro;
}
