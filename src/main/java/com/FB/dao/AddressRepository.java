package com.FB.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.FB.entity.*;
@Repository 
public interface AddressRepository extends CrudRepository <Address , Integer>{

}
