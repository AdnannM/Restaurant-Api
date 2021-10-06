package com.adnannmuratovic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	  @Autowired
	  private RestaurantRepository restaurantRepository;
	  
	  Map<String, Restaurant> newRestaurant;
	  
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
	public void deleteRestaurant(Integer id) {
		
		if (restaurantRepository.getById(id).getId().equals(id)){
			boolean exist = restaurantRepository.existsById(id);
			
			if (!exist) {
				throw new IllegalStateException(
						"Restaurant with id " + id + " does not exist"
				);
			}
			 restaurantRepository.deleteById(id);
        } 
		
	}
	
	@Override
	public Collection<Restaurant> getRestaurant() {
		return restaurant.values();
	}
	
	Map<String, Restaurant> restaurant;
	
	@Override
	public RestaurantDTO createRestaurant(Restaurant restaurant) {
		Restaurant createRestaurant = new Restaurant();
		
		createRestaurant.setRestaurantName(restaurant.getRestaurantName());
		createRestaurant.setAddress(restaurant.getAddress());
		createRestaurant.setLat(restaurant.getLat());
		createRestaurant.setLog(restaurant.getLog());
		createRestaurant.setPhoneNumber(restaurant.getPhoneNumber());
		createRestaurant.setRestaurantImageURL(restaurant.getRestaurantImageURL());
		createRestaurant.setType(restaurant.getType());
		createRestaurant.setWebSite(restaurant.getWebSite());
		
		Restaurant savedRest = restaurantRepository.save(createRestaurant);
		
		RestaurantDTO dto = new RestaurantDTO();
		
		Optional<Restaurant> restaurantByName = restaurantRepository.getRestaurantWithName(restaurant.getRestaurantName());
		
		if(restaurantByName.isPresent()) {
			throw new IllegalStateException(
					"Restaurant name " + restaurantByName + " not Found"
			);
		}
		
		dto.setAddress(savedRest.getAddress());
		dto.setRestaurantName(savedRest.getRestaurantName());
		dto.setRestaurantImageURL(savedRest.getRestaurantImageURL());
		dto.setPhoneNumber(savedRest.getPhoneNumber());
		dto.setLat(savedRest.getLat());
		dto.setLog(savedRest.getLog());
		dto.setType(savedRest.getType());
		dto.setWebSite(savedRest.getWebSite());
		dto.setId(savedRest.getId());
		return dto;
	}
	
	@Override
	public Restaurant getRestaurant(String id) {
		return newRestaurant.get(id);
	}

	@Override
	public RestaurantDTO updateRestaurant(Integer id, RestaurantDTO restaurant) {
		
		Optional<Restaurant> restaurantFromBaseResult = Optional.of(restaurantRepository
				.findById(id).orElseThrow(() -> new IllegalStateException(
						"Restaurant with id " + restaurant + " not exist"
				)));

		Restaurant restaurantFromBase = restaurantFromBaseResult.get();
		
		restaurantFromBase.setRestaurantName(restaurant.getRestaurantName());
		restaurantFromBase.setRestaurantImageURL(restaurant.getRestaurantImageURL());
		restaurantFromBase.setAddress(restaurant.getAddress());
		restaurantFromBase.setPhoneNumber(restaurant.getPhoneNumber());
		restaurantFromBase.setLat(restaurant.getLat());
		restaurantFromBase.setLog(restaurant.getLog());
		restaurantFromBase.setType(restaurant.getType());
	    
		Restaurant savedRest = restaurantRepository.save(restaurantFromBase);
		
		RestaurantDTO dto = new RestaurantDTO();
		dto.setAddress(savedRest.getAddress());
		dto.setRestaurantName(savedRest.getRestaurantName());
		dto.setRestaurantImageURL(savedRest.getRestaurantImageURL());
		dto.setPhoneNumber(savedRest.getPhoneNumber());
		dto.setLat(savedRest.getLat());
		dto.setLog(savedRest.getLog());
		dto.setType(savedRest.getType());
		dto.setWebSite(savedRest.getWebSite());
		dto.setId(savedRest.getId());
		return dto;
	}
}
