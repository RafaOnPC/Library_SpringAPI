package com.querys.methods.service;

import com.querys.methods.dto.LibroDTO;
import com.querys.methods.modelo.Libro;
import com.querys.methods.repository.LibroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibroServiceTest {

    @Autowired
    private LibroService libroService;

    @MockBean
    private LibroRepository libroRepository;

    @BeforeEach
    void setUp() {
        Libro libro = Libro.builder()
                .autor("Jane Austen")
                .libro("Orgullo & Prejuicio")
                .build();

        Libro libro2 = Libro.builder()
                .autor("Alexander Dumas")
                .libro("Los tres mosqueteros")
                .build();

        List<Libro> libroList = new ArrayList<>();
        libroList.add(libro);
        libroList.add(libro2);

        List<Libro> libroListQuery = new ArrayList<>();
        libroListQuery.add(libro2);


        //Mockito.when(libroRepository.findById(1L)).thenReturn(Optional.of(libro));
        Mockito.when(libroRepository.search("A")).thenReturn(libroList);
        Mockito.when(libroRepository.searchQuery("A")).thenReturn(libroListQuery);
    }

    @Test
    @DisplayName("Busqueda para consultar si contiene el caracter especificado")
    public void findBook(){
        List<LibroDTO> libroList = libroService.getLibrosFilter("A");
    }

    @Test
    @DisplayName("Busqueda por un primer caracter especifico")
    public void findRegisterFirstLetterChosen(){
        List<LibroDTO> libroList = libroService.getLibrosQuery("A");
    }
}