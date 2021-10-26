package tn.esprit.spring.dto;

import java.util.Date;

public class ContratDTO {

	private int reference;
	
	private Date dateDebut;
	
	private String typeContrat;
	
	private float salaire;
	

	public int getReference() {
		return reference;
	}


	public void setReference(int reference) {
		this.reference = reference;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getTypeContrat() {
		return typeContrat;
	}


	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}


	public float getSalaire() {
		return salaire;
	}


	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}


	public EmployeDTO getEmploye() {
		return employe;
	}


	public void setEmploye(EmployeDTO employe) {
		this.employe = employe;
	}


	private EmployeDTO employe;


	
}
