package com.querys.methods.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

@ApiModel(description = "Details about a book")
public class Libro {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @ApiModelProperty(notes = "The ID of each book")
    private Long id;

    @ApiModelProperty(notes = "The name of the autor of each book")
    @Column(name = "nombre_autor", nullable = false, length = 100)
    private String autor;

    @ApiModelProperty(notes = "The name of the book", example = "The Hunger Games")
    @Column(name = "nombre_libro", nullable = false, length = 100)
    private String libro;
}
