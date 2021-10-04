package com.adnannmuratovic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

	void save(RestaurantDTO newRestaurant);

	RestaurantDTO getRestaurantWithName(String restaurantName);

	MessageResponse updateRestaurant(Integer id, RestaurantDTO restaurant);

	void deleteEmployee(Integer id);

}
