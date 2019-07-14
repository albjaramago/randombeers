package com.randombeer.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.randombeer.dto.RandomBeerDto;
import com.randombeer.service.RandomBeerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/randombeer")
@Api(tags = {"Operantions on Beer entity"})
public class RandomBeerRest {
    
    @Autowired
    RandomBeerService randomBeerService;

    
    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get ramdom Beer", notes = "gets a beer wich id is calculated randomly ")
    public ResponseEntity<List<RandomBeerDto>> getRandomBeers(@PathVariable String id){
        
       RandomBeerDto randomBeer = randomBeerService.findRandomBeer(id);
       
       List<RandomBeerDto> randomBeers = new ArrayList<>();
       
       randomBeers.add(randomBeer);
        
       return new ResponseEntity<>(randomBeers, HttpStatus.OK);
        
    }
    
}
