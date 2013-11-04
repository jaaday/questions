package br.ufrn.ceres.bsi.questions.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Endereco extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String city;
	
	@Column(length = 50)
	private String country;
	
	@Column(length = 50)
	private String street;
	
	@Column(length = 50)
	private String suburb;
    
	public Endereco(){
		
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the suburb
	 */
	public String getSuburb() {
		return suburb;
	}

	/**
	 * @param suburb the suburb to set
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	
}
