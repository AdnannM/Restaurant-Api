package com.adnannmuratovic;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "restaurantName")
	private String restaurantName;
	@Column(name = "address")
	private String address;
	@Column(name = "phoneNumber")
	private String phoneNumber;
	@Column(name = "lat")
	private double lat;
	@Column(name = "log")
	private double log;
	@Column(name = "restaurantImageURL")
	private String restaurantImageURL;
	@Column(name = "webSite")
	private String webSite;
	private String type;

	
	@Enumerated(EnumType.STRING)
	
	@Column(name = "restaurant_type")
	private RestaurantType restaurantType;
	
	public RestaurantType getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(RestaurantType restaurantType) {
		this.restaurantType = restaurantType;
	}

	public Restaurant() {}
	
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
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
				+ ", webSite=" + webSite + ", type=" + type + ", restaurantType=" + restaurantType + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, id, lat, log, phoneNumber, restaurantImageURL, restaurantName, restaurantType,
				type, webSite);
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
				&& Objects.equals(restaurantName, other.restaurantName) && restaurantType == other.restaurantType
				&& Objects.equals(type, other.type) && Objects.equals(webSite, other.webSite);
	}	
}
