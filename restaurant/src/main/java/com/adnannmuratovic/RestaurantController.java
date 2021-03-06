package com.adnannmuratovic;

import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestaurantController {

	@Autowired
	private RestaurantService empService;

	
	@GetMapping
	public ResponseEntity<Collection<RestaurantDAO>> getRestaurant() {
		
		return new ResponseEntity<>(empService.getRestaurant(), HttpStatus.OK);
	}
	
	
	@PostMapping("/restaurants")
	public ResponseEntity<RestaurantDTO> createRestaurant(@Valid @RequestBody RestaurantDTO restaurant) {
		return new ResponseEntity<>(empService.createRestaurant(restaurant), HttpStatus.OK);
	}


	@GetMapping("/restaurants")
	public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
		List<RestaurantDTO> restaurant = empService.getAllRestaurant();
		return new ResponseEntity<List<RestaurantDTO>>(restaurant, HttpStatus.OK);
	}
	

	@PutMapping(consumes = "application/json", produces = "application/json", path = "/restaurant/{id}")
	public ResponseEntity<RestaurantDTO> updateRestaurant(@PathVariable Integer id, @RequestBody RestaurantDTO restaurant) {
		return new ResponseEntity<>(empService.updateRestaurant(id, restaurant), HttpStatus.OK);
	}
}


