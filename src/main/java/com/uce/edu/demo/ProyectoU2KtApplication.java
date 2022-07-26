package com.uce.edu.demo;


import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.respository.modelo.manytomany.Autor;
import com.uce.edu.demo.respository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.manytomany.ILibroService;



@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner {
	private static Logger log = Logger.getLogger(ProyectoU2KtApplication.class);

	@Autowired
	private ILibroService iILibroService;
//
//	@Autowired
//	private IAutorService iAutorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		
	Autor autor1= new Autor();
	autor1.setNombre("Newton");
	Autor autor2= new Autor();
	autor1.setNombre("Newton2");
	
	Set<Autor>autores=new HashSet<>();
	autores.add(autor1);
	autores.add(autor2);

	Libro libro1=new Libro();
	libro1.setTitulo("Cien años de soledad");
	libro1.setCantidadPaginas(100);
	libro1.setAutores(autores);
	
	
	this.iILibroService.insertar(libro1);
	

	
	}
	

}
