package Hospital_app_Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hospital_app_Dto.Item;
import Hospital_app_Dto.Medorder;

public class ItemDao {

	static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	static String statement = "select i from Item i";
	static Scanner scanner = new Scanner(System.in);
	static Item item = new Item();

	// method to view the item id and names
	public static void viewItemid() {
		Query query = entityManager.createQuery(statement);
		List<Item> itemList = query.getResultList();
		for (Item item : itemList) {
			System.out.println("item_id: "+item.getItemId());
		}

	}

	// search method
	public static Item searchItem(int id) {
		Item item = entityManager.find(Item.class, id);

		if (item != null) {

			System.out.println("item_id: "+item.getItemId());
			System.out.println("item_name "+item.getItemName());
			System.out.println("item_quantity: "+item.getItemQuantity());
			System.out.println("item_type: "+item.getItemType());
			System.out.println("item_price: "+item.getUnitPrice());
			System.out.println("item_description: "+item.getItemDescription());

			return item;
		} else
			System.out.println("The item is not found");
		return null;

	}

	public static Item updateName(int id) {
		Item updateItem = entityManager.find(Item.class, id);
		if (updateItem != null) {
			System.out.println("Enter the Name");
			String updateName = scanner.next();
			updateItem.setItemName(updateName);

			entityTransaction.begin();
			entityManager.merge(updateItem);
			entityTransaction.commit();
			System.out.println("item name updated successfully.....");
		} else
			System.out.println("Item id doesn't exist");
		return updateItem;

	}

	public static Item updatePrice(int id) {
		Item updateItem = entityManager.find(Item.class, id);
		if (updateItem != null) {
			System.out.println("Enter the number of doctors");
			double updatePrice = scanner.nextDouble();
			updateItem.setUnitPrice(updatePrice);

			entityTransaction.begin();
			entityManager.merge(updateItem);
			entityTransaction.commit();
			System.out.println("Unit price  updated");
		} else
			System.out.println("Item id doesn't exist");
		return updateItem;

	}

	public static Item updateDescription(int id) {
		Item updateItem = entityManager.find(Item.class, id);
		if (updateItem != null) {
			System.out.println("Enter the Name");
			String description = scanner.next();
			updateItem.setItemDescription(description);

			entityTransaction.begin();
			entityManager.merge(updateItem);
			entityTransaction.commit();
			System.out.println("Description updated");
		} else
			System.out.println("Item id doesn't exist");
		return updateItem;

	}

	public static boolean removeItem(int id) {
		Item Item = entityManager.find(Item.class, id);

		if (Item != null) {
			entityTransaction.begin();
			entityManager.remove(Item);
			entityTransaction.commit();
			System.out.println("Branch removed....");
			return true;
		} else
			System.out.println("Branch is not removed...please enter the valid id");
		return false;
	}

	public static Item readItem() {
		System.out.println("Enter the item name");
		String name = scanner.next();

		System.out.println("Enter the item quantity");
		String quantity = scanner.next();

		System.out.println("Enter the type ");
		String type = scanner.next();

		System.out.println("Enter the Description ");
		String description = scanner.next();
//		scanner.next();
		System.out.println("Enter the unitprice ");
		double unitprice = scanner.nextDouble();

		item.setItemName(name);
		item.setItemType(type);
		item.setItemQuantity(quantity);
		item.setItemDescription(description);
		item.setUnitPrice(unitprice);

		// set the medorder list
//List<Medorder> medorderlist=MedorderDao.addmedorderList();
//item.setMedorder(medorderlist);
		System.out.println("inserted...");
		return item;
	}

	public static int enterId() {
		System.out.println("Enter the id");
		int id = scanner.nextInt();
		return id;
	}

	public static List<Item> additemList() {
		Item item = ItemDao.readItem();
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item);

		return itemList;

	}
}
