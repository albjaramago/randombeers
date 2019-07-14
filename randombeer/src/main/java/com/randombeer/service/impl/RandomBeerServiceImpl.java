package com.randombeer.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randombeer.dto.RandomBeerDto;
import com.randombeer.exception.ExceptionMessage;
import com.randombeer.exception.RandomBeerException;
import com.randombeer.model.Beer;
import com.randombeer.repository.RandomBeerRepository;
import com.randombeer.service.RandomBeerService;


@Service
public class RandomBeerServiceImpl implements RandomBeerService{

    @Autowired
    RandomBeerRepository randomBeerRepository;
    

    /* (non-Javadoc)
     * @see com.randombeer.service.RandomBeerService#findRandomBeer(java.lang.String)
     */
    public RandomBeerDto findRandomBeer(String id) {
                 
    	Integer randomId = this.getRandomId(id);
        
        Beer beer = randomBeerRepository.findById(randomId).orElseThrow(() -> new RandomBeerException(ExceptionMessage.RANDOM_BEER_NOT_FOUND.getValue()));     
        
        RandomBeerDto randomBeerDto = new RandomBeerDto();
                   
        try {
            BeanUtils.copyProperties(randomBeerDto, beer.getBrewery());
            BeanUtils.copyProperties(randomBeerDto, beer);           
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
            throw new RandomBeerException(ExceptionMessage.COPY_BEAN_PROPERTIES_ERROR.getValue(), e);
        }
            
        
        return randomBeerDto;

        
    }
    
    
    /**
     * @param id
     * @return
     * 
     * Gets a random id.
     * In order to not repeat the same id, the method is recursively called until the new id
     * is different to the previous one (@param id) 
     * 
     * 
     */
    private Integer getRandomId(String id) {
    	
    	Integer randomId = ThreadLocalRandom.current().nextInt(1, (int) (randomBeerRepository.count() + 1));
    	
    	if(randomId.equals(Integer.valueOf(id))) {   		
    		randomId = this.getRandomId(id);
    	}
    	return randomId;	
    	
    }
   
    
}
