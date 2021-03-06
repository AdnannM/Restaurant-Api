package com.adnannmuratovic;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantContactRepository extends JpaRepository<RestaurantContactDAO, Integer> {

	@Query(value = "select * from restaurantContact where restaurantContact = :contact", nativeQuery = true)
	Optional<RestaurantContactDAO> getRestaurantWithEmail(String contact);
}
