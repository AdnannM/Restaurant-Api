package com.adnannmuratovic;

import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.Table;

@Entity
@Table(name = "restaurantContact")
public class RestaurantContactDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Integer id;
	@Column(name = "email")
	private String email;
	@Column(name = "phoneNumber")
	private String phoneNumber;
	@Column(name = "webSite")
	private String webSite;
	
	
	@ManyToOne
    @JoinColumn(name="restaurant_id", nullable=false)
	private RestaurantDAO restaurantDAO;
	
	
	public RestaurantDAO getRestaurantDAO() {
		return restaurantDAO;
	}

	public void setRestaurantDAO(RestaurantDAO restaurantDAO) {
		this.restaurantDAO = restaurantDAO;
	}

	public RestaurantContactDAO() {
		
	}
	
	public RestaurantContactDAO(Integer id, String email, String phoneNumber, String webSite, RestaurantDAO restaurantDAO) {
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.webSite = webSite;
		this.restaurantDAO = restaurantDAO;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, phoneNumber, restaurantDAO, webSite);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestaurantContactDAO other = (RestaurantContactDAO) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(restaurantDAO, other.restaurantDAO)
			    && Objects.equals(webSite, other.webSite);
	}
	@Override
	public String toString() {
		return "RestaurantContactDAO [id=" + id + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", webSite=" + webSite + ", restaurantDAO=" + restaurantDAO + "]";
	}
	
	
}
