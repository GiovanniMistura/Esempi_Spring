package com.example.demo.models;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String titolo;
	
	private String genere;
	
	@ManyToMany(mappedBy = "libri", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Autore> autori = new HashSet<>();
	

	//Costruttori
	//Vuoto
	public Libro() {
		
	}
	//con parametri
	public Libro(String titolo, String genere) {
		this.titolo = titolo;
		this.genere = genere;
	}

	
	// setters and getters
	public Long getId() {
		return id;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Set<Autore> getAutori() {
		return autori;
	}

	public void setAutori(Set<Autore> autori) {
		this.autori = autori;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
		
}
