package com.adnannmuratovic;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "restaurant_name")
	private String restaurantName;
	@Column(name = "address")
	private String address;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "lat")
	private double lat;
	@Column(name = "log")
	private double log;
	@Column(name = "restaurant_imageurl")
	private String restaurantImageURL;
	@Column(name = "web_site")
	private String webSite;

	

	@OneToOne
	@JoinColumn(name = "type_id", referencedColumnName = "id", nullable = true)
	private RestaurantTypeDAO type; 
	
	public Restaurant() {}

	public RestaurantTypeDAO getType() {
		return type;
	}

	public void setType(RestaurantTypeDAO type) {
		this.type = type;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLog() {
		return log;
	}
	public void setLog(double log) {
		this.log = log;
	}
	public String getRestaurantImageURL() {
		return restaurantImageURL;
	}
	public void setRestaurantImageURL(String restaurantImageURL) {
		this.restaurantImageURL = restaurantImageURL;
	}
	
	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", restaurantName=" + restaurantName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", lat=" + lat + ", log=" + log + ", restaurantImageURL=" + restaurantImageURL
				+ ", webSite=" + webSite + ", type=" + type + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, id, lat, log, phoneNumber, restaurantImageURL, restaurantName, webSite);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(address, other.address) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(lat) == Double.doubleToLongBits(other.lat)
				&& Double.doubleToLongBits(log) == Double.doubleToLongBits(other.log)
				&& Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(restaurantImageURL, other.restaurantImageURL)
				&& Objects.equals(restaurantName, other.restaurantName)
			    && Objects.equals(webSite, other.webSite);
	}	
}
