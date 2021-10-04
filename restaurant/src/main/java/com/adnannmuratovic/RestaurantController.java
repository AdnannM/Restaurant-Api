package com.adnannmuratovic;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping("/api")
public class RestaurantController {

	@Autowired
	private RestaurantService empService;
	RestaurantRepository restaurantRepository;

	@GetMapping("/restaurants")
	public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
		List<RestaurantDTO> restaurant = empService.getAllRestaurant();
		return new ResponseEntity<List<RestaurantDTO>>(restaurant, HttpStatus.OK);
	}
	
	 @PutMapping("/update/{id}")
	    public ResponseEntity<MessageResponse> updateEmployee( @PathVariable Integer id, @RequestBody RestaurantDTO restaurant) {
	        MessageResponse updateRestaurant = restaurantRepository.updateRestaurant(id, restaurant);
	        return new ResponseEntity<>(updateRestaurant, HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
		 restaurantRepository.deleteEmployee(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
