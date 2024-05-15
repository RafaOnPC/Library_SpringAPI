package com.querys.methods.repository;

import com.querys.methods.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query(value = "SELECT l FROM Libro l WHERE l.autor LIKE %:filtro%")
    List<Libro> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM libro WHERE libro.nombre_autor LIKE :filtro%",
            nativeQuery = true
    )
    List<Libro> searchQuery(@Param("filtro") String filtro);
}
