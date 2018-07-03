package pl.coderslab.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "comments")
public class Comment implements Comparable<Comment>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Pole nie może byc puste.")
	private String content;

	private Timestamp creationTimestamp;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	private User user;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	private Ad ad;

	public Comment() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", creationTimestamp=" + creationTimestamp + ", user="
				+ user + ", ad=" + ad + "]";
	}

	@Override
	public int compareTo(Comment o) {
		if (this.creationTimestamp.before(o.getCreationTimestamp())) {
			return 1;
		}
		if (this.getCreationTimestamp().equals(o.getCreationTimestamp())) {
			return 0;
		} else {
			return -1;
		}

	}

}
