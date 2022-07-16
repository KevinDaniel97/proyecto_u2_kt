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
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


		Persona per1=new Persona(); 
		  per1.setApellido("Velez");
		  per1.setNombre("daniel"); 
		  per1.setCedula("34353535"); 
		  per1.setGenero("M");
		  //this.iPersonaJpaService.insertar(per1);


//		  Persona perNative=this.iPersonaJpaService.buscarPorCedulaNative("120001");
//		  log.info("Persona Native: "+perNative);
//
//		  Persona perNamedNative=this.iPersonaJpaService.buscarPorCedulaNamedNative("120001");
//		  log.info("Persona NamedNative: "+perNamedNative);
		  
		  Persona perCriteria=this.iPersonaJpaService.buscarPorCedulaCriteriaApi("120001");
		  log.info("Persona Criteria API: "+perCriteria);
		  
		  Persona perDinamica =this.iPersonaJpaService.buscarDinamicamente("Dario","Cayambe","M");
		  log.info("Persona Dinamica: "+perDinamica);

		 
		  
	}

}
