package com.example.demo.services;


import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Libro;
import com.example.demo.repositories.LibroRepository;

@Service
public class LibroService {
		
		@Autowired
		private LibroRepository libri;
		
		//mostra tutti i libri
		public Collection<Libro> mostraTutti() {
			return libri.findAll();
		}
		
		//visualizza libro specifico
		public Libro trova(Long id) {
			return libri.findById(id).get();
		}
		
		//aggiungi libro
		public Libro aggiungi(Libro libro) {		
			return libri.save(libro);
		}
		
		//modifica libro
		public Libro modifica(Libro libro , Long id) {
			Optional<Libro> checkLibro = libri.findById(id);
			Libro l = null;
			if (checkLibro.isPresent()) {
				l = checkLibro.get();
				l.setTitolo(libro.getTitolo());
				l.setGenere(libro.getGenere());
				l.setAutori(libro.getAutori());
				return libri.save(l);
			}
			return libro;
		}
				
		//elimina libro
		public void elimina(Long id) {
			libri.deleteById(id);
		}
}
