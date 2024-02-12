package Hospital_app_Helper;

import java.util.Scanner;

import Hospital_app_Dao.AddressDao;
import Hospital_app_Dao.BranchDao;
import Hospital_app_Dto.Address;
import Hospital_app_Dto.Branch;

public class AddressHelper {

	static Scanner scanner = new Scanner(System.in);
	static int id;
	static int updateChoice;
	static Address address = new Address();

	public static void addressOperations() {
		System.out.println("1. Manage Address\r\n" + "    a. Search Address of branch\r\n"
				+ "    b. Update branch details\r\n" + "    c. Delete address");
		System.out.println("Please enter the choice");
		String choice = scanner.next();
		switch (choice) {
		case "a":
			
			AddressDao.viewAddressId();
			int id = AddressHelper.enterId();
			AddressDao.searchAddress(id);
			break;
		case "b":
			

			System.out.println("Update Address Details");
			System.out.println("1.Update city, street and districts \n2.Update pincode");

			System.out.println(" Enter the option");
			updateChoice = scanner.nextInt();

			switch (updateChoice) {
			case 1: {
				AddressDao.viewAddressId();
				id = enterId();
				AddressDao.update(id);

			}

				break;
			case 2: {
				AddressDao.viewAddressId();
				id = enterId();
				AddressDao.updatePincode(id);

			}

			default:
				System.out.println("Enter the valid option");
				break;
			}

			break;

		case "d": {
			AddressDao.viewAddressId();
			id = enterId();
			AddressDao.removeAddress(id);
		}
			break;
		}

	}

// Method to enter the id from the user
	public static int enterId() {

		System.out.println("Enter the Address_id");
		int id = scanner.nextInt();
		return id;
	}
// Method to read the address details

	public static Address insertAddress() {
		System.out.println("Enter the City");
		String city = scanner.next();
		System.out.println("Enter the street");
		String street = scanner.next();
		System.out.println("Enter the District");
		String district = scanner.next();
		System.out.println("Enter the pincode");
		int pincode = scanner.nextInt();

		address.setCity(city);
		address.setStreet(street);
		address.setDistrict(district);
		address.setPincode(pincode);
		
		
		return address;

	}

}
