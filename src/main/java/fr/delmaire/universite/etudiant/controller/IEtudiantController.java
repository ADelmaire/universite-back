package fr.delmaire.universite.etudiant.controller;

import java.util.List;

import org.springframework.ui.Model;

import fr.delmaire.universite.enseignant.domain.Enseignant;
import fr.delmaire.universite.etudiant.domain.Etudiant;

public interface IEtudiantController {
	
	public List<Etudiant> findAll ();

	public Etudiant findOne (Integer id);
	
	public Etudiant save (Etudiant etudiant);
	
	public String modifierEtudiantFormulaire(Model model, Integer id);

	public String validerModification(Model model, Etudiant etudiant);
	
}
