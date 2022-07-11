package com.uce.edu.demo.prueba.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="propietario")
public class Propietario {
	
	@Id
	@Column(name="prop_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "prop_id_sec")
	@SequenceGenerator(name="prop_id_sec",sequenceName = "prop_id_sec",allocationSize = 1)
	private Integer id;
	
	@Column(name="prop_nombre")
	private String nombre;
	@Column(name="prop_apellido")
	private String apellido;
	@Column(name="prop_cedula")
	private String cedula;
	@Column(name="prop_fechaNacimiento")
	private LocalDateTime fechaNacimiento;


	@Override
	public String toString() {
		return "Propietario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	// SET y GET
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
