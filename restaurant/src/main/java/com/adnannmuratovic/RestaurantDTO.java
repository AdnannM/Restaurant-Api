package com.adnannmuratovic;

public class RestaurantDTO {
	
	private Integer id;
	private String restaurantName;
	private String address;
	private String phoneNumber;
	private double lat;
	private double log;
	private String restaurantImageURL;
	private String webSite;
	private String type;
	
	
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
	@Override
	public String toString() {
		return "RestaurantDTO [id=" + id + ", restaurantName=" + restaurantName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", lat=" + lat + ", log=" + log + ", restaurantImageURL="
				+ restaurantImageURL + ", webSite=" + webSite + ", type=" + type + "]";
	}
	
	

}
