package com.adnannmuratovic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	  @Autowired
	  private RestaurantRepository restaurantRepository;
	  @Autowired
	  private RestourantTypeRepository restaurantTypeRepository;
	  
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
			  newRestaurantDTO.setWebSite(restaurant.getWebSite());
			  
			  if(restaurant.getType() != null ){
				  RestaurantTypeDTO typeDTO = new RestaurantTypeDTO();
				  typeDTO.setId(restaurant.getType().getId());
				  typeDTO.setType(restaurant.getType().getType());
				  newRestaurantDTO.setType(typeDTO);
					
				}
			  
			  
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
	
	
	
	/*
	 *  - TODO:
	 *  	- Create New RestaurantTypeDTO
	 *  	- And Save
	 */
	
	@Override
	public RestaurantDTO createRestaurant(RestaurantDTO restaurant) {
		
		Restaurant createRestaurant = new Restaurant();
		
		//createRestaurant.setId(restaurant.getId());
		createRestaurant.setRestaurantName(restaurant.getRestaurantName());
		createRestaurant.setAddress(restaurant.getAddress());
		createRestaurant.setRestaurantImageURL(restaurant.getRestaurantImageURL());
		createRestaurant.setLat(restaurant.getLat());
		createRestaurant.setLog(restaurant.getLog());
		createRestaurant.setPhoneNumber(restaurant.getPhoneNumber());
		createRestaurant.setWebSite(restaurant.getWebSite());
		
		
		RestaurantTypeDTO typeDTO = restaurant.getType();
		
		
		Optional<RestaurantTypeDAO> typeDaoResult = Optional.of(restaurantTypeRepository
				.findById(typeDTO.getId()).orElseThrow(() -> new IllegalStateException(
						"Restaurant Type  " + restaurant + " not Exist"
				)));
		
		createRestaurant.setType(typeDaoResult.get());
		
		Restaurant saveRestaurant = restaurantRepository.save(createRestaurant);
		
		RestaurantDTO restaurantDTO = new RestaurantDTO();
		restaurantDTO.setRestaurantName(saveRestaurant.getRestaurantName());
		restaurantDTO.setAddress(saveRestaurant.getAddress());
		restaurantDTO.setRestaurantImageURL(saveRestaurant.getRestaurantName());
		restaurantDTO.setPhoneNumber(saveRestaurant.getPhoneNumber());
		restaurantDTO.setLat(saveRestaurant.getLat());
		restaurantDTO.setLog(saveRestaurant.getLog());
		restaurantDTO.setWebSite(saveRestaurant.getWebSite());
		restaurantDTO.setId(saveRestaurant.getId());
		
		
		if(saveRestaurant.getType() != null && saveRestaurant.equals(restaurantDTO) ){
			RestaurantTypeDTO newTypeDTO = new RestaurantTypeDTO();
			 typeDTO.setId(restaurant.getType().getId());
			 restaurantDTO.setType(newTypeDTO);
		}

		return restaurantDTO;

	}
	
	@Override
	public Restaurant getRestaurant(String id) {
		return newRestaurant.get(id);
	}
	
	@Override
	@Transactional
	public RestaurantDTO updateRestaurant(Integer id, RestaurantDTO restaurant) {
		
		Optional<Restaurant> restaurantFromBaseResult = Optional.of(restaurantRepository
				.findById(id).orElseThrow(() -> new IllegalStateException(
						"Restaurant with id " + restaurant + " not Exist"
				)));

		Restaurant restaurantFromBase = restaurantFromBaseResult.get();
				
		restaurantFromBase.setRestaurantName(restaurant.getRestaurantName());
		restaurantFromBase.setRestaurantImageURL(restaurant.getRestaurantImageURL());
		restaurantFromBase.setAddress(restaurant.getAddress());
		restaurantFromBase.setPhoneNumber(restaurant.getPhoneNumber());
		restaurantFromBase.setLat(restaurant.getLat());
		restaurantFromBase.setLog(restaurant.getLog());
		
	    
		
		// RestaurantType
		RestaurantTypeDTO typeDTO = restaurant.getType();
		
		Optional<RestaurantTypeDAO> restaurantTypeFromBaseResult = Optional.of(restaurantTypeRepository
				.findById(typeDTO.getId()).orElseThrow(() -> new IllegalStateException(
						"Restaurant with id " + restaurant + " not Exist"
				)));
		
		RestaurantTypeDAO restaurantTypeFromBase = restaurantTypeFromBaseResult.get();
		
		restaurantFromBase.setType(restaurantTypeFromBase);

		// Save
		Restaurant savedRest = restaurantRepository.save(restaurantFromBase);
		
		// Restaurant
		RestaurantDTO dto = new RestaurantDTO();
		
		dto.setAddress(savedRest.getAddress());
		dto.setRestaurantName(savedRest.getRestaurantName());
		dto.setRestaurantImageURL(savedRest.getRestaurantImageURL());
		dto.setPhoneNumber(savedRest.getPhoneNumber());
		dto.setLat(savedRest.getLat());
		dto.setLog(savedRest.getLog());
		dto.setWebSite(savedRest.getWebSite());
		dto.setId(savedRest.getId());
		
		
		if(restaurant.getType() != null && restaurant.equals(dto) ){
			RestaurantTypeDTO newTypeDTO = new RestaurantTypeDTO();
			 typeDTO.setId(restaurant.getType().getId());
			 dto.setType(newTypeDTO);
		}

		return dto;
	}
}
