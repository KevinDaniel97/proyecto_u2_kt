package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJdbcService;
import com.uce.edu.demo.estudiante.to.Estudiante;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner{
	
	private static Logger log =Logger.getLogger(ProyectoU2KtApplication.class);
	
	//@Autowired
	//private IPersonaJdbcService iPersonaJdbcService;
	
	@Autowired
	private IEstudianteJdbcService estudianteJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Estudiante estudiante =new Estudiante();
		estudiante.setId(2);
		estudiante.setNombre("pepito");
		estudiante.setApellido("Perez");
		estudiante.setCedula("1725845869");
		estudiante.setEdad(20);
		
		//insertar
		this.estudianteJdbcService.guardar(estudiante);
		log.info("Se ha guardado el estudiante: "+estudiante);
	
		Estudiante estu1=new Estudiante();
		estu1.setId(2);
		estu1.setNombre("Kevin");
		estu1.setEdad(21);
		
		//actualizar
		this.estudianteJdbcService.actualizar(estu1);
		log.info("Se ha actualizado un estudiante: "+estu1);
		
		//eliminar
		this.estudianteJdbcService.eliminar(1);
		log.info("Se ha eliminado un estudiante: "+estu1);

		//buscar
		log.info(this.estudianteJdbcService.buscar(2));
		
		
		
	/*	
		Persona persona =new Persona();
		persona.setId(3);
		persona.setNombre("pepito");
		persona.setApellido("Perez");
		
		//insertar
		//this.iPersonaJdbcService.guardar(persona);
		
		
		Persona per1=new Persona();
		per1.setId(3);
		per1.setApellido("Toapanta");
		//actualizar
		//this.iPersonaJdbcService.actualizar(per1);
		
		//eliminar
		//this.iPersonaJdbcService.eliminar(3);
		
		//buscar
		this.iPersonaJdbcService.buscar(3);
		LOG.info(this.iPersonaJdbcService.buscar(3));
	*/
	}

}
