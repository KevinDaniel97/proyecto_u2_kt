package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.ICiudadanoRepository;
import com.uce.edu.demo.respository.modelo.Ciudadano;
import com.uce.edu.demo.respository.modelo.Empleado;
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
		ciu1.setNombre("Kevin"); 
		ciu1.setApellido("Toapanta");
		
		Empleado empl1 =new Empleado();
		empl1.setCodigoIess("100001");
		empl1.setSalario(new BigDecimal(1200));
		empl1.setCiudadano(ciu1);
	
		ciu1.setEmpleado(empl1);
		
		this.iCiudadanoService.insertar(ciu1);

		Ciudadano ciu2=new Ciudadano(); 
		ciu2.setNombre("Dario2"); 
		ciu2.setApellido("Toapanta2");
		
		Empleado empl2 =new Empleado();
		empl2.setCodigoIess("1231542");
		empl2.setSalario(new BigDecimal(100));
		empl2.setCiudadano(ciu2);
		
		ciu2.setEmpleado(empl2);
		//this.iCiudadanoService.insertar(ciu2);

	
	}
	

}
