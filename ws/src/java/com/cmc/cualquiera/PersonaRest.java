package com.cmc.cualquiera;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cmc.rest.commons.ArchivoException;
import com.cmc.rest.commons.ValidationException;
import com.cmc.rest.entidades.Consulta;
import com.cmc.rest.entidades.Persona;
import com.cmc.rest.servicios.ManejadorArchivos;
import com.cmc.rest.servicios.ServicioPersonas;
@Path("/personas")
public class PersonaRest {
	@Path("/cambiar")
	@POST
	@Produces(MediaType.APPLICATION_JSON)//application/json
	@Consumes(MediaType.APPLICATION_JSON)
	public Persona modificar(Persona p){
		System.out.println(p);
		Persona s= new Persona(p.getNombre(),p.getApellido(),p.getCedula(),p.getEdad());
		try {
			s = ServicioPersonas.actualizar(s);
			return s;
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Path("/cambio")
	@POST
	@Produces(MediaType.APPLICATION_JSON)//application/json
	@Consumes(MediaType.APPLICATION_JSON)
	public static Response cambiar(Persona persona){
		
		try {
			System.out.println(persona);
			Persona p2 =ServicioPersonas.actualizar(persona);
			return Response.status(200).entity(p2).build();
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return Response.status(200).entity(e.getMessage()).build();
		}

	}
	@Path("/cambios")
	@GET
	@Produces(MediaType.APPLICATION_JSON)//application/json
	public Response consultarPersonas(){
		ManejadorArchivos manejador = new ManejadorArchivos("ArchivoCliente.txt");
		ArrayList<Persona> personas= null;
		try{
			personas= manejador.leer();
		}catch(ArchivoException e){
			return Response.status(200).entity(e.getMessage()).build();
		}
		return Response.status(200).entity(personas).build();
	}
	@Path("/busqueda")
	@POST
	@Produces(MediaType.APPLICATION_JSON)//application/json
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscarPorCedula(Consulta cedula){
		try {
			return Response.status(200).entity(ServicioPersonas.buscarPorCedula(cedula.getCedula())).build();
		} catch (ArchivoException e) {
			return Response.status(200).entity(e.getMessage()).build();
		}
	}
}
