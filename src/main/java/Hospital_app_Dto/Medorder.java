package Hospital_app_Dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Medorder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int medorderId;
	private String dosage;
	private String frequency;
	@CreationTimestamp
	private LocalDateTime orderDateTime;
	private String instructions;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name="Medorder_id"),inverseJoinColumns = @JoinColumn(name="Items_id"))
	private List<Item> items;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn
	private Encounter encounter;

	public int getMedorderId() {
		return medorderId;
	}

	public void setMedorderId(int medorderId) {
		this.medorderId = medorderId;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<Item> getItem() {
		return items;
	}

	public void setItem(List<Item> item) {
		this.items = item;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

}
