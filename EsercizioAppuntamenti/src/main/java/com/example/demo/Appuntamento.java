package com.example.demo;

import java.time.LocalDate;


public class Appuntamento {
 
	private Long id; 
	private LocalDate dataEOra;
	private String nomeCliente;
	private String descrizione;
	
	
	
	
	public Appuntamento(Long id, LocalDate dataEOra, String nomeCliente, String descrizione) {
		this.id = id;
		this.dataEOra = dataEOra;
		this.nomeCliente = nomeCliente;
		this.descrizione = descrizione;
	}
	
	public Appuntamento() {

	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataEOra() {
		return dataEOra;
	}
	public void setDataEOra(LocalDate dataEOra) {
		this.dataEOra = dataEOra;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
