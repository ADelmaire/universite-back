package fr.delmaire.universite.matiere.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.delmaire.universite.matiere.domain.Matiere;
import fr.delmaire.universite.matiere.repository.IMatiereRepository;
import fr.delmaire.universite.matiere.service.IMatiereService;

@Service
public class MatiereServiceImpl implements IMatiereService{
	
	Logger log = LoggerFactory.getLogger(MatiereServiceImpl.class);
	@Autowired IMatiereRepository mr;

	@Override
	public List<Matiere> findAll() {
		List<Matiere> liste = mr.findAll();
		return liste;
	}

	@Override
	public Matiere findOne(Integer id) {
		Matiere matiere = mr.getOne(id);
		return matiere;
	}

	@Override
	public Matiere save(Matiere matiere) {
		Matiere m = mr.save(matiere);
		return m;
	}

	@Override
	public Matiere saveModif(Matiere matiere) {
		Matiere m = mr.save(matiere);
		return m;
	}

	@Override
	public void supprimer(Integer id) {
		mr.deleteById(id);
	}

}
