package Hospital_app_Helper;

import java.util.Scanner;

import Hospital_app_Dao.BranchDao;
import Hospital_app_Dao.HospitalDao;
import Hospital_app_Dto.Address;
import Hospital_app_Dto.Branch;

public class BranchHelper {
	static Scanner scanner = new Scanner(System.in);
	static Branch branch = new Branch();
	static int enterid;

	public static void branchOperations() {
		System.out.println("1. Manage Branches\r\n" + "    a. Add a new branch\r\n" + "    b. Search branch\r\n"
				+ "    c. Update branch details\r\n" + "    d. Delete a branch");
		System.out.println("Please enter your choice");
		String choice = scanner.next();
		switch (choice) {
		case "a":
		{
			HospitalDao.viewHospitalId();
			int id = HospitalHelper.enterId();
			BranchDao.findHospital(id);
		}
			break;

		case "b": {

			BranchDao.viewBranchid();
			int enterId = BranchDao.enterBranchid();
			BranchDao.searchBranch(enterId);

		}
			break;

		case "c": {

			System.out.println("Update Branch Details");
			System.out.println(
					"1.Update name of Branch\n2.Update the number of doctors\n3.Update the number of beds\n4.Update the Address details");
			int updateChoice = scanner.nextInt();

			switch (updateChoice) {
			case 1: {
			
				BranchDao.viewBranchid();
				int enterid =BranchDao. enterBranchid();
				BranchDao.updateName(enterid);

			}

				break;
			case 2: {

				BranchDao.viewBranchid();
				int enterid = BranchDao.enterBranchid();
				BranchDao.updateDoctors(enterid);

			}
				break;

			case 3: {

				BranchDao.viewBranchid();
				int enterid = BranchDao.enterBranchid();
				BranchDao.updateBeds(enterid);

			}
				break;

			case 4: {

				int enterid = BranchDao.enterBranchid();
				BranchDao.updateAddress(enterid);

			}
				break;
			default:
				break;
			}

		}
		break;
		case "d": {
			// delete the branch

			BranchDao.viewBranchid();
			int enterid = BranchDao.enterBranchid();
			BranchDao.removeBranch(enterid);

		}

			break;

		default:
			break;
		}
	}

}
