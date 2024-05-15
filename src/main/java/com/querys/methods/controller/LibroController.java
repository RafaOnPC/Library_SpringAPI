package com.querys.methods.controller;

import com.querys.methods.dto.LibroDTO;
import com.querys.methods.errors.LibroNotFoundException;
import com.querys.methods.service.LibroService;
import jakarta.validation.Valid;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/libros")
    public ResponseEntity<List<LibroDTO>> getLibros(){
        return new ResponseEntity<>(libroService.getLibros(), HttpStatus.OK);
    }

    @GetMapping("/libros/{libroId}")
    public ResponseEntity<Object> getLibro(@PathVariable Long libroId) throws LibroNotFoundException {
        return new ResponseEntity<>(libroService.getLibro(libroId), HttpStatus.OK);
    }

    @PostMapping("/libros")
    public ResponseEntity<Object> storeLibro(@Valid @RequestBody LibroDTO libroDTO){
        return new ResponseEntity<>(libroService.saveLibro(libroDTO), HttpStatus.CREATED);
    }

    @PutMapping("/libros/{libroId}")
    public ResponseEntity<Object> updateLibro(@Valid @PathVariable Long libroId, @Valid @RequestBody LibroDTO libroDTO) throws LibroNotFoundException{
        return new ResponseEntity<>(libroService.updateLibro(libroId, libroDTO), HttpStatus.OK);
    }

    @DeleteMapping("/libros/{libroId}")
    public ResponseEntity<Object> deleteLibro(@Valid @PathVariable Long libroId) throws LibroNotFoundException{
        return new ResponseEntity<>(libroService.deleteLibro(libroId), HttpStatus.OK);
    }

    @GetMapping("/libros/all")
    public ResponseEntity<Object> getLibrosFilter(@RequestParam String filtro){
        return new ResponseEntity<>(libroService.getLibrosFilter(filtro), HttpStatus.OK);
    }

    @GetMapping("/libros/query")
    public ResponseEntity<Object> getLibrosFilterQuery(@RequestParam String filtro){
        return new ResponseEntity<>(libroService.getLibrosQuery(filtro), HttpStatus.OK);
    }

}
