package com.cmc.rest.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.cmc.rest.commons.ArchivoException;
import com.cmc.rest.entidades.Persona;

public class ManejadorArchivos {
	private String rutaArchivo;
	//private static Logger logger = LogManager.getLogger(ManejadorArchivos.class); 
	public ManejadorArchivos(String rutaArchivo){
		this.rutaArchivo=rutaArchivo;
	}
	public ArrayList<Persona> leer() throws ArchivoException {
		File f = new File(rutaArchivo);
		System.out.println(f.getAbsolutePath());
		BufferedReader br= null;
		FileReader fr= null;
		ArrayList<Persona> personas= new ArrayList<Persona>();
		String linea= "";
		String[] partes;
		Persona p;
		try {
			fr = new FileReader(f);
			/*int leido=fr.read();
			System.out.println("Leido: "+leido);*/
			br = new BufferedReader(fr);
			/*String linea=br.readLine();
			System.out.println(linea);*/
			while((linea=br.readLine()) !=null){
				partes=linea.split("-");
				p= new Persona( partes[0],partes[1],partes[2], Integer.parseInt(partes[3]));
				personas.add(p);
			}
		} catch (FileNotFoundException e) {
			//logger.error("No existe el archivo",e);
			System.out.println("No existe el archivo");
			//throw new ToxicaException("No existe el archivo"+rutaArchivo);
			throw new ArchivoException("No existe el archivo"+rutaArchivo);
		} catch (IOException e) {
			//logger.error("Error al leer el archivo",e);
			System.out.println("Error al leer el archivo");
			//throw new ToxicaException("Error al leer el archivo"+rutaArchivo);
			throw new ArchivoException("No existe el archivo"+rutaArchivo);
		}finally{
			try {
				if(br !=null){
					br.close();
				}
				
			} catch (IOException e) {
				//logger.error("Error al cerrar el BufferedReader",e);
				System.out.println("Error al cerrar el BufferedReader");
			}
			try {
				if(fr !=null){
				fr.close();
				}
			} catch (IOException e) {
				//logger.error("Error al cerrar el FileReader",e);
				System.out.println("Error al cerrar el FileReader");
			}
		}
		return personas;
	}
}
