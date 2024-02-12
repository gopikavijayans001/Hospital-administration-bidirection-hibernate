
package Hospital_app_Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hospital_app_Dto.Address;
import Hospital_app_Dto.Branch;
import Hospital_app_Dto.Hospital;
import Hospital_app_Helper.AddressHelper;
import Hospital_app_Helper.BranchHelper;

public class BranchDao {

	static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	static String statement = "select b from Branch b";
	static Scanner scanner = new Scanner(System.in);
static Branch branch= new Branch();
	public static void findHospital(int id) {

		Hospital hospital = entityManager.find(Hospital.class, id);
		if (hospital != null) {
			// branch inserted
			Branch branch =  readBranch(hospital);
			
			saveBranch(branch);
			System.out.println("Branch saved.......");
		} else
			System.out.println("The hospital is not found in the given id");

	}

	public static Branch saveBranch(Branch branch) {
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		System.out.println("Branch is added.....");
		return branch;

	}

	// method to view the branch id and names
	public static void viewBranchid() {
		Query query = entityManager.createQuery(statement);
		List<Branch> branchList = query.getResultList();
		for (Branch branch : branchList) {
			System.out.println("Branch_id:"+branch.getBranchId());
			System.out.println("Branch_Name:"+branch.getBranchName());
		}

	}

	// search method
	public static Branch searchBranch(int id) {
		Branch branch = entityManager.find(Branch.class, id);

		if (branch != null) {

			System.out.println("Branch_Name:"+branch.getBranchName());
			System.out.println("Branch_Number of Doctors:"+branch.getNumDoctors());
			System.out.println("Branch_Number of Beds:"+branch.getNumBeds());
			System.out.println("Branch_Phone number:"+branch.getPhoneNumber());
			System.out.println("Branch_City:"+branch.getAddress().getCity());
			System.out.println("Branch_Street:"+branch.getAddress().getStreet());
			System.out.println("Branch_District:"+branch.getAddress().getDistrict());
			System.out.println("Branch_Pincode:"+branch.getAddress().getPincode());
			System.out.println("Hospital Name:"+branch.getHospital().getName());

			return branch;
		} else
			System.out.println("The branch is not found");
		return null;

	}

	public static Branch updateName(int id) {
		Branch updateBranch = entityManager.find(Branch.class, id);
		if (updateBranch != null) {
			System.out.println("Enter the Name");
			String updateName = scanner.next();
			updateBranch.setBranchName(updateName);

			entityTransaction.begin();
			entityManager.merge(updateBranch);
			entityTransaction.commit();
			System.out.println("Branch name updated successfully.....");
		} else
			System.out.println("Branch id doesn't exist");
		return updateBranch;

	}

	public static Branch updateDoctors(int id) {
		Branch updateBranch = entityManager.find(Branch.class, id);
		if (updateBranch != null) {
			System.out.println("Enter the number of doctors");
			int updateNumber = scanner.nextInt();
			updateBranch.setNumDoctors(updateNumber);

			entityTransaction.begin();
			entityManager.merge(updateBranch);
			entityTransaction.commit();
			System.out.println("Number of Doctors updated");
		} else
			System.out.println("Branch id doesn't exist");
		return updateBranch;

	}

	public static Branch updateBeds(int id) {
		Branch updateBranch = entityManager.find(Branch.class, id);
		if (updateBranch != null) {
			System.out.println("Enter the Number of beds");
			int updateBed = scanner.nextInt();
			updateBranch.setNumBeds(updateBed);

			entityTransaction.begin();
			entityManager.merge(updateBranch);
			entityTransaction.commit();
			System.out.println("Number of Beds updated");
		} else
			System.out.println("Branch id doesn't exist");
		return updateBranch;

	}
	// method to update the address

	public static Branch updateAddress(int id) {
		Branch updateBranch = entityManager.find(Branch.class, id);
		if (updateBranch != null) {
			System.out.println("Enter the District");
			String District = scanner.next();
			System.out.println("Enter the City name");
			String City = scanner.next();
			System.out.println("Enter the Address pincode");
			int pincode = scanner.nextInt();
			updateBranch.getAddress().setDistrict(District);
			updateBranch.getAddress().setCity(City);
			updateBranch.getAddress().setPincode(pincode);

			entityTransaction.begin();
			entityManager.merge(updateBranch);
			entityTransaction.commit();
			System.out.println("Address is  updated...........");
		}

		else
			System.out.println("Branch id doesn't exist");
		return updateBranch;

	}

	public static boolean removeBranch(int id) {
		Branch branch = entityManager.find(Branch.class, id);

		if (branch != null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			System.out.println("Branch removed....");
			return true;
		} else
			System.out.println("Branch is not removed...please enter the valid id");
		return false;
	}
	// inserting the branch details
	public static Branch readBranch(Hospital hospital) {

		System.out.println("Enter the branch name");
		String name = scanner.next();

		System.out.println("Enter the number of doctors in the branch");
		int numDoctors = scanner.nextInt();

		System.out.println("Enter the number of beds in the branch");
		int numBeds = scanner.nextInt();

		System.out.println("Enter the Contact number of branch");
		int phoneNumber = scanner.nextInt();

		// call the address inside the branch aND SET IT INSIDE THE BRANCH

		branch.setBranchName(name);
		branch.setNumDoctors(numDoctors);
		branch.setNumBeds(numBeds);
		branch.setPhoneNumber(phoneNumber);
		Address address = AddressHelper.insertAddress();
		branch.setAddress(address);
		branch.setHospital(hospital);

		return branch;

	}

	public static int enterBranchid() {

		System.out.println("Enter the Branch id");
		int id = scanner.nextInt();
		return id;
	}

	
//	public static List<Branch> addBranchlist(Branch branch){
//		
//	}
	
	
	
	
	
	
	
	
	
}
