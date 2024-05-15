package com.querys.methods.mapper;

import com.querys.methods.dto.LibroDTO;
import com.querys.methods.modelo.Libro;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibroMapperImple implements LibroMapper{
    @Override
    public LibroDTO toLibroDTO(Libro libro) {
        if(libro == null){
            return null;
        }

        return LibroDTO.builder()
                .id(libro.getId())
                .autor(libro.getAutor())
                .libro(libro.getLibro())
                .build();
    }

    @Override
    public Libro toLibro(LibroDTO libroDTO) {
        if(libroDTO == null){
            return null;
        }

        return Libro.builder()
                .id(libroDTO.getId())
                .autor(libroDTO.getAutor())
                .libro(libroDTO.getLibro())
                .build();
    }

    @Override
    public List<LibroDTO> toListLibroDTO(List<Libro> libroList) {
        List<LibroDTO> libroDTOList = new ArrayList<>(libroList.size());
        for(Libro libro: libroList){
            libroDTOList.add(toLibroDTO(libro));
        }
        return libroDTOList;
    }

    @Override
    public void updateLibroEntitys(Libro libro, LibroDTO libroDTO) {
        if(libroDTO == null){
            return;
        }

        libro.setId(libroDTO.getId());
        libro.setAutor(libroDTO.getAutor());
        libro.setLibro(libroDTO.getLibro());
    }
}
