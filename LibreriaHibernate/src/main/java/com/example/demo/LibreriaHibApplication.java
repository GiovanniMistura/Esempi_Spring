package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Autore;
import com.example.demo.models.Libro;
import com.example.demo.services.AutoreService;
import com.example.demo.services.LibroService;

@SpringBootApplication
public class LibreriaHibApplication implements CommandLineRunner{
	
	@Autowired
	private LibroService libroService;
	
	@Autowired 
	private AutoreService autoreService;

	public static void main(String[] args) {
		SpringApplication.run(LibreriaHibApplication.class, args);
	}
	
	public void run(String...args) throws Exception {
		
		
		Libro l1 = new Libro("Alice","Fantasy");
		Libro l2 = new Libro("Alice 2","Fantasy");
		
		Autore a1 = new Autore("Lewis","Carol");
		
		libroService.aggiungi(l1);
		libroService.aggiungi(l2);
		
		
		autoreService.aggiungi(a1);
		
		// to use add: fetch = FetchType.EAGER in ManyToMany
		//autoreService.aggiungiLibro( a1.getId(),l1.getId());

		
		
		
		
		
	}
}
