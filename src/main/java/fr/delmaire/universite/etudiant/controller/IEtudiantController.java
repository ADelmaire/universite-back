package fr.delmaire.universite.etudiant.controller;

import java.util.List;

import fr.delmaire.universite.etudiant.domain.Etudiant;

public interface IEtudiantController {
	
	public List<Etudiant> findAll ();

	public Etudiant findOne (Integer id);
	
	public Etudiant save (Etudiant etudiant);
	
}
