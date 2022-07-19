package com.uce.edu.demo.estudiante.repository.modelo;

import java.io.Serializable;

public class EstudianteContadorEdad implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer edad;
	private Long numero;
	private String nombre;

	
	@Override
	public String toString() {
		return "EstudianteContadorEdad [nombre=" + nombre + ", edad=" + edad + ", numero=" + numero + "]\n";
	}
	public EstudianteContadorEdad( Integer edad, String nombre, Long numero) {
		super();
		this.nombre=nombre;
		this.edad = edad;
		this.numero = numero;
	}
	public EstudianteContadorEdad() {
		
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
