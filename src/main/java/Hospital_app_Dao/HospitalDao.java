package Hospital_app_Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hospital_app_Dto.Hospital;
import Hospital_app_Helper.BranchHelper;

public class HospitalDao {

	static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	static String statement = "select h from Hospital h";
	static Scanner scanner = new Scanner(System.in);

	public static void saveHospital(Hospital hospital) {
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		System.out.println("Hospital added sucessfully...");

	}

	public static void searchHospital(int id) {
		// Find the hospital by ID
		Hospital searchHospital = entityManager.find(Hospital.class, id);

		if (searchHospital != null) {
			// Print the details of the found hospital
			System.out.println("Hospital details for ID " + id + ":");
			System.out.println(searchHospital.getHospitalId());
			System.out.println(searchHospital.getName());
			System.out.println(searchHospital.getCeoName());
			System.out.println(searchHospital.getType());
			System.out.println(searchHospital.getEmail());
		} else {
			System.out.println("Hospital with ID " + id + " not found.");
		}
	}

	public static void viewHospitalId() {

		Query query = entityManager.createQuery(statement);

		List<Hospital> hospitalList = query.getResultList();

		for (Hospital hospital : hospitalList) {
			System.out.println(hospital.getHospitalId());
			System.out.println(hospital.getName());

		}

	}

	public static Hospital updateName(int id) {
		Hospital updateHospital = entityManager.find(Hospital.class, id);
		if (updateHospital != null) {
			System.out.println("Enter the Name");
			String updateName = scanner.next();
			updateHospital.setName(updateName);

			entityTransaction.begin();
			entityManager.merge(updateHospital);
			entityTransaction.commit();
			System.out.println("Hospital name is updated");
		}
		return updateHospital;

	}

	public static Hospital updateCeoname(int id) {
		Hospital updateHospital = entityManager.find(Hospital.class, id);
		if (updateHospital != null) {
			System.out.println("Enter the Ceo Name");
			String updateCeoname = scanner.next();
			updateHospital.setName(updateCeoname);

			entityTransaction.begin();
			entityManager.merge(updateHospital);
			entityTransaction.commit();
			System.out.println("Hospital Ceo name is updated");

		}
		return updateHospital;

	}

	public static Hospital updateType(int id) {
		Hospital updateHospital = entityManager.find(Hospital.class, id);
		if (updateHospital != null) {
			System.out.println("Enter the hospital type");
			String updatetype = scanner.next();
			updateHospital.setName(updatetype);

			entityTransaction.begin();
			entityManager.merge(updateHospital);
			entityTransaction.commit();
			System.out.println("Hospital type is updated.....");
		}
		return updateHospital;

	}

	public static boolean removeHospital(int id) {

		Hospital hospital = entityManager.find(Hospital.class, id);
		if (hospital != null) {
			entityTransaction.begin();
			entityManager.refresh(hospital);
			entityTransaction.commit();
			System.out.println("Hospital is removed....");
			return true;
		}

		else
			return false;

	}
	
	
	
	public static void findHospital(int id) {
		
	Hospital hospital=	entityManager.find(Hospital.class, id);
		if(hospital!=null) {
			//branch inserted
			BranchDao.readBranch(hospital);
			
		}
		else
			System.out.println("The hospital is not found in the given id");
		
	}

}
