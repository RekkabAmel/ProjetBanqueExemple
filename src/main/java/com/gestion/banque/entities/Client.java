package com.gestion.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.gestion.banque.entities.Compte;

import com.fasterxml.jackson.annotation.JsonIgnore;


@SuppressWarnings("serial")
public class Client implements Serializable {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeClient;
	private String nomClient;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nomClient) {
		super();
		this.nomClient = nomClient;
	}
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
}