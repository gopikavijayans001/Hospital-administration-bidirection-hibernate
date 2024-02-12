package Hospital_app_Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hospitalId;
	@Column(name="Hospital_name")
	private String name;
	@Column(nullable =false)
	private String email;
	private String type;
	@Column(nullable = false)
	private String ceoName;
	
	// One to many relation
	@OneToMany(mappedBy = "hospital",
	fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Branch> branch;

	
	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<Branch> getBranch() {
		return branch;
	}
	public String getCeoName() {
		return ceoName;
	}
	
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
