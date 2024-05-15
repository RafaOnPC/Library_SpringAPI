package com.querys.methods.service;

import com.querys.methods.dto.LibroDTO;
import com.querys.methods.errors.LibroNotFoundException;

import java.util.List;

public interface LibroService {

    public LibroDTO saveLibro(LibroDTO libroDTO);

    public LibroDTO getLibro(Long libroId) throws LibroNotFoundException;

    public List<LibroDTO> getLibros();

    public LibroDTO updateLibro(Long libroId, LibroDTO libroDTO) throws LibroNotFoundException;

    public LibroDTO deleteLibro(Long libroId) throws LibroNotFoundException;

    public List<LibroDTO> getLibrosFilter(String filter);

    public List<LibroDTO> getLibrosQuery(String filter);
}
