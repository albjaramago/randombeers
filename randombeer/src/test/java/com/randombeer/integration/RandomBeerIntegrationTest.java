package com.randombeer.integration;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.randombeer.RandombeerApplication;
import com.randombeer.model.Beer;
import com.randombeer.model.Brewery;
import com.randombeer.repository.RandomBeerBreweryRepository;
import com.randombeer.repository.RandomBeerRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
  RandombeerApplication.class,  
  H2JpaConfig.class})
@ActiveProfiles("test")
public class RandomBeerIntegrationTest {


	@Autowired
    private RandomBeerRepository randomBeerRepository;
	
	@Autowired
    private RandomBeerBreweryRepository randomBeerBreweryRepository;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
		
	private MockMvc mockMvc;
	
	private Brewery brewery;
	
	private Beer beer1;
	
	private Beer beer2;
	
	
	
	@Test
	public void findById() throws Exception {
		
		randomBeerBreweryRepository.save(brewery);
		randomBeerRepository.save(beer1);
		randomBeerRepository.save(beer2);
	 
	    this.mockMvc.perform(get("/randombeer/1")
	    		.contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(1)))
	      .andExpect(jsonPath("$[0].name", is("puck pilsner")))
	      .andExpect(jsonPath("$[0].description", is("It pours a clean straw-like in colour, with earthy and subtle honey notes on the nose")))
	      .andExpect(jsonPath("$[0].alcohol", is("4.5")))
	      .andExpect(jsonPath("$[0].location", is("Galway Bay Brewery Carrowmoneash Station Road Oranmore Galway Republic of Ireland, H91 FA31")));
	      
	}
	
	
	@Test
	public void findByIdNotFound() throws Exception {

	    this.mockMvc.perform(get("/randombeer")
	    		.contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isNotFound());
	
	}
	
	
	
	  @Before
	    public void setRandomBeer() {
	        
	        brewery = new Brewery();
	        brewery.setId(1);
	        brewery.setLocation("Galway Bay Brewery Carrowmoneash Station Road Oranmore Galway Republic of Ireland, H91 FA31");
	        
	        beer1 = new Beer();        
	        beer1.setName("devil backbone");
	        beer1.setDescription("full bodied amber that is balanced to perfection; rich malt pulled back with a great level of bitterness");
	        beer1.setAlcohol("4.9");
	        beer1.setBrewery(brewery);
	        beer1.setId(new Integer(1));
	        
	        beer2 = new Beer();        
	        beer2.setName("puck pilsner");
	        beer2.setDescription("It pours a clean straw-like in colour, with earthy and subtle honey notes on the nose");
	        beer2.setAlcohol("4.5");
	        beer2.setBrewery(brewery);
	        beer2.setId(new Integer(2));

	        this.mockMvc =  MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 	 

	    }
	
}
