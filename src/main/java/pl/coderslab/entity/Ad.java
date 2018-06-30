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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import pl.coderslab.entity.Category;

@Entity
@Table(name = "ads")
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Size(min = 6, message = "Co najmniej 6 znaków.")
	private String title;

	@Column(columnDefinition = "MEDIUMTEXT")
	@NotBlank(message = "Pole nie może byc puste.")
	private String description;
	
	@NotBlank(message = "Pole nie może byc puste.")
	private String location;
	
	@CreationTimestamp
	private Timestamp creationTimestamp;
	
	private Timestamp expiryTimestamp;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	private User user;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "ad_category",
			joinColumns = @JoinColumn(name = "ad_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
			)
	private List<Category> categories = new ArrayList<>();

	//constructor
	public Ad() {
	}
	
	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getExpiryTimestamp() {
		return expiryTimestamp;
	}

	public void setExpiryTimestamp(Timestamp expiryTimestamp) {
		this.expiryTimestamp = expiryTimestamp;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Ad [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", creationTimestamp=" + creationTimestamp + ", expiryTimestamp=" + expiryTimestamp + ", user=" + user
				+ "]";
	}
	
	


}
