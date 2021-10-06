package com.adnannmuratovic;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

	@Query(value = "select * from restaurant where restaurant_name = :restaurantName", nativeQuery = true)
	Optional<Restaurant> getRestaurantWithName(String restaurantName);
}
