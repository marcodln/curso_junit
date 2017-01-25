package com.curso.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class TestEjemplos {
	

	//mockito-verify
	
	@Test
	public void TestEjemploMockitoVerify (){
		
		List mockedList = Mockito.mock(List.class);
	
		//acciones
		mockedList.add("one");
		mockedList.clear();
	
		///verify	
		mockedList.add("one");
		Mockito.verify(mockedList).clear();
	
		//verify times
		Mockito.verify(mockedList,Mockito.times(1)).clear();
				
		//order
		InOrder inOrder = Mockito.inOrder(mockedList);
		inOrder.verify(mockedList).add("one");
		inOrder.verify(mockedList).clear();
	}
	
	
	@Test
	public void TestEjemploMockitoSpy() {
	    List<String> spyList = Mockito.spy(new ArrayList<String>());
	     
	    spyList.add("one");
	    spyList.add("two");
	 
	    Mockito.verify(spyList).add("one");
	    Mockito.verify(spyList).add("two");
	 
	    Assert.assertEquals(2, spyList.size());
	 
	    Mockito.doReturn(100).when(spyList).size();
	    Assert.assertEquals(100, spyList.size());
	}
	
	
	
	@Test
	public void TestEjemploMockitoCaptor() {
		List mockList = Mockito.mock(List.class);
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
	 
	    mockList.add("one");
	    Mockito.verify(mockList).add(arg.capture());
	 
	    Assert.assertEquals("one", arg.getValue());
	}

}
