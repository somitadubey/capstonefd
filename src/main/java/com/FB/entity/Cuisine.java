package com.FB.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="cuisine")
// @Data -- known bug
@Getter
@Setter
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    

    private String description;


    @Column(name = "cuisine_name")
    private String name;


    public String getname() {
        return name;
    }

    public String getDescription() {
    	return description;
    }
    
    
    
    public void setname(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    	
    }
    
    public Cuisine(String name, String description) {
    	super();
    	this.name = name;
    	this.description = description;
    }

    
    public Cuisine() {
    	
    }
    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }
}