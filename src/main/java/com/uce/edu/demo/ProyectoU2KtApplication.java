package com.uce.edu.demo;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.respository.modelo.deber.onetomany.Autor2;
import com.uce.edu.demo.respository.modelo.deber.onetomany.Libro2;
import com.uce.edu.demo.respository.modelo.deber.onetomany.LibroAutor2;
import com.uce.edu.demo.service.deber.onetomany.IAutor2Service;
import com.uce.edu.demo.service.deber.onetomany.ILibro2Service;
import com.uce.edu.demo.service.deber.onetomany.ILibroAutor2Service;



@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner {
	private static Logger log = Logger.getLogger(ProyectoU2KtApplication.class);

	@Autowired
	private ILibro2Service iLibro2Service;

	@Autowired
	private IAutor2Service iAutor2Service;
	
	@Autowired
	private ILibroAutor2Service iLibroAutor2Service;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	Libro2 libro2=new Libro2();
	libro2.setTitulo("soledad");
	libro2.setCantidadPaginas(100);
	this.iLibro2Service.insertar(libro2);

	Autor2 autor2=new Autor2();
	autor2.setNombre("Newton3");
	this.iAutor2Service.insertar(autor2);
	
	Autor2 autor3= new Autor2();
	autor3.setNombre("Newton3");
	this.iAutor2Service.insertar(autor3);

	LibroAutor2 libroAutor2 = new LibroAutor2();
	libro2.setId(1);
	autor2.setId(1);
	libroAutor2.setAutor2(autor2);
	libroAutor2.setLibro2(libro2);
	
	this.iLibroAutor2Service.insertar(libroAutor2);
	

	
	}
	

}
