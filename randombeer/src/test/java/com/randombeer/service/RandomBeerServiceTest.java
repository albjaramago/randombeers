package com.randombeer.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.randombeer.dto.RandomBeerDto;
import com.randombeer.exception.RandomBeerException;
import com.randombeer.model.Beer;
import com.randombeer.model.Brewery;
import com.randombeer.repository.RandomBeerRepository;
import com.randombeer.service.impl.RandomBeerServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=RandomBeerServiceImpl.class)
public class RandomBeerServiceTest {
    
    
    @MockBean
    private RandomBeerRepository randomBeerRepository;
    
    @Autowired
    RandomBeerService randomBeerService;
    
    private Optional<Beer> beerOpt;
    
    
    @Test
    public void testRandomBeerServiceOK() {
        
        given(randomBeerRepository.count()).willReturn((long) 2);
        given(randomBeerRepository.findById(Mockito.anyInt())).willReturn(beerOpt);

        RandomBeerDto randomBeerDto = randomBeerService.findRandomBeer("1");
        
        
        assertThat(randomBeerDto).isNotNull();
        assertThat(randomBeerDto.getName()).isEqualTo("devil backbone");
        assertThat(randomBeerDto.getDescription()).isEqualTo("full bodied amber that is balanced to perfection; rich malt pulled back with a great level of bitterness");
        assertThat(randomBeerDto.getAlcohol()).isEqualTo("4.9");
        assertThat(randomBeerDto.getLocation()).isEqualTo("Galway Bay Brewery Carrowmoneash Station Road Oranmore Galway Republic of Ireland, H91 FA31");
        
    }
    
    @Test(expected = RandomBeerException.class)
    public void testRandomBeerServiceCopyPropetiesException() {
        
        given(randomBeerRepository.count()).willReturn((long) 2);
        given(randomBeerRepository.findById(Mockito.anyInt())).willReturn(Optional.of(new Beer()));
    
        randomBeerService.findRandomBeer("1");
      
    }
    

    @Test(expected = RandomBeerException.class)
    public void testRandomBeerServiceFindByIdException() {
        
        given(randomBeerRepository.count()).willReturn((long) 2);
    
        randomBeerService.findRandomBeer("1");
      
    }
    

    @Before
    public void setRandomBeer() {
        
        Brewery brewery = new Brewery();
        brewery.setLocation("Galway Bay Brewery Carrowmoneash Station Road Oranmore Galway Republic of Ireland, H91 FA31");
        
        Beer beer = new Beer();  
        
        beer.setName("devil backbone");
        beer.setDescription("full bodied amber that is balanced to perfection; rich malt pulled back with a great level of bitterness");
        beer.setAlcohol("4.9");
        beer.setBrewery(brewery);
        
        beerOpt = Optional.of(beer);
        
        
        
    }
    

}
