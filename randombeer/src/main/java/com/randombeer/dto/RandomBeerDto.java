package com.randombeer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "description", "alcohol", "location" })
@ApiModel(description = "Random beer data transference object")
public class RandomBeerDto {

	@JsonProperty("id")
	@ApiModelProperty(value = "Beer id.")
	private Integer id;
    @JsonProperty("name")
    @ApiModelProperty(value = "Beer name.")
    private String name;
    @JsonProperty("description")
    @ApiModelProperty(value = "Description of the beer.")
    private String description;
    @JsonProperty("alcohol")
    @ApiModelProperty(value = "Acohol percentage")
    private String alcohol;
    @JsonProperty("location")
    @ApiModelProperty(value = "Location of the brewery")
    private String location;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("alcohol")
    public String getAlcohol() {
        return alcohol;
    }

    @JsonProperty("alcohol")
    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    
    
    public RandomBeerDto() {
        super();
    }

    public RandomBeerDto(Integer id, String name, String description, String alcohol, String location) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.alcohol = alcohol;
        this.location = location;
    }
    
    
    
    

}