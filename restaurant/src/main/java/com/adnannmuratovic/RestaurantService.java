package com.adnannmuratovic;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;


public interface RestaurantService {

	List <RestaurantDTO> getAllRestaurant();

	Collection <Restaurant> getRestaurant();
	
	RestaurantDTO createRestaurant(Restaurant restaurant);
	
	Restaurant getRestaurant(String id);
	
	RestaurantDTO updateRestaurant(Integer id, RestaurantDTO restaurant);

	void deleteRestaurant(Integer id);

	
}
