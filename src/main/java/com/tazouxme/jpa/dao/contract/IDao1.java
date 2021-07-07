package com.tazouxme.jpa.dao.contract;

import java.util.Set;

import com.tazouxme.jpa.model.Model1;

public interface IDao1 {
	
	public Set<Model1> findAllFirstModels();
	
	public Model1 createFirstModel(Model1 m);
	
}
