package com.curso.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//for working with PowerMockito 
@RunWith(PowerMockRunner.class)
//tell PowerMockito to prepare all types of this package
@PrepareForTest(fullyQualifiedNames = "com.curso.junit.*")
public class TestPowerMock {
	
	
	
	@Test
	public void TestEjemploPmFinal() throws Exception{
		
		ClasePrueba mock = PowerMockito.mock(ClasePrueba.class);
		PowerMockito.whenNew(ClasePrueba.class).withNoArguments().thenReturn(mock);
		
		ClasePrueba clasePrueba = new ClasePrueba();
		PowerMockito.verifyNew(ClasePrueba.class).withNoArguments();
		
		PowerMockito.when(clasePrueba.finalMethod()).thenReturn("Hola Mundo!");
		
		String welcome = clasePrueba.finalMethod();
		
		Mockito.verify(clasePrueba).finalMethod();
		
		Assert.assertEquals("Hola Mundo!", welcome);
		
	}
	@Test
	public void TestEjemploPmStatic() throws Exception{
		
		PowerMockito.mockStatic(ClasePrueba.class);
		
		PowerMockito.when(ClasePrueba.staticMethod(Mockito.anyString())).thenReturn("Hola Mundo! Static");
		
		String welcome = ClasePrueba.staticMethod("ok");
		
		PowerMockito.verifyStatic();
		
		Assert.assertEquals("Hola Mundo! Static", welcome);
			
		
	}
	@Test
	public void TestEjemploPmPrivado() throws Exception{
			
		ClasePrueba clasePrueba = new ClasePrueba();
		
		ClasePrueba mock = PowerMockito.spy(clasePrueba);
		
		PowerMockito.when(mock, "privateMethod").thenReturn("soy un metodo privado!");
		
		String welcome = mock.privateMethodCaller();
		
		PowerMockito.verifyPrivate(mock).invoke("privateMethod");
		
		Assert.assertEquals("soy un metodo privado! Bienvenido!", welcome);
		
	}
	
	
	
	
	

}
