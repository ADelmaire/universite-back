package fr.delmaire.universite.note.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.delmaire.universite.note.controller.INoteController;
import fr.delmaire.universite.note.domain.Note;
import fr.delmaire.universite.note.service.impl.NoteServiceImpl;

@RestController
public class NoteControllerImpl implements INoteController{

	@Autowired
	NoteServiceImpl noteService;

	@Override
	@GetMapping ("/notes")
	public List<Note> findAll() {
		List<Note> liste = noteService.findAll();
		return liste;
	}

	@Override
	@GetMapping("/notes/{idEtudiant}/{idMatiere}")
	public Note findOne(@PathVariable Integer idEtudiant, @PathVariable Integer idMatiere) {
		Note n = noteService.findOne(idEtudiant, idMatiere);
		return n;
	}
	
}
