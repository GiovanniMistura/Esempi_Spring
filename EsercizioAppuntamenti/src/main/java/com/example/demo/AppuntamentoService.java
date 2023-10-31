package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AppuntamentoService {
	
	private final Map<Long , Appuntamento> appuntamenti = new HashMap<>();
	private Long currentid = 1L;
	
	public Appuntamento aggiungiAppuntamento(Appuntamento appuntamento) {
		appuntamento.setId(currentid++);
		appuntamenti.put(currentid, appuntamento);
		return appuntamento;
	}
	
	public Collection<Appuntamento> prendiAppuntamenti() {
		return appuntamenti.values();
	}
	
	public Appuntamento ottieniAppuntamento(Long id) {
		return appuntamenti.get(id);
	}
	
	public Appuntamento aggiornaAppuntamento(Long id, Appuntamento appuntamento) {
		if (appuntamenti.containsKey(id)) {
			appuntamento.setId(id);
			appuntamenti.put(id, appuntamento);
			return appuntamento;
		}
		
		return null;
	}
	
	public void eliminaAppuntamento(Long id) {
		appuntamenti.remove(id);
	}
}
