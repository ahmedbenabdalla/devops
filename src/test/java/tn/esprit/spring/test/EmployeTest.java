package tn.esprit.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;

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

	@Test
	public void ajouterEmploye() {

		int employeId;
		Employe employe = new Employe("ahmed", "ben abdallah", "ahmed@gmail.com", false, Role.TECHNICIEN);
		employeId = employeService.ajouterEmploye(employe);
		assertTrue("ajout employer echouer", employeRepository.findById(employeId).isPresent());
	}

	@Test
	public void mettreAjourEmailByEmployeId() {
		employeService.mettreAjourEmailByEmployeId("ahmed@esprit.tn", 3);
		assertEquals("fail to add  new employe", "ahmed@esprit.tn", employeRepository.findById(3).get().getEmail());
	}
    /*
	@Test
	public void affecterEmployeADepartement() {
		employeService.affecterEmployeADepartement(3, 1);
		List<Employe> emps = departementRepository.findById(1).get().getEmployes();
		for (Employe employe : emps) {
			System.out.println(employe.getNom());
		}
		assertTrue("affectation employer a departement echouer",
				departementRepository.findById(1).get().getEmployes().contains(employeRepository.findById(3).get()));
	}
    */
	@Test
	public void ajouterContrat() {
		Contrat contrat = new Contrat(new Date(), "CDI", 1200.5f);
		int ref = employeService.ajouterContrat(contrat);
		List<Contrat> contrats = (List<Contrat>) contratRepository.findAll();
		assertNotNull("échouer pour ajouter Contrat",
				contrats.stream().filter(c -> c.getReference() == ref).findAny().get());
	}

	@Test
	public void affecterContratAEmploye() {
		Contrat contrat = new Contrat(new Date(), "CDI", 1200.5f);
		Employe employe = new Employe("ahmed", "ben abdallah", "ahmed@gmail.com", false, Role.TECHNICIEN);
		int idC = employeService.ajouterContrat(contrat);
		int idE = employeService.ajouterEmploye(employe);
		employeService.affecterContratAEmploye(idC, idE);
		assertTrue("affectation contrat a employer echouer",
				employeRepository.findById(idE).get().getContrat().getReference() == idC);
	}

	@Test
	public void getEmployePrenomById() {
		Employe e = new Employe("Ahmed", "ben Abdallah", "@gmail.com", false, Role.TECHNICIEN);
		int id = employeService.ajouterEmploye(e);
		assertEquals("échouer pour reccuperer email employer", employeRepository.findById(id).get().getPrenom(),
				"ben Abdallah");

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
		int ref = employeService.ajouterContrat(contrat);
		employeService.deleteContratById(ref);
		assertFalse("échouer pour supprimer employer", contratRepository.findById(ref).isPresent());
	}

	@Test
	public void getNombreEmployeJPQL() {
		List<Employe> list = (List<Employe>) employeRepository.findAll();
		assertEquals("erreur pour recuperer nombre employer", list.size(), employeService.getNombreEmployeJPQL());
	}

	@Test
	public void getAllEmployeNamesJPQL() {
		int i = 0;
		List<String> employes = employeService.getAllEmployeNamesJPQL();
		for (Employe employe : employeRepository.findAll()) {
			assertEquals("erreur a la verification du nom" + i, employe.getNom(), employes.get(i));
			i++;
		}
	}
	@Test
	public void dif()
	{
		employeService.dif();
		
	}

}
