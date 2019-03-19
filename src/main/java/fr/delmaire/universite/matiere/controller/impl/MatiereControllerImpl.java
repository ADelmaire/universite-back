package fr.delmaire.universite.matiere.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.delmaire.universite.matiere.controller.IMatiereController;
import fr.delmaire.universite.matiere.domain.Matiere;
import fr.delmaire.universite.matiere.service.impl.MatiereServiceImpl;


@RestController
public class MatiereControllerImpl implements IMatiereController{
	
	@Autowired
	MatiereServiceImpl matiereService;

	@Override
	@GetMapping ("/matieres")
	public List<Matiere> findAll() {
		List<Matiere> liste = matiereService.findAll();
		return liste;
	}

	@Override
	@GetMapping("/matieres/{id}")
	public Matiere findOne(@PathVariable Integer id) {
		Matiere m = matiereService.findOne(id);
		return m;
	}

	@Override
	@PostMapping("/matieres")
	public Matiere save(@RequestBody Matiere matiere) {
		Matiere m = matiereService.save(matiere);
		return m;
	}

	@Override
	@PutMapping("/matieres/{id}")
	public Matiere update(@RequestBody Matiere matiere, @PathVariable Integer id) {
			matiere.setId(id);
			Matiere m = matiereService.saveModif(matiere);
			return m;
	}

}
