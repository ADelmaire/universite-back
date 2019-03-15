package fr.delmaire.universite.enseignant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.delmaire.universite.enseignant.controller.IEnseignantController;
import fr.delmaire.universite.enseignant.domain.Enseignant;
import fr.delmaire.universite.enseignant.service.impl.EnseignantServiceImpl;

@RestController
public class EnseignantControllerImpl implements IEnseignantController{

	Logger log = LoggerFactory.getLogger(EnseignantControllerImpl.class);
	
	@Autowired
	EnseignantServiceImpl enseignantService;
	
	@Override
	@GetMapping("/enseignants")
	public List<Enseignant> findAll() {
	List<Enseignant> liste = enseignantService.findAll();	
	
	log.info("nombre des enseignants: {}", liste.size());
	
		return liste;
	}

	@Override
	@GetMapping("/enseignants/{id}")
	// convention sur l'url
	public Enseignant findOne(@PathVariable Integer id) {
		Enseignant e = enseignantService.findOne(id);
		return e;
	}

	@Override
	@PostMapping("/enseignants")
	//findAll et save ont la même url, un en get et l'autre en post
	public Enseignant save(@RequestBody Enseignant enseignant) {
		// ds le corps de la requête
		// le body en JSON est envoyé comme une pièce jointe avec le header puis transformé 
		// en objet java
		Enseignant e = enseignantService.sauvegarder(enseignant);
		return e;
	}

	@Override
	@DeleteMapping("/enseignants/{id}")
	public void delete(@PathVariable Integer id) {
		enseignantService.supprimer(id);
	}

	@Override
	@PutMapping("/enseignants/{id}")
	public Enseignant update(@RequestBody Enseignant enseignant, @PathVariable Integer id) {
		enseignant.setId(id);
		Enseignant e = enseignantService.modifier(enseignant);
		return e;
	}

}
