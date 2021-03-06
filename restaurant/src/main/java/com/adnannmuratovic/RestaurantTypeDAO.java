package com.adnannmuratovic;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurantType")
public class RestaurantTypeDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "restaurantType")
	private String type;
	
	
	@OneToOne(mappedBy = "type")
	private RestaurantDAO restaurantDAO;
	
	public RestaurantTypeDAO() {}	
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
		RestaurantTypeDAO other = (RestaurantTypeDAO) obj;
		return Objects.equals(id, other.id) && Objects.equals(type, other.type);
	}
	
	@Override
	public String toString() {
		return "RestaurantTypeDAO [id=" + id + ", type=" + type + "]";
	}
	
}
