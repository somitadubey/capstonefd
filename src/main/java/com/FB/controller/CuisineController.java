package com.FB.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;






import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.FB.dao.*;
import com.FB.entity.Cuisine;






@RestController
@RequestMapping("api/cuisine")
public class CuisineController {
	
	@Autowired
	CuisineRepository cuidao;
	
	// view all cuisine
	@GetMapping("/")

@CrossOrigin(origins = "http://localhost:4200")
	public List<Cuisine> getallcuisines() {
		return  (List<Cuisine>) cuidao.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/")
	public  ResponseEntity<Object> addcuisines(@RequestBody Cuisine cusine) {
		
		cuidao.save(cusine);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cusine.getId()).toUri();  
		return ResponseEntity.created(location).build();
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	public boolean deletecuisine(@PathVariable int id) {
		Optional<Cuisine> cu = cuidao.findById(id);
		if(cu.isPresent()) {
			cuidao.deleteById(id);
			return true;
		}
		return false ;
		
	}

@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public Cuisine retrivecuisine(@PathVariable int id){
		Optional<Cuisine> cu =  cuidao.findById(id);
		if(cu.isPresent()) {
			
			Cuisine cuisine = cu.get();	
			return cuisine ;
		}
		return null;
}

@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	public Cuisine updateCusisine(@RequestBody Cuisine ucusine,@PathVariable int id ) {
		Optional<Cuisine> cu = cuidao.findById(id);
		if(cu.isPresent()) {
			
			Cuisine cuisine = cu.get();
			cuisine.setDescription(ucusine.getDescription());
			cuisine.setname(ucusine.getname());
			cuidao.save(cuisine);
			return cuisine;
		}
		return ucusine;
		
}	}

	