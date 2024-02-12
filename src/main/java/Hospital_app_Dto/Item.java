package Hospital_app_Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private String itemQuantity;
	private double unitPrice;
	
	@ManyToMany(mappedBy = "items")
	

	private List<Medorder> medorder;


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public List<Medorder> getMedorder() {
		return medorder;
	}

	public void setMedorder(List<Medorder> medorder) {
		this.medorder = medorder;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
