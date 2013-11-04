package br.ufrn.ceres.bsi.questions.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({@NamedQuery(name = "Usuario.populateUsers", query = "SELECT u FROM Usuario u"),
@NamedQuery(name = "Usuario.countUsersTotal", query = "SELECT COUNT(u) FROM Usuario u")})
public class Usuario extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 50)
	private String username;
	
	@Column(length = 50)
	private String firstname;
	
	@Column(length = 50)
	private String lastname;
	
	@Column(length = 50)
	private String email;
	
	@Column(length = 64)
	private String password;
	
	@OneToOne(cascade = {CascadeType.ALL})
    private Endereco address;
    
	public Usuario(){
		address = new Endereco();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the address
	 */
	public Endereco getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Endereco address) {
		this.address = address;
	}
}
