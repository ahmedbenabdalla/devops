package tn.esprit.spring.dto;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseDTO {

	private int id;

	private String name;

	private String raisonSocial;

	private List<DepartementDTO> departements = new ArrayList<>();

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

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public List<DepartementDTO> getDepartements() {
		return departements;
	}

	public void setDepartements(List<DepartementDTO> departements) {
		this.departements = departements;
	}

	public EntrepriseDTO(int id, String name, String raisonSocial, List<DepartementDTO> departements) {
		super();
		this.id = id;
		this.name = name;
		this.raisonSocial = raisonSocial;
		this.departements = departements;
	}

	public EntrepriseDTO() {
		super();
	}

}
