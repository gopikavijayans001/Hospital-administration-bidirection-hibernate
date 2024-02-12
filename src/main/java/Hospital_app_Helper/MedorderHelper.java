package Hospital_app_Helper;

import java.util.Scanner;

import Hospital_app_Dao.EncounterDao;
import Hospital_app_Dao.MedorderDao;
import Hospital_app_Dto.Branch;

public class MedorderHelper {
	static Scanner scanner = new Scanner(System.in);
	static Branch branch = new Branch();
	static int enterid;
	static int updateChoice;

	public static void medorderOperations() {
		System.out.println("1. Manage Medorder\r\n" + "    a. Add a new Medorder\r\n" + "    b. Search medorder\r\n"
				+ "    c. Update Medorder details\r\n" + "    d. Delete a medorder");
		System.out.println("Please enter your choice");
		String choice = scanner.next();

		switch (choice) {
		case "a": {

			EncounterDao.viewEncounterId();
			enterid = EncounterDao.enterId();
			MedorderDao.saveMedorder(enterid);
		}

			break;

		case "b": {
			MedorderDao.viewMedorderId();
			enterid = MedorderDao.enterId();
			MedorderDao.searchMedorder(enterid);

		}
			break;

		case "c": {
			System.out.println("Update Medorder Details");
			System.out.println(
					"1.Update dosage of medicine\n2.Update frequency\n3.Update instruction\n4.Update item details");
			System.out.println("Enter the option");
			updateChoice =scanner.nextInt();

			switch (updateChoice) {
			case 1: {
				MedorderDao.viewMedorderId();
				enterid = MedorderDao.enterId();
				MedorderDao.updateDosage(enterid);
			}

				break;

			case 2: {
				MedorderDao.viewMedorderId();
				enterid = MedorderDao.enterId();
				MedorderDao.updateFrequency(enterid);
			}

				break;

			case 3: {
				MedorderDao.viewMedorderId();
				enterid = MedorderDao.enterId();
				MedorderDao.updateInstruction(enterid);
			}

				break;

			case 4: {
				MedorderDao.viewMedorderId();
				enterid = MedorderDao.enterId();
				MedorderDao.updateItemdetails(enterid);
			}

				break;

			default:
				System.out.println("Enter the valid option");
				break;
			}
			break;
		}
		case "d": {
			MedorderDao.viewMedorderId();
			enterid = MedorderDao.enterId();
			MedorderDao.removeMedorder(enterid);
		}
			break;
		default:
			System.out.println("Enter the valid option");
			break;
		}
	}
}
