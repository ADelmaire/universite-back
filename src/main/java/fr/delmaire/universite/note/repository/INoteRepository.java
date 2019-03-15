package fr.delmaire.universite.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delmaire.universite.note.domain.Note;
import fr.delmaire.universite.note.domain.NotePK;

@Repository
public interface INoteRepository extends JpaRepository<Note, NotePK>{

}
