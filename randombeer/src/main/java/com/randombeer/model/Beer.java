package com.randombeer.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the beers database table.
 * 
 */
@Entity
@Table(name="beers")
public class Beer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String alcohol;

	private String description;

	private String name;

	//bi-directional many-to-one association to Brewery
	@ManyToOne
	@JoinColumn(name="brewery")
	private Brewery brewery;

	public Beer() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlcohol() {
		return this.alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brewery getBrewery() {
		return this.brewery;
	}

	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}

}