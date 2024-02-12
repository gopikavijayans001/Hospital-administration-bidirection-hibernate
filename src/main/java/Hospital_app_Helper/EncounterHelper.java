package Hospital_app_Helper;

import java.util.Scanner;

import Hospital_app_Dao.BranchDao;
import Hospital_app_Dao.EncounterDao;
import Hospital_app_Dao.PersonDao;
import Hospital_app_Dto.Branch;
import Hospital_app_Dto.Encounter;
import Hospital_app_Dto.Person;

public class EncounterHelper {
	static Scanner scanner = new Scanner(System.in);
	static int updateChoice;

	public static void encounterOperations() {
		System.out.println("1. Manage Encounters\r\n" + "    a. Add a new Encounter\r\n" + "    b. Search encounter\r\n"
				+ "    c. Update encounter details\r\n" + "    d. Delete an encounter");
		System.out.println("Enter the option");
		String choice = scanner.next();

		switch (choice) {
		case "a": {

			BranchDao.viewBranchid();
			System.out.println("Enter the branch id");
			int branchId = scanner.nextInt();
			EncounterDao.saveEncounter(branchId);

		}
			break;

		case "b": {
			

			EncounterDao.viewEncounterId();
			int enterId = EncounterDao.enterId();
			EncounterDao.searchEncounter(enterId);

		}
			break;

		case "c": {
			
			System.out.println("Update Encounter Details");
			System.out.println(
					"1.Update name of Doctor\n2.Update Procedure\n3.Update Symptoms\n4.Update Person details");
			updateChoice=scanner.nextInt();
			switch (updateChoice) {
			case 1: {
				EncounterDao.viewEncounterId();
				int enterId = EncounterDao.enterId();
				EncounterDao.updateDoctor(enterId);

			}
				break;

			case 2: {
				EncounterDao.viewEncounterId();
				int enterId = EncounterDao.enterId();
				EncounterDao.updateProcedure(enterId);

			}
				break;
			case 3: {
				EncounterDao.viewEncounterId();
				int enterId = EncounterDao.enterId();
				EncounterDao.updateSymptom(enterId);

			}
				break;
			case 4: {
				EncounterDao.viewEncounterId();
				int enterId = EncounterDao.enterId();
				EncounterDao.updatePersondetails(enterId);

			}
				break;
			default:
				break;
			}

		}
			break;
		case "d": {
			EncounterDao.viewEncounterId();
			int enterId = EncounterDao.enterId();
			EncounterDao.removeEncounter(enterId);
		}
		default:
			System.out.println("Enter the valid option ");
			break;
		}

	}

}
