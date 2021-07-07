package com.tazouxme.jpa.dao;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tazouxme.jpa.dao.contract.IDao1;
import com.tazouxme.jpa.model.Model1;

public class Dao1 implements IDao1 {
	
	@PersistenceContext(unitName = "PU1")
	private EntityManager em1;

	@Override
	public Set<Model1> findAllFirstModels() {
		return em1.createNamedQuery("Model1.findAll", Model1.class).getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Model1 createFirstModel(Model1 m) {
		em1.persist(m);
		return m;
	}

}
