package Hospital_app_Helper;

import java.util.Scanner;

import Hospital_app_Dao.EncounterDao;
import Hospital_app_Dao.PersonDao;
import Hospital_app_Dto.Encounter;
import Hospital_app_Dto.Person;

public class PersonHelper {
	static Scanner scanner = new Scanner(System.in);
	static Person person = new Person();
static int updateChoice;
	public static void personOperations() {
		System.out.println("1. Manage Person details\r\n" + "    a. Search person details\r\n"
				+ "    b. Update person details\r\n" + "    c. Delete a person");

		String choice = scanner.next();
		switch (choice) {
		case "a": {
			/*
			 * view the person id, enter the id ,find the person, view the details
			 */

			PersonDao.viewPersonId();
			int id = enterPersonid();
			PersonDao.searchPerson(id);
		}
			break;

		case "b": {
			
			System.out.println("Update Person Details");
			System.out.println(
					"1.Update name\n2.Update phone number\n3.Update encounter details");
			System.out.println("Enter the option");
			switch (updateChoice) {
			case 1:{
				PersonDao.viewPersonId();
				int id = enterPersonid();
				PersonDao.updatename(id);
			}
				
				break;
			case 2:{
				PersonDao.viewPersonId();
				int id = enterPersonid();
				PersonDao.updatePhonenumber(id);
			}
				
				break;
			case 3:{
				PersonDao.viewPersonId();
				int id = enterPersonid();
				PersonDao.updateEncounter(id);
			}
				
				break;

			default:
				break;
			}

		}
			break;

		case "c": {
			

			PersonDao.viewPersonId();
			int id = enterPersonid();
			PersonDao.removePerson(id);
		}

			break;

		default:
			System.out.println("Enter the valid option");
			break;
		}

	}

	public static Person insertPerson() {

		System.out.println("Enter the Person name");
		String name = scanner.next();

		System.out.println("Enter the age ");
		int age = scanner.nextInt();

		System.out.println("Enter the gender");
		String gender = scanner.next();

		System.out.println("Enter the phone number");
		long phoneNumber = scanner.nextLong();

		System.out.println("Enter the place");
		String place = scanner.next();

		person.setPersonName(name);
		person.setAge(age);
		person.setGender(gender);
		person.setPhoneNumber(phoneNumber);
		person.setPlace(place);


		return person;

	}

	public static int enterPersonid() {

		System.out.println("Enter the Person id");
		int id = scanner.nextInt();
		return id;
	}

}
