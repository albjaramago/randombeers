package com.randombeer.rest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.randombeer.dto.RandomBeerDto;
import com.randombeer.service.RandomBeerService;



@RunWith(SpringRunner.class)
@SpringBootTest(classes=RandomBeerRest.class)
public class RandomBeerRestTest {
    
    private MockMvc mockMvc;

    @MockBean
    RandomBeerService randomBeerService;
    
  
    @InjectMocks
    private RandomBeerRest randomBeerRest;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(randomBeerRest).build();
    }


    @Test
    public void testGetRandomBeerOk() throws Exception {

        given(this.randomBeerService.findRandomBeer("1")).willReturn(new RandomBeerDto());
        this.mockMvc.perform(get("/randombeer/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
    
    @Test
    public void testGetRandomBeerNotFound() throws Exception {

        given(this.randomBeerService.findRandomBeer("1")).willReturn(null);
        this.mockMvc.perform(get("/randombeer").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

}
