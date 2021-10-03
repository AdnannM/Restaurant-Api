package com.adnannmuratovic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class RestaurantController {

	@Autowired
	private RestaurantService empService;

	@GetMapping("/employees")
	public ResponseEntity<List<RestaurantDTO>> getAllEmployees() {
		List<RestaurantDTO> employees = empService.getAllRestaurant();
		return new ResponseEntity<List<RestaurantDTO>>(employees, HttpStatus.OK);
	}
}
