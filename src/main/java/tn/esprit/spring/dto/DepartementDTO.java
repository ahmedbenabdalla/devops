package tn.esprit.spring.dto;

import java.util.List;

public class DepartementDTO {

	private int id;

	private String name;

	private List<EmployeDTO> employes;

	private List<MissionDTO> missions;

	private EntrepriseDTO entreprise;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeDTO> getEmployes() {
		return employes;
	}

	public void setEmployes(List<EmployeDTO> employes) {
		this.employes = employes;
	}

	public List<MissionDTO> getMissions() {
		return missions;
	}

	public void setMissions(List<MissionDTO> missions) {
		this.missions = missions;
	}

	public EntrepriseDTO getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(EntrepriseDTO entreprise) {
		this.entreprise = entreprise;
	}

	public DepartementDTO(int id, String name, List<EmployeDTO> employes, List<MissionDTO> missions,
			EntrepriseDTO entreprise) {
		super();
		this.id = id;
		this.name = name;
		this.employes = employes;
		this.missions = missions;
		this.entreprise = entreprise;
	}

	public DepartementDTO() {
		super();
	}

}
