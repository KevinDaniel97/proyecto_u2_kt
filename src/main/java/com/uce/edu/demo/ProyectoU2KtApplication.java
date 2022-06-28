package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2KtApplication.class);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
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
		
		
	}

}
