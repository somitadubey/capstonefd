package com.FB.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.FB.entity.Cuisine;

@CrossOrigin("http://localhost:4200")
public interface CuisineRepository extends JpaRepository<Cuisine, Integer > {



}