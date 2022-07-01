package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJdbcService;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.respository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner{
	
	private static Logger log =Logger.getLogger(ProyectoU2KtApplication.class);
	
	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;

	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Buscar
		log.info("Dato conJPA: "+ this.iEstudianteJpaService.buscarPorId(2));

		Estudiante estudiante =new Estudiante();
		estudiante.setId(15);
		estudiante.setNombre("pepito");
		estudiante.setApellido("Perez");
		estudiante.setCedula("1725845869");
		estudiante.setEdad(25);
		//Guardar
		this.iEstudianteJpaService.guardar(estudiante);
		
			
		Estudiante estudiante1 =new Estudiante();
		estudiante1.setId(6);
		estudiante1.setNombre("pepito");
		estudiante.setApellido("Toapanta");
		estudiante1.setCedula("1725848569");	
		//actualizar
		this.iEstudianteJpaService.actualizar(estudiante1);
		
		
		//Eliminar
		this.iEstudianteJpaService.eliminar(11);
		

	
	}

}
