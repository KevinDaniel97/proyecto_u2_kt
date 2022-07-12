package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.respository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

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
		estu1.setApellido("Toapanta");
		estu1.setNombre("Kevin");
		estu1.setCedula("100003");
		estu1.setEdad(21);
		//this.iEstudianteJpaService.guardar(estu1);

		// 1.1  TypedQuery
		Estudiante estTyped = this.iEstudianteJpaService.busacarPorCedulaTyped("100001");
		log.info("------Estudiante Typed: " + estTyped);
		
		// 1.2 TypedQuery
		Estudiante estTyped2 = this.iEstudianteJpaService.busacarPorEdadTyped(21);
		log.info("------Estudiante Typed: " + estTyped2);
		
		// 2.1 NamedQuery
		Estudiante estNamed = this.iEstudianteJpaService.busacarPorCedulaTyped("100001");
		log.info("------Estudiante Named: " + estNamed);

		// 2.1 NamedQuery
		Estudiante estNamed2 = this.iEstudianteJpaService.busacarPorEdadNamed(21);
		log.info("------Estudiante Named: " + estNamed2);
		
		// 3.1 TypedNamed
		Estudiante estTypedNamed2 = this.iEstudianteJpaService.busacarPorEdadTypedNamed(21);
		log.info("------Estudiante TypedNamed: " + estTypedNamed2);
				
		// 3.2 TypedNamed
		List<Estudiante>listaEstudiante=this.iEstudianteJpaService.buscarPorNombre("Kevin"); 
		for(Estudiante item:listaEstudiante){
			 log.info("Estudiantes TypedNamed Lista: \n"+item); 
		}

	

	}

}
