package com.example.demo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Libro;
import com.example.demo.services.LibroService;


@RestController
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	//Get mappings
	@GetMapping
	public Collection<Libro> listaLibri() {
		return libroService.mostraTutti();
	}
	
	@GetMapping("/{id}")
	public Libro ottieniLibro(@PathVariable Long id) {
		return libroService.trova(id);
	}
	
	//Post mappings
	@PostMapping
	public Libro nuovoLibro(@RequestBody Libro libro) {
	        return libroService.aggiungi(libro);
	}
	
	//Put mappings
	@PutMapping("/{id}")
	public Libro modificaLibro(@RequestBody Libro libro , @PathVariable Long id){
		return libroService.modifica(libro, id);
	}
	
	//Delete mappings
	@DeleteMapping("/{id}")
	public void eliminaLibro(@PathVariable Long id) {
	        libroService.elimina(id);
	    }
	
}
