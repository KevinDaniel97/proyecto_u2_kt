package com.uce.edu.demo.respository.modelo;

import java.io.Serializable;

public class PersonaContadorGenero implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String genero;
	private Long numero;
	
	
	
	@Override
	public String toString() {
		return "PersonaContadorGenero [genero=" + genero + ", numero=" + numero + "]";
	}
	
	public PersonaContadorGenero(String genero, Long numero) {
		super();
		this.genero = genero;
		this.numero = numero;
	}
	public PersonaContadorGenero() {
	
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	
	

}
