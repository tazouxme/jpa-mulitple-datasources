package com.tazouxme.jpa.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.tazouxme.jpa.bo.contract.IBo2;
import com.tazouxme.jpa.dao.contract.IDao2;
import com.tazouxme.jpa.model.Model2;

public class Bo2 implements IBo2 {
	
	@Autowired
	private IDao2 dao;

	@Override
	public Set<Model2> findAllSecondModels() {
		return dao.findAllSecondModels();
	}

	@Override
	public Model2 createSecondModel(Model2 m) {
		return dao.createSecondModel(m);
	}

}
