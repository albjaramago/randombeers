package com.randombeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.randombeer.model.Beer;

@Repository
public interface RandomBeerRepository extends JpaRepository<Beer, Integer>{
    

}
