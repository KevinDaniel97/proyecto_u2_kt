package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteContadorEdad;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.respository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.respository.modelo.PersonaSencilla;

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner {
	private static Logger log = Logger.getLogger(ProyectoU2KtApplication.class);

	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Estudiante estu1 = new Estudiante();
		estu1.setApellido("Teran");
		estu1.setNombre("Juan");
		estu1.setCedula("100013");
		estu1.setEdad(26);
		//this.iEstudianteJpaService.guardar(estu1);


	List<EstudianteSencillo> estSencillo = this.iEstudianteJpaService.buscarPorEdadSencillo(21);
	for (EstudianteSencillo item : estSencillo) {
		log.info("Estudiantes Sencillo: " + estSencillo);
	}
	List<EstudianteContadorEdad> estContador = this.iEstudianteJpaService.consultarCantidadPorEdad();
		log.info("Estudiante cantidad Edad:\n" +estContador );
	
	
	
	
	}
	

}
