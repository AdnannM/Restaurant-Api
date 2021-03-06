package com.adnannmuratovic;

import java.util.Collection;
import java.util.List;


public interface RestaurantService {

	List <RestaurantDTO> getAllRestaurant();

	Collection <RestaurantDAO> getRestaurant();
	
	RestaurantDTO createRestaurant(RestaurantDTO restaurant);
	
	RestaurantDAO getRestaurant(String id);
	
	RestaurantDTO updateRestaurant(Integer id, RestaurantDTO restaurant);

	void deleteRestaurant(Integer id);

}
