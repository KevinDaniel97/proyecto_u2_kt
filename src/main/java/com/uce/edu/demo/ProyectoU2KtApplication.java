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


		Estudiante estu1=new Estudiante(); 
		  estu1.setApellido("Velez");
		  estu1.setNombre("Dario"); 
		  estu1.setCedula("100008"); 
		  estu1.setEdad(24); 
		 // this.iEstudianteJpaService.guardar(estu1);
		  
		 
		  Estudiante estNative=this.iEstudianteJpaService.buscarPorCedulaNative("100003");
		  log.info("Estudiantes Native: "+estNative);
		  
		  List<Estudiante>estNative2=this.iEstudianteJpaService.buscarPorEdadNative(21); 
			for(Estudiante item:estNative2){
				 log.info("Estudiantes Native 2: \n"+item); 
			}
			
		  Estudiante estNamedNative=this.iEstudianteJpaService.buscarPorCedulaNamedNative("100003");
		  log.info("Estudiantes NamedNative: "+estNamedNative);
		  
		  List<Estudiante>estNamedNative2=this.iEstudianteJpaService.buscarPorNombreNamedNative("Kevin"); 
			for(Estudiante item:estNamedNative2){
				 log.info("Estudiantes NamedNative 2: \n"+item); 
			}

		  
	}

}
