package com.adnannmuratovic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springfox.documentation.swagger2.mappers.ModelMapper;



@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	  @Autowired
	  private RestaurantRepository restaurantRepository;
	  @Autowired
	  private RestourantTypeRepository restaurantTypeRepository;
	  @Autowired
	  private RestaurantLocationRepository restaurantLocationRepository;
	  @Autowired
	  private RestaurantContactRepository restaurantContactRepository;

	  Map<String, RestaurantDAO> newRestaurant;
	  
	  
	  public List<RestaurantDTO> getAllRestaurant() {
		  List<RestaurantDAO> empListDB = restaurantRepository.findAll();
		  List<RestaurantDTO> resultList = new ArrayList<RestaurantDTO>();
		
		  
		  if(empListDB.isEmpty()) {
			 return resultList;
		  }
		  
		  for (RestaurantDAO restaurantDAO : empListDB) {
			  RestaurantDTO newRestaurantDTO = new RestaurantDTO();
			  newRestaurantDTO.setId(restaurantDAO.getId());
			  newRestaurantDTO.setRestaurantName(restaurantDAO.getRestaurantName());
			  newRestaurantDTO.setRestaurantImageURL(restaurantDAO.getRestaurantImageURL());
			  
			  RestaurantTypeDTO dtoType = newRestaurantDTO.getType();
			  dtoType.setId(newRestaurantDTO.getId());
			  
			  
			  //List<RestaurantLocationDAO> locationList = restaurantLocationRepository.findAll();
			  List<RestaurantLocationDTO> locationListDTO = new ArrayList<RestaurantLocationDTO>();
			  List<RestaurantLocationDAO> daoLocations = restaurantDAO.getAddress();
			  
			  for (RestaurantLocationDAO restaurantLocationDao : daoLocations) {
				  RestaurantLocationDTO restaurantLocationDTO = new RestaurantLocationDTO();
				  restaurantLocationDTO.setAddress(restaurantLocationDao.getAddress());
				  restaurantLocationDTO.setCity(restaurantLocationDao.getCity());
				  restaurantLocationDTO.setLatitude(restaurantLocationDao.getLatitude());
				  restaurantLocationDTO.setLongitude(restaurantLocationDao.getLongitude());
				  locationListDTO.add(restaurantLocationDTO);
			  }
			  
			  newRestaurantDTO.setLocation(locationListDTO);
			    
			  resultList.add((RestaurantDTO) newRestaurantDTO);
		  }
		  
		  
		  // DTO Contact
		  
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
		
		// Delete by Location
		
	}
	
	@Override
	public Collection<RestaurantDAO> getRestaurant() {
		return restaurantDAO.values();
	}
	
	Map<String, RestaurantDAO> restaurantDAO;
	
	
	
	/*
	 *  - TODO:
	 *  	- Create New RestaurantTypeDTO
	 *  	- And Save
	 */
	
	@Override
	public RestaurantDTO createRestaurant(RestaurantDTO restaurant) {
		
		RestaurantDAO createRestaurant = new RestaurantDAO();
		
		//createRestaurant.setId(restaurant.getId());
		createRestaurant.setRestaurantName(restaurant.getRestaurantName());
		createRestaurant.setRestaurantImageURL(restaurant.getRestaurantImageURL());
		
		RestaurantTypeDTO typeDTO = restaurant.getType();
				
		Optional<RestaurantTypeDAO> typeDaoResult = Optional.of(restaurantTypeRepository
				.findById(typeDTO.getId()).orElseThrow(() -> new IllegalStateException(
						"Restaurant Type  " + restaurant + " not Exist"
				)));
		
		createRestaurant.setType(typeDaoResult.get());
		
		RestaurantDAO saveRestaurant = restaurantRepository.save(createRestaurant);
		
		RestaurantDTO restaurantDTO = new RestaurantDTO();
		restaurantDTO.setRestaurantName(saveRestaurant.getRestaurantName());
		restaurantDTO.setRestaurantImageURL(saveRestaurant.getRestaurantName());

		restaurantDTO.setId(saveRestaurant.getId());
		
		
		if(saveRestaurant.getType() != null && saveRestaurant.equals(restaurantDTO) ){
			RestaurantTypeDTO newTypeDTO = new RestaurantTypeDTO();
			 typeDTO.setId(restaurant.getType().getId());
			 restaurantDTO.setType(newTypeDTO);
		}

		return restaurantDTO;

	}
	
	@Override
	public RestaurantDAO getRestaurant(String id) {
		return newRestaurant.get(id);
	}
	
	@Override
	@Transactional
	public RestaurantDTO updateRestaurant(Integer id, RestaurantDTO restaurant) {
		
		Optional<RestaurantDAO> restaurantFromBaseResult = Optional.of(restaurantRepository
				.findById(id).orElseThrow(() -> new IllegalStateException(
						"Restaurant with id " + restaurant + " not Exist"
				)));

		RestaurantDAO restaurantFromBase = restaurantFromBaseResult.get();
				
		restaurantFromBase.setRestaurantName(restaurant.getRestaurantName());
		restaurantFromBase.setRestaurantImageURL(restaurant.getRestaurantImageURL());
	    		
		// RestaurantType
		RestaurantTypeDTO typeDTO = restaurant.getType();
		
		Optional<RestaurantTypeDAO> restaurantTypeFromBaseResult = Optional.of(restaurantTypeRepository
				.findById(typeDTO.getId()).orElseThrow(() -> new IllegalStateException(
						"Restaurant with id " + restaurant + " not Exist"
				)));
		
		RestaurantTypeDAO restaurantTypeFromBase = restaurantTypeFromBaseResult.get();
		
		restaurantFromBase.setType(restaurantTypeFromBase);

		
		RestaurantDAO savedRest = restaurantRepository.save(restaurantFromBase);
		
		// Restaurant
		RestaurantDTO dto = new RestaurantDTO();
		
		dto.setRestaurantName(savedRest.getRestaurantName());
		dto.setRestaurantImageURL(savedRest.getRestaurantImageURL());
		dto.setId(savedRest.getId());
		
		
		if(restaurant.getType() != null && restaurant.equals(dto) ){
			RestaurantTypeDTO newTypeDTO = new RestaurantTypeDTO();
			 typeDTO.setId(restaurant.getType().getId());
			 dto.setType(newTypeDTO);
		}

		return dto;
	}
}
