package fr.delmaire.universite.etudiant.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.delmaire.universite.etudiant.controller.IEtudiantController;
import fr.delmaire.universite.etudiant.domain.Etudiant;
import fr.delmaire.universite.etudiant.service.impl.EtudiantServiceImpl;

@RestController
public class EtudiantControllerImpl implements IEtudiantController{
	
	@Autowired
	EtudiantServiceImpl etudiantService;

	@Override
	@GetMapping("/etudiants")
	public List<Etudiant> findAll() {
		List<Etudiant> liste = etudiantService.findAll();
		return liste;
	}

	@Override
	@GetMapping("/etudiants/{id}")
	public Etudiant findOne(@PathVariable Integer id) {
		Etudiant e = etudiantService.findOne(id);
		return e;
	}

	@Override
	@PostMapping("/etudiants")
	public Etudiant save(@RequestBody Etudiant etudiant) {
		Etudiant e = etudiantService.sauvegardeAjout(etudiant);
		return e;
	}

}
