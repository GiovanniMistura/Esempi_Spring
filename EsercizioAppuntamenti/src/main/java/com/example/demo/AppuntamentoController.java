package com.example.demo;

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

@RestController
@RequestMapping("/appuntamenti")
public class AppuntamentoController {

	@Autowired
	private AppuntamentoService appuntamentiService;
	
	@GetMapping
	public Collection<Appuntamento> listaAppuntamenti() {
		return appuntamentiService.prendiAppuntamenti();
	}
	
	@GetMapping("/{id}")
	public Appuntamento ottieniAppuntamento(@PathVariable Long id) {
		return appuntamentiService.ottieniAppuntamento(id);
	}
	

	@PostMapping
	public Appuntamento nuovoAppuntamento(@RequestBody Appuntamento appuntamento) {
	        return appuntamentiService.aggiungiAppuntamento(appuntamento);
	}

	@PutMapping("/{id}")
	public Appuntamento aggiornaAppuntamento(@PathVariable Long id, @RequestBody Appuntamento appuntamento) {
	        return appuntamentiService.aggiornaAppuntamento(id, appuntamento);
	    }

	@DeleteMapping("/{id}")
	public void eliminaAppuntamento(@PathVariable Long id) {
			appuntamentiService.eliminaAppuntamento(id);
	    }
}
