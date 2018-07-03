package pl.coderslab.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import pl.coderslab.validator.Password;
import pl.coderslab.validator.Phone;

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Ad> ads = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Comment> comments = new ArrayList<>();

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

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


}
