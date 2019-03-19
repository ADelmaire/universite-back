package fr.delmaire.universite.note.controller;

import java.util.List;

import fr.delmaire.universite.note.domain.Note;

public interface INoteController {

	public List<Note> findAll();

	public Note findOne (Integer idEtudiant, Integer idMatiere);

}
