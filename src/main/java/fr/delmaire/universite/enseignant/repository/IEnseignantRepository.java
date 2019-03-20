package fr.delmaire.universite.enseignant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delmaire.universite.enseignant.domain.Enseignant;

@Repository
public interface IEnseignantRepository extends JpaRepository<Enseignant, Integer>{

	//recherche
	//chaine pour tt ce qu'on peut donner en parametre
	List<Enseignant>findEnseignantByNomContains(String chaine);
	
}
