package com.uce.edu.demo;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;
import com.uce.edu.demo.respository.modelo.deber.onetomany.Autor2;
import com.uce.edu.demo.respository.modelo.deber.onetomany.Libro2;
import com.uce.edu.demo.respository.modelo.deber.onetomany.LibroAutor2;
import com.uce.edu.demo.service.deber.onetomany.IAutor2Service;
import com.uce.edu.demo.service.deber.onetomany.ILibro2Service;
import com.uce.edu.demo.service.deber.onetomany.ILibroAutor2Service;



@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner {
	private static Logger log = Logger.getLogger(ProyectoU2KtApplication.class);

	@Autowired
	private IFacturaService iFacturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Factura fact=this.iFacturaService.consultar(1);
	
		log.info("Numero: "+fact.getNumero());
		log.info("decha: "+fact.getFecha());
		log.info("cliente: "+fact.getCliente().getNumeroTarjeta());
	
		List<DetalleFactura> detalles = fact.getDetalles();
		for(DetalleFactura deta:detalles) {
			log.info("detalle: "+deta);
		}
	
	}
	

}
