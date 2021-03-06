package com.cmc.rest.entidades;

import java.util.Date;

import com.cmc.rest.commons.DateUtil;

public class Persona {
	private String cedula;
	private String nombre;
	private String apellido;
	private int edad;
	private String fechaCreacion;
	public Persona( String nombre, String apellido,String cedula, int edad) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad= edad;
		Date d = new Date();
		this.fechaCreacion = DateUtil.convertir(d);
	
	}
	public Persona(){
		
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	
}
