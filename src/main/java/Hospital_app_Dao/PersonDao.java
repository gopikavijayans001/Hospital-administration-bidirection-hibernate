package Hospital_app_Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hospital_app_Dto.Branch;
import Hospital_app_Dto.Hospital;
import Hospital_app_Dto.Person;

public class PersonDao {

	static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	static String statement = "select p from Person p";
	static Scanner scanner = new Scanner(System.in);
	
	//Method to view the person id
	
	public static void viewPersonId() {

		Query query = entityManager.createQuery(statement);

		List<Person> personList = query.getResultList();

		for (Person person : personList) {
			System.out.println("person_id: "+person.getPersonId());
			System.out.println("person name: "+person.getPersonName());

		}
	}
		//Method to Search person details
		
		public static void searchPerson(int id) {
			// Find the hospital by ID
			Person searchPerson = entityManager.find(Person.class, id);

			if (searchPerson != null) {
				// Print the details of the found hospital
				System.out.println("Person details for ID " + id + ":");
				System.out.println("person name: "+searchPerson.getPersonName());
				System.out.println("person age: "+searchPerson.getAge());
				System.out.println("person gender: "+searchPerson.getGender());
				System.out.println("person phone number: "+searchPerson.getPhoneNumber());
				System.out.println("person place: "+searchPerson.getPlace());
			} else {
				System.out.println("Hospital with ID " + id + " not found.");
			}
		}
		
		//Method to remove the person details
	
		public static boolean removePerson(int id) {

			Person person = entityManager.find(Person.class, id);
			if (person != null) {
				entityTransaction.begin();
				entityManager.refresh(person);
				entityTransaction.commit();
				System.out.println("Hospital is removed....");
				return true;
			}

			else
				return false;

		}
		

		public static Person updatename(int id) {
			Person updatePerson = entityManager.find(Person.class, id);
			if (updatePerson != null) {
				System.out.println("Enter the Name");
				String  name = scanner.next();
				updatePerson.setPersonName(name);

				entityTransaction.begin();
				entityManager.merge(updatePerson);
				entityTransaction.commit();
				System.out.println("person name updated");
			} else
				System.out.println("person id doesn't exist");
			return updatePerson;

		}
		

		public static Person updatePhonenumber(int id) {
			Person updatePerson = entityManager.find(Person.class, id);
			if (updatePerson != null) {
				System.out.println("Enter the phone number");
				long phoneNumber = scanner.nextLong();
				updatePerson.setPhoneNumber(phoneNumber);

				entityTransaction.begin();
				entityManager.merge(updatePerson);
				entityTransaction.commit();
				System.out.println("phone number updated");
			} else
				System.out.println("person id doesn't exist");
			return updatePerson;

		}
		

		public static Person updateEncounter(int id) {
			Person updatePerson = entityManager.find(Person.class, id);
			if (updatePerson != null) {
				System.out.println("Enter the symptoms");
				String  symptoms = scanner.next();
				System.out.println("Enter the Doctor name");
				String  name = scanner.next();
				updatePerson.setPersonName(name);

				entityTransaction.begin();
				entityManager.merge(updatePerson);
				entityTransaction.commit();
				System.out.println("Encounter details updated");
			} else
				System.out.println("person id doesn't exist");
			return updatePerson;

		}
		
		
		public static Person savePerson(Person person) {
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			return person;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

