package fr.delmaire.universite.matiere.controller;

import java.util.List;

import fr.delmaire.universite.matiere.domain.Matiere;

public interface IMatiereController {
	
	public List<Matiere> findAll();
	
	public Matiere findOne (Integer id);
	
	public Matiere save (Matiere matiere);
	
	public Matiere update(Matiere matiere, Integer id);

}
