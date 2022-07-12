package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.respository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner{
	private static Logger log =Logger.getLogger(ProyectoU2KtApplication.class);
	
	
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
		this.iPersonaJpaService.insertar(per1);
		
		//1 TypedQuery
		Persona perTyped =this.iPersonaJpaService.busacarPorCedulaTyped("12141212124");
		log.info("Persona Typed: "+perTyped);
		
		//2 NamedQuery
		Persona perNamed =this.iPersonaJpaService.busacarPorCedulaTyped("12141212124");
		log.info("Persona Named: "+perNamed);


		//3 TypedNamed
		Persona perTypedNamed =this.iPersonaJpaService.busacarPorCedulaTyped("12141212124");
		log.info("Persona TypedNamed: "+perTypedNamed);
		
		//4 Varios NamedQuery
		List<Persona> listaPersona=this.iPersonaJpaService.buscarPorNombreApellido("daniel", "Velez");
		for(Persona item:listaPersona) {
			log.info("Persona: "+item);
		}
		

	}

}
