package com.uce.edu.demo;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba.service.IPropietarioService;
import com.uce.edu.demo.prueba.service.IVehiculoService;



@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner {
	private static Logger log = Logger.getLogger(ProyectoU2KtApplication.class);

	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private IPropietarioService iPropietarioService;

	@Autowired
	private IMatriculaGestorService gestorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {

		//1
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Chebrolet");
		vehiculo.setPlaca("PRT393");
		vehiculo.setPrecio(new BigDecimal(20000));
		vehiculo.setTipo("L");
		this.vehiculoService.insertar(vehiculo);
		log.info("se inserto el vehiculo"+vehiculo);
		//2
		vehiculo.setPrecio(new BigDecimal(40000));
		vehiculo.setMarca("Chevrolet");
		this.vehiculoService.actualizarPorApellido("L", "PLS14");
		log.info("actualiza: "+vehiculo);
		//3
		Propietario pro = new Propietario();
		pro.setApellido("Toapnata");
		pro.setNombre("Kevin");
		pro.setCedula("1725845869");
		pro.setFechaNacimiento(LocalDateTime.now());
		this.iPropietarioService.crear(pro);
		log.info("Se crea propietario: "+pro);
		//4
		this.gestorService.generar("1725845869", "PRT393");
		log.info("segenera la matricula con cedula 1725845869 y placa PRT393 ");
		
	}
	

}
