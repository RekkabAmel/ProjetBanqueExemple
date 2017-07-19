package com.gestion.banque.metier;

import com.gestion.banque.entities.Compte;

public interface CompteMetier {

	public Compte savecompte(Compte cp);
	public Compte getcompte(String code);
}
