package com.gestion.banque.metier;

import java.util.List;

import com.gestion.banque.entities.Employee;

public interface EmployeeMetier {

	public Employee saveemploye(Employee e);
	public List<Employee> listemploye();
	
}
