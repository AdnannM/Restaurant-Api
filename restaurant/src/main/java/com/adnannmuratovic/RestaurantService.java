package com.adnannmuratovic;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

	List <RestaurantDTO> getAllRestaurant();

	Optional<Restaurant> updateEmployee(Integer id, Restaurant restaurant);
	void deleteRestaurant(Integer id);
	RestaurantDTO getRestaurantWithName(String restaurantName);

	Optional<Restaurant> updateRestaurant(Integer id, Restaurant restaurant);

}
