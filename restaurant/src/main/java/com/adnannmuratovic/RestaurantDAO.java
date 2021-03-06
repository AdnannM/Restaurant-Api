package com.adnannmuratovic;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "restaurant")
public class RestaurantDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "restaurant_name")
	private String restaurantName;
	@Column(name = "restaurant_imageurl")
	private String restaurantImageURL;
	

	
	@OneToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
	private RestaurantTypeDAO type; 
	
	
	@OneToMany(mappedBy="restaurantDAO", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<RestaurantLocationDAO> address;
	
	@OneToMany(mappedBy="restaurantDAO",fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<RestaurantContactDAO> contact;

	

	public RestaurantTypeDAO getType() {
		return type;
	}

	public void setType(RestaurantTypeDAO type) {
		this.type = type;
	}

	public List<RestaurantContactDAO> getContact() {
		return contact;
	}

	public void setContact(List<RestaurantContactDAO> contact) {
		this.contact = contact;
	}

	public List<RestaurantLocationDAO> getAddress() {
		return address;
	}

	public void setAddress(List<RestaurantLocationDAO> address) {
		this.address = address;
	}

	public RestaurantDAO(Integer id, String restaurantName, String restaurantImageURL) {
		this.id = id;
		this.restaurantName = restaurantName;
		this.restaurantImageURL = restaurantImageURL;
	}

	public RestaurantDAO() {
		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public String getRestaurantImageURL() {
		return restaurantImageURL;
	}
	public void setRestaurantImageURL(String restaurantImageURL) {
		this.restaurantImageURL = restaurantImageURL;
	}

	@Override
	public String toString() {
		return "RestaurantDAO [id=" + id + ", restaurantName=" + restaurantName + ", restaurantImageURL="
				+ restaurantImageURL + ", type=" + type + ", address=" + address + ", contact=" + contact + "]";
	}

	


	
}
