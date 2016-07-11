package collaborationportal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Niitusers {
	
	@Id
	@GeneratedValue
	int niitUserId;
	String firstname;
	String lastname;
	String addressline1;
	String addressline2;
	String contact;
	int uid;
	String password;
	String email;
	int pin;
	@javax.persistence.Transient
	private MultipartFile image;
	
	public Niitusers() {
		super();
	}

	

	public int getNiitUserId() {
		return niitUserId;
	}



	public void setNiitUserId(int niitUserId) {
		this.niitUserId = niitUserId;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}



	public MultipartFile getImage() {
		return image;
	}



	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
	
	

}
