package Hospital_app_Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hospital_app_Dto.Encounter;
import Hospital_app_Dto.Item;
import Hospital_app_Dto.Medorder;

public class MedorderDao {
	static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	static String statement = "select m from Medorder m";
	static Scanner scanner = new Scanner(System.in);
	static Medorder medorder = new Medorder();

	public static Medorder readMedorder() {

		System.out.println("Enter the Dosage ");
		String dosage = scanner.next();

		System.out.println("Enter the frequency of medicine");
		String frequency = scanner.next();

		System.out.println("Enter the instruction");
		String instruction = scanner.next();

		medorder.setDosage(dosage);
		medorder.setFrequency(frequency);
		medorder.setInstructions(instruction);
		List<Item> itemList = ItemDao.additemList();
		medorder.setItem(itemList);

		return medorder;
	}

	public static Medorder saveMedorder(int id) {

		Encounter encounter = entityManager.find(Encounter.class, id);
		if (encounter != null) {
			Medorder medorder = readMedorder();
			List<Medorder> medorderList = encounter.getMedorder();
			medorderList.add(medorder);
			encounter.setMedorder(medorderList);
			medorder.setEncounter(encounter);
			
			entityTransaction.begin();
			entityManager.persist(medorder);
			entityTransaction.commit();
			System.out.println("Medorder data is saved........");
		} else
			System.out.println("please check the id\n Encounter id doesnt exist");
		return medorder;

	}

	public static List<Medorder> addmedorderList() {
		Medorder readMedorder = readMedorder();
		List<Medorder> medorderList = new ArrayList<Medorder>();
		medorderList.add(readMedorder);
		return medorderList;
	}

	public static void viewMedorderId() {

		Query query = entityManager.createQuery(statement);

		List<Medorder> medorderList = query.getResultList();

		for (Medorder medorder : medorderList) {
			System.out.println("medorder id: "+medorder.getMedorderId());

		}

	}

	public static int enterId() {
		System.out.println("Enter the Medorder_id");
		int id = scanner.nextInt();
		return id;
	}

	public static Medorder searchMedorder(int id) {
		Medorder medorder = entityManager.find(Medorder.class, id);
		if (medorder != null) {
			System.out.println("Medorder Id: " + medorder.getMedorderId());
			System.out.println("Medorder-dosage: " + medorder.getDosage());
			System.out.println("Medorder-frequency: " + medorder.getFrequency());
			System.out.println("Medorder-instructions: " + medorder.getInstructions());
			List<Item> itemlist = medorder.getItem();
			for (Item items : itemlist) {
				System.out.println("Medorder-Item name: " + items.getItemName());
				System.out.println("Medorder-Item Quantity: " + items.getItemQuantity());
				System.out.println("Medorder-Item Type: " + items.getItemType());
				System.out.println("_____________________________");
			}
		}
		return medorder;
	}

	public static void updateDosage(int id) {
		Medorder medorder = entityManager.find(Medorder.class, id);
		if (medorder != null) {
			System.out.println("Enter the dosage");
			String dosage = scanner.next();
			medorder.setDosage(dosage);
			entityTransaction.begin();
			entityManager.merge(medorder);
			entityTransaction.commit();
			System.out.println("Dosage is updated");
		} else
			System.out.println("medorder_id not valid\nplease enter the valid id");

	}

	public static void updateFrequency(int id) {
		Medorder medorder = entityManager.find(Medorder.class, id);
		if (medorder != null) {
			System.out.println("Enter the frequency");
			String frequency = scanner.next();
			medorder.setDosage(frequency);
			entityTransaction.begin();
			entityManager.merge(medorder);
			entityTransaction.commit();
			System.out.println("Frequency is updated");
		} else
			System.out.println("medorder_id not valid\nplease enter the valid id");

	}

	public static void updateInstruction(int id) {
		Medorder medorder = entityManager.find(Medorder.class, id);
		if (medorder != null) {
			System.out.println("Enter the instruction");
			String instruction = scanner.next();
			medorder.setDosage(instruction);
			entityTransaction.begin();
			entityManager.merge(medorder);
			entityTransaction.commit();

			System.out.println("instruction is updated");
		} else
			System.out.println("medorder_id not valid\nplease enter the valid id");

	}

	public static void updateItemdetails(int id) {
		Medorder medorder = entityManager.find(Medorder.class, id);
		if (medorder != null) {

			List<Item> itemlist = medorder.getItem();
			for(Item item:itemlist) {
				ItemDao.viewItemid();
			int enterid =	ItemDao.enterId();
			System.out.println("Enter the Name");
			String name = scanner.next();
				if(item.getItemId()==enterid);
				item.setItemName(name);
				
			}

			System.out.println("Item is updated");
		} else
			System.out.println("medorder_id not valid\nplease enter the valid id");

	}

	public static boolean removeMedorder(int id) {
		Medorder medorder = entityManager.find(Medorder.class, id);

		if (medorder != null) {
			entityTransaction.begin();
			entityManager.remove(medorder);
			entityTransaction.commit();
			System.out.println("medorder removed....");
			return true;
		} else
			System.out.println("medorder is not removed...please enter the valid id");
		return false;
	}

}
