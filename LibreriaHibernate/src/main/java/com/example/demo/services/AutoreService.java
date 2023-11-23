package com.example.demo.services;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Autore;
import com.example.demo.models.Libro;
import com.example.demo.repositories.AutoreRepository;
import com.example.demo.repositories.LibroRepository;


@Service
public class AutoreService {
	
	@Autowired
	private AutoreRepository autori;
	
	@Autowired
	private LibroRepository libri;
	
	//mostra tutti gli autori
	public Collection<Autore> mostraTutti() {
		return autori.findAll();
	}
	
	//visualizza specifico autore
	public Autore trova(Long id) {
		return autori.findById(id).get();
	}
	
	//aggiungi autore
	public Autore aggiungi(Autore autore) {		
		return autori.save(autore);
	}
	
	//modifica autore
	public Autore modifica(Autore autore , Long id) {
		Optional<Autore> checkAutore = autori.findById(id);
		Autore a = null;
		if (checkAutore.isPresent()) {
			a = checkAutore.get();
			a.setNome(autore.getNome());
			a.setCognome(autore.getCognome());
			a.setLibri(autore.getLibri());
			return autori.save(a);
		}
		return a;
	}
		
	//elimina specifico autore
	public void elimina(Long id) {
		autori.deleteById(id);
	}
	
	//aggiungi libro ad autore
	public Autore aggiungiLibro(Long autoreId, Long libroId) {
		
		Set<Libro> libriSet = null;

		Autore a = autori.findById(autoreId).get(); 
		Libro l = libri.findById(libroId).get();
		
		libriSet = a.getLibri();
		libriSet.add(l);
		
		a.setLibri(libriSet);

		return autori.save(a);	
	}
}
