package com.randombeer.service;

import org.springframework.stereotype.Service;

import com.randombeer.dto.RandomBeerDto;


@Service
public interface RandomBeerService {
   
    /**
     * @param id
     * @return
     */
    RandomBeerDto findRandomBeer(String id);
}
