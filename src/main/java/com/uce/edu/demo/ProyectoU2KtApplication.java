package com.uce.edu.demo;


import org.apache.log4j.LogManager;
import org.jboss.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoU2KtApplication implements CommandLineRunner{
	
	
	private static Logger logJava =Logger.getLogger(ProyectoU2KtApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KtApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logJava.debug("LOG DEBUG ");
		logJava.info("LOG INFO ");
		logJava.warn("LOG WARN ");
		logJava.error("LOG ERROR ");
		logJava.fatal("LOG FATAL ");
		
	}

}
