package com.uce.edu.demo.autor.modelo;

import java.time.LocalDateTime;
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
@Table(name ="autor")
public class Autor {

	@Id
	@Column(name="autor_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_id_sec")
	@SequenceGenerator(name = "autor_id_sec", sequenceName = "autor_id_sec", allocationSize = 1)
	private  Integer id;
	
	@Column(name="autor_nombre")
	private String nombre;
	
	@Column(name="autor_apellido")
	private String apellido;
	
	@Column(name="autor_pais")
	private String pais;
	
	@Column(name="autor_fechaNacimiento")
	private LocalDateTime fechaNacimiento;
	
	@OneToMany(mappedBy="autor")
	private  List<Libro> libros;
	
	
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", pais=" + pais
				+ ", fechaNacimiento=" + fechaNacimiento +  "]";
	}

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
	
	
}
