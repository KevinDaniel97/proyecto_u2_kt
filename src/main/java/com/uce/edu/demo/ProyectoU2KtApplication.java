package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.autor.modelo.Autor;
import com.uce.edu.demo.autor.modelo.Libro;
import com.uce.edu.demo.autor.service.IAutorService;
import com.uce.edu.demo.autor.service.ILibroService;

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner {
	private static Logger log = Logger.getLogger(ProyectoU2KtApplication.class);

	@Autowired
	private ILibroService iILibroService;

	@Autowired
	private IAutorService iAutorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
	Autor autor1= new Autor();
	autor1.setNombre("Adam");
	autor1.setApellido("Walker");
	autor1.setPais("EEUU");
	autor1.setFechaNacimiento(LocalDateTime.of(1947, 02, 03,0,0));
	
	//insetar
	this.iAutorService.insertar(autor1);
	log.info("****Se inserto el autor: "+autor1);
	Autor autor2= new Autor();
	autor2.setNombre("Paul");
	autor2.setApellido("Auster");
	autor2.setPais("EE.UU");
	autor2.setFechaNacimiento(LocalDateTime.of(1950, 02, 03,0,0));
	
	
	//actualizar
	//this.iAutorService.actualizar(autor2);
	log.info("****Se actualizo el autor "+autor2);
	//buscar
	log.info("****Se busca el autor por id: "+this.iAutorService.buscarPorId(2));
	//eliminar
	this.iAutorService.eliminar(12);
	log.info("****Se elimino el autor con id: 4");
	
//******* Crud Libros	
		
	//Buscar numero 
	Autor aut= new Autor();
	aut.setId(3);
	
	Libro libro1=new Libro();
	libro1.setTitulo("Cien años de soledad");
	libro1.setEditorial("Sudamericana");
	libro1.setGenero("Fantasia");
	libro1.setAutor(aut);

	Libro libro2=new Libro();
	libro2.setTitulo("Cronica de una muerte");
	libro2.setEditorial("Sudamericana");
	libro2.setGenero("Magico");
	libro2.setAutor(aut);
	
	//insertar
	this.iILibroService.insertar(libro1);
	this.iILibroService.insertar(libro2);
	log.info("****Se inserto el libro: "+libro2);
	//buscar
	log.info("****Se busca el libro por Id: "+this.iILibroService.buscarPorId(1));
	//actualizar
	this.iILibroService.actualizar(libro2);
	log.info("****Se actualizo el libro: "+libro2);
	//eliminar
	this.iILibroService.eliminar(3);
	log.info("****Se elimino el libro con id 3: ");

	
	
	
	
	}
	

}
