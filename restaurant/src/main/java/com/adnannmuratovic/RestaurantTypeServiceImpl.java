package com.adnannmuratovic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RestaurantTypeServiceImpl implements RestaurantTypeService {

	@Autowired
	  public RestourantTypeRepository restaurantTypeRepository;
	
	
	// GET ALL TYPE FROM DTO
	 public List<RestaurantTypeDTO> getAllTypes() {
		 
		  List<RestaurantTypeDAO> empListType = restaurantTypeRepository.findAll();
		  List<RestaurantTypeDTO> resultList = new ArrayList<RestaurantTypeDTO>();
		  
		  if(empListType.isEmpty()) {
			 return resultList;
		  }
		  
		  for (RestaurantTypeDAO restaurantType : empListType) {
			  RestaurantTypeDTO newRestaurantTypeDTO = new RestaurantTypeDTO();
			  newRestaurantTypeDTO.setId(restaurantType.getId());
			  newRestaurantTypeDTO.setType(restaurantType.getType());
			  
			  resultList.add(newRestaurantTypeDTO);
		  }
		  
		  return resultList;
	 }
	 
	 public void deleteTypes(Integer id) {
		 if (restaurantTypeRepository.getById(id).getId().equals(id)) {
			 boolean exist = restaurantTypeRepository.existsById(id);
				
				if (!exist) {
					throw new IllegalStateException(
							"Restaurant Type with id " + id + " does not exist"
					);
				}
				
				restaurantTypeRepository.deleteById(id);
		 }
	 }
	 
	 // CRREATE TYPES 
	 public RestaurantTypeDTO createTypes(RestaurantTypeDTO types) {
		 
		 RestaurantTypeDAO createType = new RestaurantTypeDAO();
//		 createType.setId(types.getId());
		 createType.setType(types.getType());
		 
		 RestaurantTypeDAO saveType = restaurantTypeRepository.save(createType);
		 
		 RestaurantTypeDTO dtoType = new RestaurantTypeDTO();
		 
		 dtoType.setId(saveType.getId());
		 dtoType.setType(saveType.getType());
		 
		 return dtoType;
	 }
	 
	 public RestaurantTypeDTO updateTypes(Integer id, RestaurantTypeDTO types) {
		 Optional<RestaurantTypeDAO> typesResultFromBase = Optional.of(restaurantTypeRepository
					.findById(id)
					.orElseThrow(() -> new IllegalStateException(
							"Restaurant with type id " + types + " not Exist"
		)));
		 
		 
		
		 typesResultFromBase.get().setType(types.getType());
		 
		 RestaurantTypeDAO saveTypes = restaurantTypeRepository.save(typesResultFromBase.get());
		 
		 RestaurantTypeDTO dto = new RestaurantTypeDTO();
		 
		 dto.setId(saveTypes.getId());
		 dto.setType(saveTypes.getType());
		 
		 return dto;
		 
	 }
	 
}
