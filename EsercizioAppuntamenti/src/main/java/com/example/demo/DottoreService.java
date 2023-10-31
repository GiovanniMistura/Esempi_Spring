package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DottoreService {
	
	@Autowired
	private AppuntamentoService appuntamentiService;
	
	
	private final Map<Long , Dottore> dottori = new HashMap<>();
	private Long currentid = 1L;
	
	public Appuntamento aggiungiAppuntamento(Long idApp, Long idDott) {
		Dottore temp = dottori.get(idDott);
		if (appuntamentiService.ottieniAppuntamento(idApp) != null) {
			temp.aggiungiAppuntamento(appuntamentiService.ottieniAppuntamento(idApp));
			return appuntamentiService.ottieniAppuntamento(idApp);
		} else {
			return null;
		}
	}
	
	public Dottore aggiungiDottore(Dottore dottore) {
		dottore.setIdDottore(currentid++);
		dottori.put(currentid, dottore);
		return dottore;
	}
	
	public Dottore ottieniDottore(Long id) {
		return dottori.get(id);
	}
	
	public Map<Long , Appuntamento> ottieniTuttiAppuntamenti(Long id) {
		Dottore temp = dottori.get(id);
		return temp.getMyAppuntamenti();
	}
	
	public void eliminaDottore(Long id) {
		dottori.remove(id);
	}
}
