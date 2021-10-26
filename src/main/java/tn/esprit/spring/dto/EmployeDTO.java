package tn.esprit.spring.dto;

import java.util.List;

import tn.esprit.spring.entities.Role;

public class EmployeDTO {

	private int id;

	private String prenom;

	private String nom;

	private String email;

	private boolean isActif;

	private Role role;

	private List<DepartementDTO> departements;

	private ContratDTO contrat;

	private List<TimesheetDTO> timesheets;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<DepartementDTO> getDepartements() {
		return departements;
	}

	public void setDepartements(List<DepartementDTO> departements) {
		this.departements = departements;
	}

	public ContratDTO getContrat() {
		return contrat;
	}

	public void setContrat(ContratDTO contrat) {
		this.contrat = contrat;
	}

	public List<TimesheetDTO> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<TimesheetDTO> timesheets) {
		this.timesheets = timesheets;
	}

	
}
