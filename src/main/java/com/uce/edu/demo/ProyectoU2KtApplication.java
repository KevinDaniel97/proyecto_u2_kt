package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.respository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.respository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner {
	private static Logger log = Logger.getLogger(ProyectoU2KtApplication.class);

	@Autowired
	private IHotelService iHotelService;

	@Autowired
	private IHabitacionService iHabitacionService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
	Hotel hotel1= new Hotel();
	hotel1.setNombre("Hiltton Colon");
	hotel1.setDireccion("Patria");
	//this.iHotelService.insetar(hotel1);
		
	//Buscar numero 
	Hotel hote= new Hotel();
	hote.setId(1);
	
	Habitacion habi1=new Habitacion();
	habi1.setNumero("A235");
	habi1.setPiso("15");
	habi1.setTipo("Familia");
	habi1.setHotel(hote);

	Habitacion habi2=new Habitacion();
	habi2.setNumero("1224021");
	habi2.setPiso("4");
	habi2.setTipo("Matrimonial");
	habi2.setHotel(hote);
	
	this.iHabitacionService.insertar(habi1);
	this.iHabitacionService.insertar(habi2);

	
	
	
	
	}
	

}
