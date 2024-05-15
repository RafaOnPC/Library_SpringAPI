package com.querys.methods.mapper;

import com.querys.methods.dto.LibroDTO;
import com.querys.methods.modelo.Libro;

import java.util.List;

public interface LibroMapper {

    public LibroDTO toLibroDTO(Libro libro);

    public Libro toLibro(LibroDTO libroDTO);

    public List<LibroDTO> toListLibroDTO(List<Libro> libroList);

    void updateLibroEntitys(Libro libro, LibroDTO libroDTO);
}
