package com.adnannmuratovic;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantDAO, Integer>{

	@Query(value = "select * from restaurant where restaurant_name = :restaurantName", nativeQuery = true)
	Optional<RestaurantDAO> getRestaurantWithName(String restaurantName);
}
