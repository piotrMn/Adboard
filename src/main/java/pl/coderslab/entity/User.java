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

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String fullname;

	private String username;
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(columnDefinition="VARCHAR(68)")
	private String password;
	
	@Column(columnDefinition="TINYINT(1)")
	private int enabled;

	private String email;
	
	private String phone;

	@CreationTimestamp
	private Timestamp creationTimestamp;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Ad> ads = new ArrayList<>();
	
	//constructor
	public User() {
	}
	
	//getters & setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		String passwordEncrypted = BCrypt.hashpw(password, BCrypt.gensalt());
		this.password = "{bcrypt}" + passwordEncrypted;
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

}
