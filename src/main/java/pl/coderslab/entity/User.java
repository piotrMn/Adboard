package pl.coderslab.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import pl.coderslab.validator.Password;
import pl.coderslab.validator.Phone;
import pl.coderslab.validator.UsernameDuplicate;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Pole nie może byc puste.")
	@Size(min = 8, max = 30, message = "Co najmniej 8 znaków")
	private String fullname;

	@NotBlank(message = "Pole nie może byc puste.")
	@Size(min = 5, max = 30, message = "Co najmniej 5 znaków")
	@UsernameDuplicate(message = "Taki użytkownik już istnieje")
	private String username;

	@Column(columnDefinition = "VARCHAR(68)")
	@Password(message = "8-30 znaków. Wielka litera, mała i cyfra")
	private String password;

	@Column(columnDefinition = "TINYINT(1)")
	private int enabled;

	@Email(message = "Niepoprawny format adresu.")
	@NotBlank(message = "Pole nie może byc puste.")
	private String email;

	@Phone(message = "Tylko cyfry")
	private String phone;

	@CreationTimestamp
	private Timestamp creationTimestamp;

	// constructor
	public User() {
	}

	// getters & setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp signupDate) {
		this.creationTimestamp = signupDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
