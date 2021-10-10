package com.adnannmuratovic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adnannmuratovic.dao.RestaurantTypeDAO;


@Repository
public interface RestourantTypeRepository extends JpaRepository<RestaurantTypeDAO, Integer> {

	@Query(value = "select * from restaurantType where restaurantType = :type", nativeQuery = true)
	Optional<RestaurantTypeDAO> getRestaurantWithType(String type);
}