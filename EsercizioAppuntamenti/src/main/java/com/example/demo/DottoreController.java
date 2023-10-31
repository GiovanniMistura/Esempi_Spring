package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dottore")
public class DottoreController {
	
	@Autowired
	private DottoreService dottoreService;
	
	
	@GetMapping("/{id}")
	public Dottore ottieniDottore(@PathVariable Long id) {
		return dottoreService.ottieniDottore(id);
	}
	
	@GetMapping("/{idApp}/{idDott}")
	public Appuntamento aggiungiAppuntamento(@PathVariable Long idApp, @PathVariable Long idDott) {
		return dottoreService.aggiungiAppuntamento(idApp, idDott);
	}
	
	@PostMapping
	public Dottore nuovoDottore(@RequestBody Dottore dottore) {
	        return dottoreService.aggiungiDottore(dottore);
	}


	@DeleteMapping("/{id}")
	public void eliminaAppuntamento(@PathVariable Long id) {
			dottoreService.eliminaDottore(id);
	    }
}
