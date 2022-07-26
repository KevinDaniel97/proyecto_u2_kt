package com.uce.edu.demo.respository.modelo.deber.onetomany;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name ="autor2")
public class Autor2 {

	@Id
	@Column(name="auto2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto2_id_sec")
	@SequenceGenerator(name = "auto2_id_sec", sequenceName = "auto2_id_sec", allocationSize = 1)
	private  Integer id;
	
	@Column(name="auto2_nombre")
	private String nombre;
	
	@OneToMany(mappedBy="autor2")
	private  List<LibroAutor2> librosAutor2;
	
	
	//set y get
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

	public List<LibroAutor2> getLibrosAutor2() {
		return librosAutor2;
	}

	public void setLibrosAutor2(List<LibroAutor2> librosAutor2) {
		this.librosAutor2 = librosAutor2;
	}
	
	

	
	
	
	
}
