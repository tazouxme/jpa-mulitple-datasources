package com.tazouxme.jpa.dao.contract;

import java.util.Set;

import com.tazouxme.jpa.model.Model2;

public interface IDao2 {
	
	public Set<Model2> findAllSecondModels();
	
	public Model2 createSecondModel(Model2 m);

}
