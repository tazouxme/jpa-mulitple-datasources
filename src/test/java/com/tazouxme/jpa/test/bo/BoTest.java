package com.tazouxme.jpa.test.bo;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.tazouxme.jpa.bo.Bo1;
import com.tazouxme.jpa.bo.Bo2;
import com.tazouxme.jpa.bo.contract.IBo1;
import com.tazouxme.jpa.bo.contract.IBo2;
import com.tazouxme.jpa.dao.contract.IDao1;
import com.tazouxme.jpa.dao.contract.IDao2;
import com.tazouxme.jpa.model.Model1;
import com.tazouxme.jpa.model.Model2;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BoTest {
	
	@Mock
	private IDao1 dao1;
	@Mock
	private IDao2 dao2;
	
	@InjectMocks
	private IBo1 bo1 = new Bo1();
	@InjectMocks
	private IBo2 bo2 = new Bo2();
	
	@Test
	public void testFindAll1Success() {
		Mockito.when(dao1.findAllFirstModels()).thenReturn(new HashSet<Model1>());
		
		bo1.findAllFirstModels();
		Mockito.verify(dao1).findAllFirstModels();
	}
	
	@Test
	public void testFindAll2Success() {
		Mockito.when(dao2.findAllSecondModels()).thenReturn(new HashSet<Model2>());
		
		bo2.findAllSecondModels();
		Mockito.verify(dao2).findAllSecondModels();
	}
	
	@Test
	public void testCreate1Success() {
		Model1 m = new Model1();
		Mockito.when(dao1.createFirstModel(Mockito.any())).thenReturn(m);
		
		bo1.createFirstModel(m);
		Mockito.verify(dao1).createFirstModel(m);
	}
	
	@Test
	public void testCreate2Success() {
		Model2 m = new Model2();
		Mockito.when(dao2.createSecondModel(Mockito.any())).thenReturn(m);
		
		bo2.createSecondModel(m);
		Mockito.verify(dao2).createSecondModel(m);
	}

}
