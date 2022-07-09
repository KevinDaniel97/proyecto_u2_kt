package com.uce.edu.demo;

import java.util.List;

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
	
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Actualizar con JPQL
		int resultado=this.iPersonaJpaService.actualizarPorApellido("FM", "apellido");
		log.info("cantidad de registros actualizados: "+resultado);
		
		
		//Eliminar con JPQL
		int resultado2=this.iPersonaJpaService.eliminarPorGenero("M");
		log.info("Cantidad de registros eliminados  "+ resultado2);
		
	
	//buscar
		//log.info("Dato conJPA: "+ this.iPersonaJpaService.buscarPorCedula("100"));
	
	//Guardar
		Persona persona =new Persona();
		persona.setNombre("juenito5");
		persona.setApellido("teran5");
		persona.setGenero("M");
		persona.setCedula("10005");
		//this.iPersonaJpaService.insertar(persona);
		
		Persona persona2 =new Persona();
		persona2.setNombre("juenito6");
		persona2.setApellido("teran6");
		persona2.setGenero("F");
		persona2.setCedula("10006");
		//this.iPersonaJpaService.insertar(persona2);
		
	//actualizar
		Persona persona1 =new Persona();
		persona1.setId(4);
		persona1.setNombre("andreA");
		persona1.setApellido("ToapantaA");	
		//this.iPersonaJpaService.actualizar(persona1);
		
	//Eliminar
		//this.iPersonaJpaService.eliminar(11);
	
		
	//Buscar por cedula
		//Persona p=this.iPersonaJpaService.buscarPorCedula("100");
		//log.info("persona encontrada: "+p);
		
	
		
		
	// Buscar por  Apellido
//		List<Persona> listaPersona= this.iPersonaJpaService.buscarPorApellido("apellido");
//		for(Persona item : listaPersona) {
//			log.info("persona: " +item);
//		}
//	

	
	}

}
