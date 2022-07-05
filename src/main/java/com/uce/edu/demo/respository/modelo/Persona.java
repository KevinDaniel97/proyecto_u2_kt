package com.uce.edu.demo.respository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "persona")
public class Persona {

	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "name_generator")//no neseariamente el mismo nombre (name_generator)
	@SequenceGenerator(name="name_generator",sequenceName = "pers_id_sec",allocationSize = 1)
	private Integer id;
	@Column(name= "nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	
	
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	//SET y GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
