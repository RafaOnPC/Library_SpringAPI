package com.querys.methods.controller;

import com.querys.methods.dto.LibroDTO;
import com.querys.methods.modelo.Libro;
import com.querys.methods.service.LibroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LibroController.class)
class LibroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibroService libroService;

    private LibroDTO libroDTO;

    @BeforeEach
    void setUp() {
        libroDTO = libroDTO.builder()
                .id(1L)
                .autor("Jane Austen")
                .libro("Orgullo & Prejuicio")
                .build();
    }

    @Test
    public void findBook() throws Exception{
        Mockito.when(libroService.getLibro(1L)).thenReturn(libroDTO);
        mockMvc.perform(get("/api/libros/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.libro").value(libroDTO.getLibro()));
    }
}