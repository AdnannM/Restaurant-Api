package com.adnannmuratovic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


	@Override
	public Optional<Restaurant> updateRestaurant(Integer id, Restaurant restaurant) {
		Optional<Restaurant> newRestaurant = restaurantRepository.findById(id);
		newRestaurant.get().setRestaurantName(restaurant.getRestaurantName());
		newRestaurant.get().setAddress(restaurant.getAddress());
		newRestaurant.get().setLat(restaurant.getLat());
		newRestaurant.get().setLog(restaurant.getLog());
		newRestaurant.get().setPhoneNumber(restaurant.getPhoneNumber());
		newRestaurant.get().setRestaurantImageURL(restaurant.getRestaurantImageURL());
		newRestaurant.get().setType(restaurant.getType());
		newRestaurant.get().setWebSite(restaurant.getWebSite());
		restaurantRepository.save(newRestaurant.get());
		
		return newRestaurant;
	}

	@Override
	public void deleteRestaurant(Integer id)  {
		 if (restaurantRepository.getById(id).getId().equals(id)){
			 restaurantRepository.deleteById(id);
	        } 
	    }

	@Override
	public RestaurantDTO getRestaurantWithName(String restaurantName) {
		return restaurantRepository.getRestaurantWithName(restaurantName);
	}		  
}
