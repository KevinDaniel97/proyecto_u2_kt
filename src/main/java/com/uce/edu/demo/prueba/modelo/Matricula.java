package com.uce.edu.demo.prueba.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "matricula")
public class Matricula {

	@Id
	@Column(name= "matr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "matr_id_sec")
	@SequenceGenerator(name="matr_id_sec",sequenceName = "matr_id_sec",allocationSize = 1)
	private Integer id;
	//@Column(name= "matr_propietario")
	//private Propietario propietario;
	//@Column(name= "matr_vehiculo")
	//private Vehiculo vehiculo;
	@Column(name= "matr_fechaMatricula")
	private LocalDateTime fechaMatricula;
	@Column(name= "matr_valorMatricula")
	private BigDecimal valorMatricula;


	

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", propietario="  + ", vehiculo="  + ", fechaMatricula="
				+ fechaMatricula + ", valorMatricula=" + valorMatricula + "]";
	}

	// SET y GET
	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}

	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}
/*
	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
