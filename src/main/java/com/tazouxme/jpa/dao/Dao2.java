package com.tazouxme.jpa.dao;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tazouxme.jpa.dao.contract.IDao2;
import com.tazouxme.jpa.model.Model2;

public class Dao2 implements IDao2 {
	
	@PersistenceContext(unitName = "PU2")
	private EntityManager em2;

	@Override
	public Set<Model2> findAllSecondModels() {
		return em2.createNamedQuery("Model2.findAll", Model2.class).getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Model2 createSecondModel(Model2 m) {
		em2.persist(m);
		return m;
	}

}
