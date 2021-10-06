package com.adnannmuratovic;

import java.util.Objects;

public class RestaurantTypeDTO {

	private Integer id;
	private String type;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestaurantTypeDTO other = (RestaurantTypeDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "RestaurantTypeDTO [id=" + id + ", type=" + type + "]";
	}
	
	
}
