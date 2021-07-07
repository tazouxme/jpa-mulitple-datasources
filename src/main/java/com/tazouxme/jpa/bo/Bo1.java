package com.tazouxme.jpa.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.tazouxme.jpa.bo.contract.IBo1;
import com.tazouxme.jpa.dao.contract.IDao1;
import com.tazouxme.jpa.model.Model1;

public class Bo1 implements IBo1 {
	
	@Autowired
	private IDao1 dao;

	@Override
	public Set<Model1> findAllFirstModels() {
		return dao.findAllFirstModels();
	}

	@Override
	public Model1 createFirstModel(Model1 m) {
		return dao.createFirstModel(m);
	}

}
