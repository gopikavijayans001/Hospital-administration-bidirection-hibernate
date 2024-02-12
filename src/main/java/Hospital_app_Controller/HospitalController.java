package Hospital_app_Controller;

import java.util.Scanner;

import Hospital_app_Helper.AddressHelper;
import Hospital_app_Helper.BranchHelper;
import Hospital_app_Helper.EncounterHelper;
import Hospital_app_Helper.HospitalHelper;
import Hospital_app_Helper.ItemHelper;
import Hospital_app_Helper.MedorderHelper;
import Hospital_app_Helper.PersonHelper;

public class HospitalController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welocome to Hospital Administration App......");
		System.out.println(
				"1.Hospital Details\n2.Branch Details\n3.Encounter Details\n4.Medorder Details\n5.Address Details\n6.Items\n7.Person Details");
		System.out.println("Please enter your choice");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			HospitalHelper.hospitalOperations();
		}

			break;
		case 2: {
			BranchHelper.branchOperations();
		}
			break;

		case 3:

		{
			EncounterHelper.encounterOperations();
		}
			break;
		case 4:

		{
			MedorderHelper.medorderOperations();
		}
			break;
		case 5: {

			AddressHelper.addressOperations();
		}
			break;
		case 6:

		{
			ItemHelper.itemOperations();
		}
			break;
		case 7:

		{
		PersonHelper.personOperations();
		}
			break;

		default:
			break;
		}

	}
}
