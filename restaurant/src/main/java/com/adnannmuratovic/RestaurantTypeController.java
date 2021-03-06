package com.adnannmuratovic;

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
@RequestMapping("/api/restaurants/type/v1")
public class RestaurantTypeController {

	
	@Autowired
	public RestaurantTypeService empService;
	
	@PostMapping("/restaurants/types")
	public ResponseEntity<RestaurantTypeDTO> creteTypes(@Valid @RequestBody RestaurantTypeDTO types) {
		return new ResponseEntity<>(empService.createTypes(types), HttpStatus.OK);
	}


	@GetMapping("/restaurants/types")
	public ResponseEntity<List<RestaurantTypeDTO>> getAllTypes() {
		List<RestaurantTypeDTO> types = empService.getAllTypes();
		return new ResponseEntity<List<RestaurantTypeDTO>>(types, HttpStatus.OK);
	}
	

	@PutMapping(consumes = "application/json", produces = "application/json", path = "/restaurants/types/{id}")
	public ResponseEntity<RestaurantTypeDTO> updateTypes(@PathVariable Integer id, @RequestBody RestaurantTypeDTO types) {
		return new ResponseEntity<>(empService.updateTypes(id, types), HttpStatus.OK);
	}
	
}
