package com.querys.methods.repository;

import com.querys.methods.modelo.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LibroRepositoryTest {

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp(){
        Libro libro = Libro.builder()
                .autor("Jane Austen")
                .libro("Orgullo & Prejuicio")
                .build();

        Libro libro2 = Libro.builder()
                .autor("Alexander Dumas")
                .libro("Los tres mosqueteros")
                .build();


        testEntityManager.persist(libro);
        testEntityManager.persist(libro2);
    }

    @Test
    public void findBook(){
        Libro book = libroRepository.findById(1L).get();
        assertEquals(book.getLibro(), "Orgullo & Prejuicio");
        System.out.println("book = " + book);
    }
    
    @Test
    public void filterSearchAutorName(){
        List<Libro> libroList = libroRepository.search("A");
        System.out.println("libroList = " + libroList);
    }
    
    @Test
    public void filterSearchFirstLetterName(){
        List<Libro> libroList = libroRepository.searchQuery("A");
        System.out.println("libroList = " + libroList);
    }
    

}