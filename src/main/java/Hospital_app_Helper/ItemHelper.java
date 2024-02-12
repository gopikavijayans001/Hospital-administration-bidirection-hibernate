package Hospital_app_Helper;

import java.util.Scanner;

import Hospital_app_Dao.ItemDao;

public class ItemHelper {
	static Scanner scanner = new Scanner(System.in);
	static int updateChoice;
	static int id;

	public static void itemOperations() {
		System.out.println("1. Manage Items\r\n" + "    a. Search Item\r\n" + "    b. Update Item details\r\n"
				+ "    c. Delete an Item\r\n");
		System.out.println("Enter the option");
		String choice = scanner.next();

		switch (choice) {
		case "a": {

			ItemDao.viewItemid();
			id = ItemDao.enterId();
			ItemDao.searchItem(id);

		}
			break;
		case "b": {
			System.out.println("Update Item Details");
			System.out.println("1.Update name of Item\n2.Update unit price \n3.Update Description");
			switch (updateChoice) {
			case 1: {
				ItemDao.viewItemid();
				id = ItemDao.enterId();
				ItemDao.updateName(id);
			}
				break;
			case 2: {
				ItemDao.viewItemid();
				id = ItemDao.enterId();
				ItemDao.updatePrice(id);
			}
				break;
			case 3: {
				ItemDao.viewItemid();
				id = ItemDao.enterId();
				ItemDao.updateDescription(id);
			}

				break;
			default:
				System.out.println("Enter the valid id");

				break;
			}
		}
			break;

		case "c": {
			ItemDao.viewItemid();
			id = ItemDao.enterId();
			ItemDao.removeItem(id);

		}
		default:
			System.out.println("Enter the valid id");
			break;
		}

	}
}
