package com.uce.edu.demo.estudiante.repository.modelo;

import java.io.Serializable;

public class EstudianteSencillo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apellido;
	private Integer Edad;
	
	
	
	
	@Override
	public String toString() {
		return "EstudianteSencillo [apellido=" + apellido + ", Edad=" + Edad + "]";
	}
	
	public EstudianteSencillo(String apellido, Integer edad) {
		super();
		this.apellido = apellido;
		Edad = edad;
	}
	public EstudianteSencillo() {
	
	}
	
	//set y get
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return Edad;
	}
	public void setEdad(Integer edad) {
		Edad = edad;
	}
	
}
