package test;

import org.gestion.banque.entities.Client;

import org.gestion.banque.entities.Employe;
import org.gestion.banque.entities.Groupe;
import org.gestion.banque.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main (String[] args){
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IBanqueMetier metier = (IBanqueMetier)context.getBean("metier");
		metier.addClient(new Client("C1","AD1"));
		metier.addClient(new Client("C2", "AD2"));
		metier.addEmploye(new Employe("E1"),null );
		metier.addEmploye(new Employe("E2"),1L );
		metier.addEmploye(new Employe("E3"),1L );
		metier.addGroupe(new Groupe("G1"));
		metier.addGroupe(new Groupe("G2"));
		metier.addEmployeToGroupe(1L, 1L);
		metier.addEmployeToGroupe(2L, 2L);
		metier.addEmployeToGroupe(3L, 2L);
	}
}
