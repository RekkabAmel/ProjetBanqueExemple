package org.gestion.banque.dao;



import java.util.List;

import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.Compte;
import org.gestion.banque.entities.Employe;
import org.gestion.banque.entities.Groupe;
import org.gestion.banque.entities.Operation;

import com.mysql.jdbc.log.Log;

@SuppressWarnings("unused")
public interface IBanqueDao {
	public Client addClient(Client c);
	public Employe addEmploye(Employe e, Long codeSup);
	public Groupe addGroupe(Groupe g);
	public void addEmployeToGroupe(Long codeEmp, Long codeGr);
	public Compte addCompte(Compte cp,Long codeCli, Long codeEmp);
	public Operation addOperation(Operation op,String codeCpte, Long codeEmp);
	//public void versement(String codeCopte, double mt, Long codeEmp );
	//public void retrait(String codeCopte, double mt, Long codeEmp);
	//public void virement(String codeCpte1, String Cpte2,  double mt, Long codeEmp);
	public Compte consulterCompte(String codeCpte);
	public List<Operation> consulterOperations(String codeCpte);
	public Client consulterClient(Long codeCli);
	public List<Client> consulterClients(String mc);
	public List<Compte> getComptesByClient(Long codeCli);
	public List<Compte> getComptesByEmploye(Long codeEmp);
	public List<Employe> getEmployes();
	public List<Groupe> getGroupes();
	public List<Employe> getEmployesByGroupe(Long codeGr);
	
}
