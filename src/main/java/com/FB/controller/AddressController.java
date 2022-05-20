package com.FB.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.FB.dao.AddressRepository;
import com.FB.entity.Address;

public class AddressController {
	
	
	@RestController
	@RequestMapping("api/address")
	public class AddressRest { 
		@Autowired
		AddressRepository addrepo;
		@GetMapping("/")

	@CrossOrigin(origins = "http://localhost:4200")
		public List<Address> getalladdress() {
			return  (List<Address>) addrepo.findAll();
		}
		
		@PostMapping("/")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<Object> addaddress(@RequestBody Address address)
	{
			addrepo.save(address);
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(address.getId()).toUri();  
			return ResponseEntity.created(location).build();
			
	}
		@DeleteMapping("/{id}")
		@CrossOrigin(origins = "http://localhost:4200")
		public boolean deleteaddress(@PathVariable int id) {
			Optional<Address> add = addrepo.findById(id);
			if(add.isPresent()) {
				addrepo.deleteById(id);
				return true;
			}
			return false ;
	}
		@PutMapping("/")
		@CrossOrigin(origins = "http://localhost:4200")
		public Address updateaddress(@RequestBody Address address) {
			Optional<Address> add = addrepo.findById(address.getId());
			if(add.isPresent()) {
				addrepo.save(address);
				return add.get();
			}
			
			return null;
		}
		@GetMapping("/{id}")
		@CrossOrigin(origins ="http://localhost:4200")
		public Address retriveaddress(@PathVariable int id){
			Optional<Address> add = addrepo.findById(id);
			if(add.isPresent()) {
				
				Address address  = add.get();	
				return address ;
			}
			return null ;
		}
	}

	
	
	

}
