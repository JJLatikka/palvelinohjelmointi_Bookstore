package bookstore.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String passHash;

	@Column(name = "role", nullable = false)
	private String role;

	public AppUser() {
	}

	public AppUser(String username, String passHash, String role) {
		this.username = username;
		this.passHash = passHash;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String uN) {
		this.username = uN;
	}

	public String getPassHash() {
		return passHash;
	}

	public void setPassHash(String pH) {
		this.passHash = pH;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String r) {
		this.role = r;
	}

	@Override
	public String toString() {
		return String.format("User{ name: %s, password: %s, role: %s }", username, passHash, role);
	}

}
