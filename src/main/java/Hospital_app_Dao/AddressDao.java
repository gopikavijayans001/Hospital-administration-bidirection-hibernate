package Hospital_app_Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hospital_app_Dto.Address;
import Hospital_app_Dto.Branch;
import Hospital_app_Dto.Hospital;

public class AddressDao {
	static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	static String statement = "select a from Address a";
	static Scanner scanner = new Scanner(System.in);

	public static void viewAddressId() {

		Query query = entityManager.createQuery(statement);

		List<Address> addressList = query.getResultList();

		for (Address address : addressList) {
			System.out.println("address-id: "+address.getAddressId());

		}
	}

	public static void searchAddress(int id) {
		// Find the Address by ID
		Address searchAddress = entityManager.find(Address.class, id);

		if (searchAddress != null) {
			// Print the details of the found hospital
			System.out.println("Hospital details for ID " + id + ":");
			System.out.println("Hospital name: "+searchAddress.getBranch().getHospital().getName());
			System.out.println("branch name: "+searchAddress.getBranch().getBranchName());
			System.out.println("address id: "+searchAddress.getAddressId());
			System.out.println("address-city: "+searchAddress.getCity());
			System.out.println("address-street: "+searchAddress.getStreet());
			System.out.println("address-district: "+searchAddress.getDistrict());
			System.out.println("address-pincode: "+searchAddress.getPincode());
		} else {
			System.out.println("Address with ID " + id + " not found.");
		}
	}
 

	
	//Method to update the city
	public static Address updatePincode(int id) {
		Address updateAddress = entityManager.find(Address.class, id);
		if (updateAddress != null) {
			System.out.println("Enter the pincode");
			int updatePincode = scanner.nextInt();
			updateAddress.setPincode(updatePincode);

			entityTransaction.begin();
			entityManager.merge(updateAddress);
			entityTransaction.commit();
			System.out.println();
		}
		else
			System.out.println("Address id does'nt exist");
		return updateAddress;

	}
	
	
	
	public static Address update(int id) {
		Address updateAddress = entityManager.find(Address.class, id);
		if (updateAddress != null) {
			System.out.println("Enter the City");
			String updateCity = scanner.next();
			System.out.println("Enter the Street");
			String updateStreet = scanner.next();
			System.out.println("Enter the District");
			String updateDistrict = scanner.next();
			updateAddress.setCity(updateCity);
			updateAddress.setStreet(updateStreet);
			updateAddress.setDistrict(updateDistrict);

			entityTransaction.begin();
			entityManager.merge(updateAddress);
			entityTransaction.commit();
			System.out.println();
		}
		else
			System.out.println("Address id does'nt exist");
		
		
		return updateAddress;

	}
	
	// Method to remove the branch
	
	
	public static void removeAddress(int id) {
		
	Branch branch=	entityManager.find(Branch.class, id);
	Address address=branch.getAddress();
			branch.setAddress(null);
			
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();
	}
		
		
			
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
