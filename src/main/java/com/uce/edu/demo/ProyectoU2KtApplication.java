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
import com.uce.edu.demo.respository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.respository.modelo.PersonaSencilla;
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
		per1.setApellido("Chavez");
		per1.setNombre("Dayana"); 
		per1.setCedula("100011"); 
		per1.setGenero("F");
		//this.iPersonaJpaService.insertar(per1);


		List<PersonaSencilla> listaPersona =this.iPersonaJpaService.buscarPorApellidoSencillo("Ayala");
		for(PersonaSencilla perItem : listaPersona) {
			log.info("List Persona Sencilla: "+listaPersona);
		}

		List<PersonaContadorGenero> milistaContadorGenero =this.iPersonaJpaService.consultarCantidadPorGenero();
			log.info("List Persona Contador Genero: "+milistaContadorGenero);
		
	}

}
