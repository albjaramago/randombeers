package com.randombeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.randombeer.model.Brewery;

@Repository
public interface RandomBeerBreweryRepository extends JpaRepository<Brewery, Integer>{
    

}
