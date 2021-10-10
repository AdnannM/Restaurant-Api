package com.adnannmuratovic.service;

import java.util.Collection;
import java.util.List;

import com.adnannmuratovic.dao.RestaurantDAO;
import com.adnannmuratovic.dto.RestaurantDTO;


public interface RestaurantService {

	List <RestaurantDTO> getAllRestaurant();

	Collection <RestaurantDAO> getRestaurant();
	
	RestaurantDTO createRestaurant(RestaurantDTO restaurant);
	
	RestaurantDAO getRestaurant(String id);
	
	RestaurantDTO updateRestaurant(Integer id, RestaurantDTO restaurant);

	void deleteRestaurant(Integer id);
	
//	void deleteLocation(String address);
//	
//	void deleteContact(String phoneNumber);
}