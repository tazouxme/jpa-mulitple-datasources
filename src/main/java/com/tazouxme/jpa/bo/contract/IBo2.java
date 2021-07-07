package com.tazouxme.jpa.bo.contract;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.tazouxme.jpa.model.Model2;

public interface IBo2 {
	
	@Transactional(transactionManager = "txManager2", readOnly = true)
	public Set<Model2> findAllSecondModels();
	
	@Transactional(transactionManager = "txManager2")
	public Model2 createSecondModel(Model2 m);

}
