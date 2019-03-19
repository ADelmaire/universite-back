package fr.delmaire.universite.etudiant.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@Override
	@GetMapping("/modifier-etudiant")
	public String modifierEtudiantFormulaire(Model model, @RequestParam("id") Integer id) {
			Etudiant e = etudiantService.findOne(id);
			model.addAttribute("etudiant", e);
			return "etudiant/modifier-etudiant-formulaire";
	}

	@Override
	@PostMapping("valider-modification-etudiant")
	public String validerModification(Model model, @ModelAttribute ("etudiant") Etudiant etudiant) {
			Etudiant e = etudiantService.sauvegardeModif(etudiant);
			if(e == null) {
				return "redirect:/modifier-etudiant";
			}else {
				return "redirect:/etudiants";
			}
	}

}
