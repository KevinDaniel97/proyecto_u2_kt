package com.uce.edu.demo.respository.modelo.deber.onetomany;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="libro2")
public class Libro2 {

	@Id
	@Column(name="libr2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libr2_id_sec")
	@SequenceGenerator(name = "libr2_id_sec", sequenceName = "libr2_id_sec", allocationSize = 1)
	private Integer id;
	
	@Column(name = "libr2_titulo")
	private String titulo;
	
	@Column(name = "libr2_cantidad_paginas")
	private Integer cantidadPaginas;
	
	@OneToMany(mappedBy="libro2")
	private Set<LibroAutor2> libroAutor2;
	
	//set y get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public Set<LibroAutor2> getLibroAutor2() {
		return libroAutor2;
	}

	public void setLibroAutor2(Set<LibroAutor2> libroAutor2) {
		this.libroAutor2 = libroAutor2;
	}
	
	
	
	
	
	
}
