package com.adnannmuratovic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl<RetaurantDTO> implements RestaurantService {
	
	  @Autowired
	  private RestaurantRepository restaurantRepository;
	  
	  public List<RestaurantDTO> getAllRestaurant() {
		  List<Restaurant> empListDB = restaurantRepository.findAll();
		  List<RestaurantDTO> resultList = new ArrayList<RestaurantDTO>();
		  
		  if(empListDB.isEmpty()) {
			 return resultList;
		  }
		  
		  for (Restaurant restaurant : empListDB) {
			  RestaurantDTO newRestaurantDTO = new RestaurantDTO();
			  newRestaurantDTO.setId(restaurant.getId());
			  newRestaurantDTO.setRestaurantName(restaurant.getRestaurantName());
			  newRestaurantDTO.setAddress(restaurant.getAddress());
			  newRestaurantDTO.setLat(restaurant.getLat());
			  newRestaurantDTO.setLog(restaurant.getLog());
			  newRestaurantDTO.setPhoneNumber(restaurant.getPhoneNumber());
			  newRestaurantDTO.setRestaurantImageURL(restaurant.getRestaurantImageURL());
			  newRestaurantDTO.setType(restaurant.getType());
			  newRestaurantDTO.setWebSite(restaurant.getWebSite());
			  resultList.add((RestaurantDTO) newRestaurantDTO);
		  }
		  
		  return resultList;
	  }
}
