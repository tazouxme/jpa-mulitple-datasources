package com.tazouxme.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "first_model")
@NamedQueries({
	@NamedQuery(name = "Model1.findAll", query = "select m from Model1 m")
})
public class Model1 {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "name", length = 50, unique = true)
	private String name;
	
	@Column(name = "description", length = 250)
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
