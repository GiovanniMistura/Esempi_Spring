package com.example.demo.models;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cognome;
	
	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable(
			name="autore_libro",
			joinColumns=@JoinColumn(name="autore_id"),
			inverseJoinColumns=@JoinColumn(name="libro_id")
			)
	private Set<Libro> libri = new HashSet<>();
	
	//Costruttori
	//vuoto
	public Autore() {
		
	}
	//con parametri
	public Autore(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	

	// setters and getter
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Set<Libro> getLibri() {
		return libri;
	}

	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}
	
	
	
}
