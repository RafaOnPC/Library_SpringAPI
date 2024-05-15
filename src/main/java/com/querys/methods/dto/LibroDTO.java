package com.querys.methods.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO{

    private Long id;

    @NotNull(message = "El autor NO puede ser nulo")
    @NotBlank(message = "El autor NO puede ser un espacio en blanco")
    private String autor;

    @NotNull(message = "El libro NO puede ser nulo")
    @NotBlank(message = "El libro NO puede ser un espacio en blanco")
    private String libro;
}
