package com.adnannmuratovic;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantLocationRepository extends JpaRepository<RestaurantLocationDAO, Integer> {

	@Query(value = "select * from restaurantLocation where restaurantLocation = :location", nativeQuery = true)
	Optional<RestaurantLocationDAO> getRestaurantWithAddress(String location);

}
