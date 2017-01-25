package com.curso.junit;

public class ClasePrueba {

	 public final String finalMethod() {
	        return "Hola Mundo!";
	    }
	 
	 public static String staticMethod(String name) {
		 return "Hola " + name + " !";
     }
	 
	 private String privateMethod() {
		 
		 return "Hola en privado!";
	 }
	 
	 public String privateMethodCaller() {
		 
		 return privateMethod() + " Bienvenido!";
	}
}
