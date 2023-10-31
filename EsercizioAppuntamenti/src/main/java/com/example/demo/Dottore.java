package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Dottore {
	
	private Long idDottore;
	private String nome;
	private String cognome;
	private final Map<Long , Appuntamento> myAppuntamenti = new HashMap<>();
	private Long currentid = 1L;
	
	public Dottore(Long idDottore, String nome, String cognome) {
		super();
		this.idDottore = idDottore;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Dottore() {

	}
	
	public Appuntamento aggiungiAppuntamento(Appuntamento appuntamento) {
		appuntamento.setId(currentid++);
		myAppuntamenti.put(currentid, appuntamento);
		return appuntamento;
	}
	
	public Long getIdDottore() {
		return idDottore;
	}

	public void setIdDottore(Long idDottore) {
		this.idDottore = idDottore;
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

	public Map<Long, Appuntamento> getMyAppuntamenti() {
		return myAppuntamenti;
	}
	
	
	
	
}
