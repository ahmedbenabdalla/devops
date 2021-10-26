package tn.esprit.spring.dto;

import java.util.List;

public class MissionDTO {

	private int id;

	private String name;

	private String description;

	private DepartementDTO departement;

	private List<TimesheetDTO> timesheets;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DepartementDTO getDepartement() {
		return departement;
	}

	public void setDepartement(DepartementDTO departement) {
		this.departement = departement;
	}

	public List<TimesheetDTO> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<TimesheetDTO> timesheets) {
		this.timesheets = timesheets;
	}

	public MissionDTO(int id, String name, String description, DepartementDTO departement,
			List<TimesheetDTO> timesheets) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.departement = departement;
		this.timesheets = timesheets;
	}

	public MissionDTO() {
		super();
	}

}
