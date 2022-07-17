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

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner {
	private static Logger log = Logger.getLogger(ProyectoU2KtApplication.class);

	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Estudiante estu1 = new Estudiante();
		estu1.setApellido("Velez");
		estu1.setNombre("Andy");
		estu1.setCedula("100010");
		estu1.setEdad(24);
		// this.iEstudianteJpaService.guardar(estu1);

		List<Estudiante> estCriteria = this.iEstudianteJpaService.buscarPorEdadCriterialApi(24);
		for (Estudiante item : estCriteria) {
			log.info("Estudiantes Criteria API consulta 1: " + item);
		}
		//si edad <=24 busca nombre o apellido y edad 
		List<Estudiante> estCriteria2 = this.iEstudianteJpaService.buscarDinamicamente("Kevin", "Velez", 21);
		for (Estudiante item : estCriteria2) {
			log.info("Estudiantes Criteria API consulta 2: " + item);
		}
		

	}

}
