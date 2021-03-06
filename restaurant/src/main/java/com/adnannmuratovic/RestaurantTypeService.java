package com.adnannmuratovic;

import java.util.List;

public interface RestaurantTypeService {

	List <RestaurantTypeDTO> getAllTypes();

	void deleteTypes(Integer id);
	
	RestaurantTypeDTO createTypes(RestaurantTypeDTO types);
	
	RestaurantTypeDTO updateTypes(Integer id, RestaurantTypeDTO types);
}
