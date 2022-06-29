package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJdbcService;
import com.uce.edu.demo.estudiante.to.Estudiante;
import com.uce.edu.demo.respository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.to.PersonaTo;

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner{
	
	private static Logger log =Logger.getLogger(ProyectoU2KtApplication.class);
	
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("Dato conJPA: "+ this.iPersonaJpaService.buscarPorId(1));
	
		/*PersonaTo per1=new PersonaTo();
		per1.setId(3);
		per1.setApellido("Toapanta");
		*/
		Persona persona =new Persona();
		persona.setId(10);
		persona.setNombre("pepito");
		persona.setApellido("Toapanta");
		
		//Guardar
		this.iPersonaJpaService.insertar(persona);
		
		Persona persona1 =new Persona();
		persona1.setId(1);
		persona1.setNombre("pepito");
		persona1.setApellido("Toapanta");	
		//Guardar
		this.iPersonaJpaService.actualizar(persona1);
		//Eliminar
		this.iPersonaJpaService.eliminar(3);
		
		
		
		
		
		//insertar
		//this.iPersonaJdbcService.guardar(persona);
		
		
		//actualizar
		//this.iPersonaJdbcService.actualizar(per1);
		
		//eliminar
		//this.iPersonaJdbcService.eliminar(3);
		
		//buscar
		//this.iPersonaJdbcService.buscar(3);
		//log.info(this.iPersonaJdbcService.buscar(3));
		
		//buscar Todos
		//log.info("lista:"+this.iPersonaJdbcService.buscarTodos());
	
	}

}
