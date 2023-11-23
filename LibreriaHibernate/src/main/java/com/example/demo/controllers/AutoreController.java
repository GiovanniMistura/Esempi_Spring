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

import com.example.demo.models.Autore;
import com.example.demo.services.AutoreService;

@RestController
@RequestMapping("/autore")
public class AutoreController {
	
	@Autowired 
	private AutoreService autoreService;
	
	
	// Get mappings
	@GetMapping
	public Collection<Autore> listaAutori() {
		return autoreService.mostraTutti();
	}
	
	@GetMapping("/{id}")
	public Autore ottieniAutore(@PathVariable Long id) {
		return autoreService.trova(id);
	}
	
	//Post mappings
	@PostMapping
	public Autore aggiungiAutore(@RequestBody Autore autore) {
		return autoreService.aggiungi(autore);
	}
	
	//Put mappings
	@PutMapping("/{id}")
	public Autore modificaLibro(@RequestBody Autore autore , @PathVariable Long id){
		return autoreService.modifica(autore, id);
	}
	
	@PutMapping("/{autoreId}/libro/{libroId}")
	public Autore aggiungiLibro(@PathVariable Long autoreId , @PathVariable Long libroId) {
		return autoreService.aggiungiLibro(autoreId,libroId);
	}
	
	//Delete mappings
	@DeleteMapping("/{id}")
	public void eliminaAutore(@PathVariable Long id) {
		autoreService.elimina(id);
	}
	
	
}
