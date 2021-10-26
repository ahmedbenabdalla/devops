package tn.esprit.spring.dto;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.TimesheetPK;

public class TimesheetDTO {

	private TimesheetPK timesheetPK;

	private Mission mission;

	private Employe employe;

	private boolean isValide;

	public TimesheetPK getTimesheetPK() {
		return timesheetPK;
	}

	public void setTimesheetPK(TimesheetPK timesheetPK) {
		this.timesheetPK = timesheetPK;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public TimesheetDTO(TimesheetPK timesheetPK, Mission mission, Employe employe, boolean isValide) {
		super();
		this.timesheetPK = timesheetPK;
		this.mission = mission;
		this.employe = employe;
		this.isValide = isValide;
	}

	public TimesheetDTO() {
		super();
	}

}
