package com.tazouxme.jpa.bo.contract;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.tazouxme.jpa.model.Model1;

public interface IBo1 {
	
	@Transactional(transactionManager = "txManager1", readOnly = true)
	public Set<Model1> findAllFirstModels();
	
	@Transactional(transactionManager = "txManager1")
	public Model1 createFirstModel(Model1 m);

}
