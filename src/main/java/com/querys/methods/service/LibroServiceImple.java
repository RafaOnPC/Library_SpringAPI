package com.querys.methods.service;

import com.querys.methods.dto.LibroDTO;
import com.querys.methods.errors.LibroNotFoundException;
import com.querys.methods.mapper.LibroMapper;
import com.querys.methods.modelo.Libro;
import com.querys.methods.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImple implements LibroService{

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private LibroMapper libroMapper;

    @Override
    public LibroDTO saveLibro(LibroDTO libroDTO) {
        Libro libro = libroRepository.save(libroMapper.toLibro(libroDTO));
        return libroMapper.toLibroDTO(libro);
    }

    @Override
    public LibroDTO getLibro(Long libroId) throws LibroNotFoundException {
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado"));
        return libroMapper.toLibroDTO(libro);
    }

    @Override
    public List<LibroDTO> getLibros() {
        return libroMapper.toListLibroDTO(libroRepository.findAll());
    }

    @Override
    public LibroDTO updateLibro(Long libroId, LibroDTO libroDTO) throws LibroNotFoundException{
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado"));
        libroMapper.updateLibroEntitys(libro, libroDTO);
        return libroMapper.toLibroDTO(libroRepository.save(libro));
    }

    @Override
    public LibroDTO deleteLibro(Long libroId) throws LibroNotFoundException{
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado"));
        libroRepository.deleteById(libroId);
        return libroMapper.toLibroDTO(libro);
    }

    @Override
    public List<LibroDTO> getLibrosFilter(String filter) {
        return libroMapper.toListLibroDTO(libroRepository.search(filter));
    }

    @Override
    public List<LibroDTO> getLibrosQuery(String filter) {
        return libroMapper.toListLibroDTO(libroRepository.searchQuery(filter));
    }
}
