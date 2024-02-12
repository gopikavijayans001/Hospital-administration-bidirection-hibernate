
package Hospital_app_Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private int numDoctors;
	private int numBeds;
	@Column(nullable = false)
	private long phoneNumber;

	@ManyToOne 
	@JoinColumn(name="Hospitals_id")
	private Hospital hospital;
	
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn
	private Address address;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "branch",cascade = CascadeType.ALL)
		private List<Encounter> encounter;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getNumDoctors() {
		return numDoctors;
	}

	public void setNumDoctors(int numDoctors) {
		this.numDoctors = numDoctors;
	}

	public int getNumBeds() {
		return numBeds;
	}

	public void setNumBeds(int numBeds) {
		this.numBeds = numBeds;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Encounter> getEncounter() {
		return encounter;
	}

	public void setEncounter(List<Encounter> encounter) {
		this.encounter = encounter;
	}

}
