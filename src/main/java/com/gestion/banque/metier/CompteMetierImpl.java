package com.gestion.banque.metier;

import java.util.Date;

import com.gestion.banque.dao.CompteRepository;
import com.gestion.banque.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompteMetierImpl implements CompteMetier{
	
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte savecompte(Compte cp) {
		// TODO Auto-generated method stub
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	@Override
	public Compte getcompte(String code) {
		// TODO Auto-generated method stub
		Compte cp=compteRepository.findOne(code);
		if(cp==null) throw new RuntimeException("compte inhexistant");
		return cp;
	}

}
