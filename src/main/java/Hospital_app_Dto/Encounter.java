package Hospital_app_Dto;

import java.time.LocalDateTime;
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

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int encounterId;
	@CreationTimestamp
	private LocalDateTime admissionDateTime;
	private String dischargeDate;
	@Column(name = "Doctor_name")
	private String doctorName;
	private String procedure;
	private String testResult;
	private String symptoms;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "encounter",cascade=CascadeType.ALL)
	private List<Medorder> medorder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Person person;

	@ManyToOne
	@JoinColumn(name = "encounterBranch_id")
	private Branch branch;

	public int getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}

	public LocalDateTime getAdmissionDateTime() {
		return admissionDateTime;
	}

	public void setAdmissionDateTime(LocalDateTime admissionDateTime) {
		this.admissionDateTime = admissionDateTime;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public List<Medorder> getMedorder() {
		return medorder;
	}

	public void setMedorder(List<Medorder> medorder) {
		this.medorder = medorder;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
