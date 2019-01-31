package renzo.work.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	// Define fields and add annotations
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="last_name")
	public String lastName;
	
	@Column(name="first_name")
	public String firstName;
	
	@Column(name="email")
	public String email;
	
	// Create constructors
	public Customer() {
		
	}

	public Customer(String lastname, String firstname, String email) {
		super();
		this.lastName = lastname;
		this.firstName = firstname;
		this.email = email;
	}

	// Create getters and setters
	
	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", lastname=" + lastName + ", firstname=" + firstName + ", email=" + email + "]";
	}
	
}
