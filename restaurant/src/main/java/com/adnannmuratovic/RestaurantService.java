package com.adnannmuratovic;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
@Repository("restaurantServicel")
public interface RestaurantService {

	List <RestaurantDTO> getAllRestaurant();

	Collection <Restaurant> getRestaurant();
	
	RestaurantDTO createRestaurant(RestaurantDTO restaurant);
	
	Restaurant getRestaurant(String id);
	
	RestaurantDTO updateRestaurant(Integer id, RestaurantDTO restaurant);

	void deleteRestaurant(Integer id);


	
}
