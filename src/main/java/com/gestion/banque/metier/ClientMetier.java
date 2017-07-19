package com.gestion.banque.metier;

import java.util.List;

import com.gestion.banque.entities.Client;

public interface ClientMetier {
	
	public Client saveClient(Client c);
	public List<Client> listClient();

}
