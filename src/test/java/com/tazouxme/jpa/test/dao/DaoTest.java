package com.tazouxme.jpa.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.tazouxme.jpa.dao.contract.IDao1;
import com.tazouxme.jpa.dao.contract.IDao2;
import com.tazouxme.jpa.model.Model1;
import com.tazouxme.jpa.model.Model2;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/applicationContext-test.xml")
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class DaoTest {
	
	@Autowired
	private IDao1 dao1;
	
	@Autowired
	private IDao2 dao2;
	
	@Test
	@Order(1)
	@Transactional(transactionManager = "txManager1")
	public void testFindAll1Success() {
		Set<Model1> models = dao1.findAllFirstModels();
		assertEquals(0, models.size());
	}
	
	@Test
	@Order(2)
	@Transactional(transactionManager = "txManager2")
	public void testFindAll2Success() {
		Set<Model2> models = dao2.findAllSecondModels();
		assertEquals(0, models.size());
	}
	
	@Test
	@Order(3)
	@Transactional(transactionManager = "txManager1")
	public void testCreate1Success() {
		Model1 m = new Model1();
		m.setName("name1");
		m.setDescription("desc1");
		
		dao1.createFirstModel(m);
		
		Set<Model1> models = dao1.findAllFirstModels();
		assertEquals(1, models.size());
	}
	
	@Test
	@Order(4)
	@Transactional(transactionManager = "txManager2")
	public void testCreate2Success() {
		Model2 m = new Model2();
		m.setName("name2");
		m.setDescription("desc2");
		
		dao2.createSecondModel(m);
		
		Set<Model2> models = dao2.findAllSecondModels();
		assertEquals(1, models.size());
	}
	
	@Test
	@Order(5)
	@Transactional(transactionManager = "txManager1")
	public void testAnotherCreate1Success() {
		Model1 m = new Model1();
		m.setName("nameX");
		m.setDescription("descX");
		
		dao1.createFirstModel(m);
		
		Set<Model1> models = dao1.findAllFirstModels();
		assertEquals(2, models.size());
	}
	
	@Test
	@Order(6)
	@Transactional(transactionManager = "txManager2")
	public void testAnotherCreate2Success() {
		Model2 m = new Model2();
		m.setName("nameX");
		m.setDescription("descX");
		
		dao2.createSecondModel(m);
		
		Set<Model2> models = dao2.findAllSecondModels();
		assertEquals(2, models.size());
	}

}
