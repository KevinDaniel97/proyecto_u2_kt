package com.uce.edu.demo.prueba.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@Column(name= "matr_fecha_matricula")
	private LocalDateTime fechaMatricula;
	
	@Column(name= "matr_valor_matricula")
	private BigDecimal valorMatricula;
	
	@ManyToOne
	@JoinColumn(name="matr_prop_id")
	private Propietario propietario;
	
	@OneToOne
	@JoinColumn(name="vehi_prop_id")
	private Vehiculo vehiculo;
	
	

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaMatricula=" + fechaMatricula + ", valorMatricula=" + valorMatricula
				+ "]";
	}

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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


	

}
