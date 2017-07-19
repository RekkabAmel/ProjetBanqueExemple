package com.gestion.banque.metier;

import java.util.Date;

import com.gestion.banque.dao.CompteRepository;
import com.gestion.banque.dao.EmployeeRepository;
import com.gestion.banque.dao.OperationRepository;
import com.gestion.banque.entities.Compte;
import com.gestion.banque.entities.Employee;
import com.gestion.banque.entities.Operation;
import com.gestion.banque.entities.Retrait;
import com.gestion.banque.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class OperationMetierImpl implements OperationMetier {
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
    @Autowired
	private EmployeeRepository employeeRepository;
    
	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeemp) {
		// TODO Auto-generated method stub
		Compte cp=compteRepository.findOne(code);
	    Employee e=employeeRepository.findOne(codeemp);
		Operation o = new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setEmployee(e);
		o.setCompte(cp);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+montant);
		//compteRepository.save(cp);  @Transactional fait ca 
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeemp) {
		// TODO Auto-generated method stub
		Compte cp=compteRepository.findOne(code);
		if(cp.getSolde()<montant) throw new RuntimeException("solde insufisant");
	    Employee e=employeeRepository.findOne(codeemp);
		Operation o = new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setEmployee(e);
		o.setCompte(cp);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()-montant);
		//compteRepository.save(cp);  @Transactional fait ca 
		return true;
		
	}

	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, Long codeemp) {
		
		retirer(cpte1,montant,codeemp);
		verser(cpte2, montant, codeemp);
		return true;
		
		
		
	}

	@Override
	public PageOperation getOperations(String codecompte, int page, int size) {
		// TODO Auto-generated method stub
		Page<Operation> ops=operationRepository.getOperations(codecompte, new PageRequest(page, size));
		
		/*Compte cp=compteRepository.findOne(codecompte);
		Page<Operation> ops2=operationRepository.findByCompte(cp, new PageRequest(page, size));
		2em solution
		*/
		PageOperation pop = new PageOperation();
		pop.setOperations(ops.getContent());
		pop.setNombreOperations(ops.getNumberOfElements());
		pop.setPage(ops.getNumber());
		pop.setTotalpages(ops.getTotalPages());
		pop.setTotalOperations((int)ops.getTotalElements());
		
		return pop;
	}

}
