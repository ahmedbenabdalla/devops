package tn.esprit.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;

import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {

	@Autowired
	IEmployeService employeService;
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	ContratRepository contratRepository;
	
	int employeId;
	Employe employe;
	int depId;
	int idC;
	String lastName;
	@Before public void initialisation()
	{
		depId=departementRepository.save(new Departement("esprit")).getId();
		lastName="ben abdallah";
		employe = new Employe("ahmed", "ben abdallah", "ahmed@gmail.com", false, Role.TECHNICIEN);
		employeId = employeService.ajouterEmploye(employe);
		Contrat contrat = new Contrat(new Date(), "CDI", 1200.5f);
		idC = contratRepository.save(contrat).getReference();
	}
	@After public void supression()
	{
		departementRepository.deleteById(depId);
		employeRepository.deleteById(employeId);
		contratRepository.deleteById(idC);
    }
	

	@Test
	public void ajouterEmploye() {
		assertTrue("ajout employer echouer", employeRepository.findById(employeId).isPresent());
	}

	@Test
	public void mettreAjourEmailByEmployeId() {
		employeService.mettreAjourEmailByEmployeId("ahmed@esprit.tn", employeId);
		assertEquals("fail to add  new employe", "ahmed@esprit.tn", employeRepository.findById(employeId).orElseThrow(null).getEmail());
	}
    
	@Test
	public void affecterEmployeADepartement() {
		assertTrue("affectation employer a departement echouer",
				employeService.affecterEmployeADepartement(employeId, depId));
	}
	@Test
	public void desaffecterEmployeDuDepartement()
	{
		
		assertTrue("desaffecter employer a departement echouer", employeService.desaffecterEmployeDuDepartement(employeId, depId));
	}
    
	@Test
	public void ajouterContrat() {
		
		assertTrue("échouer pour ajouter Contrat",
				contratRepository.findById(idC).isPresent());
	}

	@Test
	public void affecterContratAEmploye() {
		int contratId=employeService.ajouterContrat(new Contrat());
		employeService.affecterContratAEmploye(contratId, employeId);
		Employe e=employeRepository.findById(employeId).orElseThrow(null);
		assertTrue("affectation contrat a employer echouer",
				e.getContrat().getReference() == contratId);
	}

	@Test
	public void getEmployePrenomById() {
		assertEquals("échouer pour reccuperer email employer", employeRepository.findById(employeId).orElseThrow(null).getPrenom(),
				lastName);
	}

	@Test
	public void deleteEmployeById() {
		Employe e = new Employe("Ahmed", "ben Abdallah", "@gmail.com", false, Role.TECHNICIEN);
		int id = employeService.ajouterEmploye(e);
		employeService.deleteEmployeById(id);
		assertFalse("échouer pour supprimer employer", employeRepository.findById(id).isPresent());
	}

	@Test
	public void deleteContratById() {
		Contrat contrat = new Contrat(new Date(), "CDI", 1200.5f);
		int contratId = employeService.ajouterContrat(contrat);
		employeService.deleteContratById(contratId);
		assertFalse("échouer pour supprimer employer", contratRepository.findById(contratId).isPresent());
	}
	
	

	
	


}
