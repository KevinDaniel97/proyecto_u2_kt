package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.ICiudadanoRepository;
import com.uce.edu.demo.respository.modelo.Ciudadano;
import com.uce.edu.demo.respository.modelo.Empleado;
import com.uce.edu.demo.respository.modelo.Pasaporte;
import com.uce.edu.demo.respository.modelo.Persona;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner {
	private static Logger log = Logger.getLogger(ProyectoU2KtApplication.class);

	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		Ciudadano ciu1=new Ciudadano(); 
		ciu1.setNombre("Mario"); 
		ciu1.setApellido("Bross");
		ciu1.setCedula("105");
		ciu1.setFechaNacimiento(LocalDateTime.of(2002,12,10,0,0));
		
		Pasaporte pasa1 =new Pasaporte();
		pasa1.setNumero("1001");
		pasa1.setFechaEmision(LocalDateTime.of(2021, 10,10,0,0));
		pasa1.setFechaCaducidad(LocalDateTime.of(2022, 10,10,0,0));
		ciu1.setPasaporte(pasa1);
		
		//guardar
		this.iCiudadanoService.insertar(ciu1);
		log.info("Guarda ciudadano: "+ciu1);
		
		
		Ciudadano ciu2=new Ciudadano(); 
		ciu2.setNombre("Kevin2"); 
		ciu2.setApellido("Toapanta2");
		ciu2.setCedula("1010");
		ciu2.setFechaNacimiento(LocalDateTime.of(2002,12,10,0,0));
		
		//actualizar
		this.iCiudadanoService.actualizar(ciu2);
		log.info("actualizo ciudadano  : "+ciu2);

		//buscar
		log.info("Busca ciudadano por Id: "+this.iCiudadanoService.buscarPorId(7));
		
		//eliminar
		this.iCiudadanoService.eliminar(3);
		log.info("se elimino ciudadano de id: 3");

	
	}
	

}
