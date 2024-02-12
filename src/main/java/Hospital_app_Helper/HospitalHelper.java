package Hospital_app_Helper;

import java.util.Scanner;

import Hospital_app_Dao.HospitalDao;
import Hospital_app_Dto.Hospital;

public class HospitalHelper {
	static Scanner scanner = new Scanner(System.in);
	static int updateChoice;
	static String name;
	static String email;
	static String type;
	static String ceoName;
	static Hospital hospital = new Hospital();

	public static void hospitalOperations() {
		System.out.println("1. Manage Hospitals\r\n" + "    a. Add a new hospital\r\n" + "    b. Search hospitals\r\n"
				+ "    c. Update hospital details\r\n" + "    d. Delete a hospital");

		String choice = scanner.next();
		switch (choice) {
		case "a": {

			hospital = insertHospital();
			HospitalDao.saveHospital(hospital);

		}

			break;

		case "b": {

			HospitalDao.viewHospitalId();
			int id = enterId();
			HospitalDao.searchHospital(id);

		}

			break;
		case "c": {

			System.out.println("Update Hospital Details");
			System.out.println("1.Update name of Hospital\n2.Update Ceo Name\n3.Update type of Hospital");
			System.out.println("enter the option");
			updateChoice = scanner.nextInt();
			switch (updateChoice) {
			case 1: {

				HospitalDao.viewHospitalId();
				int id = enterId();
				HospitalDao.updateName(id);

			}
				break;

			case 2: {

				HospitalDao.viewHospitalId();
				int id = enterId();
				HospitalDao.updateCeoname(id);

			}
				break;

			case 3: {

				HospitalDao.viewHospitalId();
				int id = enterId();
				HospitalDao.updateType(id);

			}

				break;

			default:
				System.out.println(" Enter the valid Option");
				break;
			}
		}
			break;
		case "d": {

			HospitalDao.viewHospitalId();
			int id = enterId();
			HospitalDao.removeHospital(id);

		}

			break;

		default:
			break;
		}

	}

//method to insert the hospital data 
	public static Hospital insertHospital() {

		System.out.println("Enter the Hospital name");
		name = scanner.next();

		System.out.println("Enter the Hospital Ceo Name");
		ceoName = scanner.next();

		System.out.println("Enter the Hospital type");
		type = scanner.next();

		System.out.println("Enter the Hospital email");
		email = scanner.next();

		hospital.setCeoName(ceoName);
		hospital.setEmail(email);
		hospital.setName(name);
		hospital.setType(type);
		System.out.println("inserted...");
		return hospital;

	}

	public static int enterId() {

		System.out.println("Enter the Hospital_id");
		int id = scanner.nextInt();
		return id;
	}

}
