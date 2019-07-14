package com.randombeer.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the breweries database table.
 * 
 */
@Entity
@Table(name="breweries")
public class Brewery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String location;

	private String name;

	//bi-directional many-to-one association to Beer
	@OneToMany(mappedBy="brewery")
	private List<Beer> beers;

	public Brewery() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Beer> getBeers() {
		return this.beers;
	}

	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}



}