package com.cmc.rest.test;

import com.cmc.rest.commons.ValidationException;
import com.cmc.rest.entidades.Persona;
import com.cmc.rest.servicios.ServicioPersonas;

public class TestActualizar {

	public static void main(String[] args) {
		Persona p= new Persona("122345","Andres","Quiroz",0);
		System.out.println("Persona original");
		System.out.println(p);
		Persona o;
		try {
			o = ServicioPersonas.actualizar(p);
			System.out.println("Persona modificada");
			System.out.println(o);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
