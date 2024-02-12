package Hospital_app_Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hospital_app_Dto.Branch;
import Hospital_app_Dto.Encounter;
import Hospital_app_Dto.Medorder;
import Hospital_app_Dto.Person;
import Hospital_app_Helper.PersonHelper;

public class EncounterDao {

	static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	static String statement = "select p from Encounter p";
	static Scanner scanner = new Scanner(System.in);
	static Encounter encounter = new Encounter();

	public static void saveEncounter(int branchId) {
		// check whether the branch exist
		Branch branch = entityManager.find(Branch.class, branchId);
		if (branch != null) {
			PersonDao.viewPersonId();
			// check whether the person exist or not
			System.out.println("Enter the person id");
			int personId = scanner.nextInt();

			Person person = entityManager.find(Person.class, personId);
			if (person != null) {

				// if exist save the encounter
				Encounter encounter = readEncounter();
				// save the encounter
				encounter.setBranch(branch);
				encounter.setPerson(person);
				entityTransaction.begin();
				entityManager.persist(encounter);
				entityTransaction.commit();

			} else {
				Person persons = PersonHelper.insertPerson();
				PersonDao.savePerson(persons);
			}

		}

		else {
			System.out.println("Branch Not found");
		}
	}

	public static Encounter readEncounter() {
		System.out.println("Enter the Doctor name ");
		String name = scanner.next();

		System.out.println("Enter the procedure");
		String procedure = scanner.next();
		scanner.nextLine();
		System.out.println("Enter the test and results");
		String testResult = scanner.next();
		scanner.nextLine();
		System.out.println("Enter the symptoms");
		String symptoms = scanner.next();
		scanner.nextLine();
		System.out.println("Enter the Discharge date");
		String dischargeDate = scanner.next();

		encounter.setDoctorName(name);
		encounter.setProcedure(procedure);
		encounter.setTestResult(testResult);
		encounter.setSymptoms(symptoms);
		encounter.setDischargeDate(dischargeDate);


		// set the medorder
//		List<Medorder> medorderlist = MedorderDao.addmedorderList();
//		encounter.setMedorder(medorderlist);



		return encounter;
	}

	public static List<Encounter> addencounterList() {
		Encounter readEncounter = EncounterDao.readEncounter();
		List<Encounter> encounterList = new ArrayList<Encounter>();

		encounterList.add(readEncounter);

		return encounterList;
	}

	public static void viewEncounterId() {
		Query query = entityManager.createQuery(statement);

		List<Encounter> encounterList = query.getResultList();

		for (Encounter encounter : encounterList) {
			System.out.println("Encounter_id: "+encounter.getEncounterId());

		}

	}

	public static int enterId() {
		System.out.println("Enter the Encounter_id");
		int id = scanner.nextInt();
		return id;
	}

	public static Encounter searchEncounter(int id) {
		Encounter encounter = entityManager.find(Encounter.class, id);
		if (encounter != null) {
			System.out.println("Encounter_id: "+encounter.getEncounterId());
			System.out.println("Encounter doctor name: "+encounter.getDoctorName());
			System.out.println("Encounter_person id: "+encounter.getPerson().getPersonId());
			System.out.println("Encounter_person name: "+encounter.getPerson().getPersonName());
			System.out.println("Encounter_admission date: "+encounter.getAdmissionDateTime());
			System.out.println("Encounter_procedure: "+encounter.getProcedure());
			System.out.println("Encounter_symptoms: "+encounter.getSymptoms());
			System.out.println("Encounter_tests and results: "+encounter.getTestResult());
			System.out.println("Encounter_discharge date: "+encounter.getDischargeDate());
		}
		
		else
			System.out.println("not found");
		return encounter;
	}

	// update the doctor name
	public static void updateDoctor(int id) {
		Encounter encounter = entityManager.find(Encounter.class, id);
		if (encounter != null) {
			System.out.println("Enter the  Doctor name");
			String doctorName = scanner.next();
			encounter.setDoctorName(doctorName);

			entityTransaction.begin();
			entityManager.merge(encounter);
			entityTransaction.commit();

			System.out.println("Doctor name is updated");
		} else
			System.out.println("Encounter id not valid\nplease enter the valid id");

	}

//update the procedure

	public static void updateProcedure(int id) {
		Encounter encounter = entityManager.find(Encounter.class, id);
		if (encounter != null) {
			System.out.println("Enter the  procedure");
			String procedure = scanner.next();
			encounter.setDoctorName(procedure);
			entityTransaction.begin();
			entityManager.merge(encounter);
			entityTransaction.commit();

			System.out.println("procedure is updated");
		} else
			System.out.println("Encounter id not valid\nplease enter  valid id");

	}

//update the symptoms
	public static void updateSymptom(int id) {
		Encounter encounter = entityManager.find(Encounter.class, id);
		if (encounter != null) {
			System.out.println("Enter the  Symptom");
			String symptom = scanner.next();
			encounter.setDoctorName(symptom);
			entityTransaction.begin();
			entityManager.merge(encounter);
			entityTransaction.commit();

			System.out.println("Symtoms  updated");
		} else
			System.out.println("Encounter id not valid\nplease enter the valid id");

	}

//update the person name
	public static void updatePersondetails(int id) {
		Encounter encounter = entityManager.find(Encounter.class, id);
		if (encounter != null) {
			System.out.println("Enter the  person name");
			String personName = scanner.next();
			encounter.setDoctorName(personName);
			entityTransaction.begin();
			entityManager.merge(encounter);
			entityTransaction.commit();
			System.out.println("person name is updated");
		} else
			System.out.println("Encounter id not valid\nplease enter  valid id");

	}

//remove the encounter

	public static boolean removeEncounter(int id) {
		Encounter encounter = entityManager.find(Encounter.class, id);

		if (encounter != null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			System.out.println("Encounter removed....");
			return true;
		} else
			System.out.println("Encounter is not removed...please enter the valid id");
		return false;
	}

}
