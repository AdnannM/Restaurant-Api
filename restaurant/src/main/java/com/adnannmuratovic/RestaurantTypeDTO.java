package com.adnannmuratovic;



public class RestaurantTypeDTO {

	private Integer id;
	private String type;
	
	public RestaurantTypeDTO() {

	}
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
        return id == null ? 0 : id.hashCode();
    }
	
}
