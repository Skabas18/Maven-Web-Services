package com.cmc.rest.servicios;

import java.util.ArrayList;

import com.cmc.rest.commons.ArchivoException;
import com.cmc.rest.commons.ValidationException;
import com.cmc.rest.entidades.Persona;

public class ServicioPersonas {
	public static Persona actualizar(Persona p) throws ValidationException{
		if(p.getNombre().length()<=3){
			throw new ValidationException("Nombre muy corto");
		}else{
			p.setNombre(p.getNombre().toUpperCase());
			p.setApellido(p.getApellido().toUpperCase());
		}if(p.getApellido().length()<=3){
			throw new ValidationException("Apellido muy corto ");
		}else{
			p.setNombre(p.getNombre().toUpperCase());
			p.setApellido(p.getApellido().toUpperCase());
		}
		 return p;
	}
	public static Persona buscarPorCedula(String s) throws ArchivoException{
		
		String ruta="Punto6.txt";
		ManejadorArchivos a= new ManejadorArchivos(ruta);
		ArrayList<Persona> p=a.leer();
		for (Persona persona : p) {
			if(persona.getCedula().equals(s)){
				return persona;
			}
		}
		return null;
	}
}
