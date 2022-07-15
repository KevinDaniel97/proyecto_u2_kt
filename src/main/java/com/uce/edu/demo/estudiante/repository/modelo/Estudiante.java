package com.uce.edu.demo.estudiante.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.uce.edu.demo.respository.modelo.Persona;

@Entity
@Table(name="estudiante")
@NamedQuery(name= "Estudiante.buscarPorCedula",query="SELECT p FROM Estudiante p WHERE p.cedula= :datoCedula ")
@NamedQuery(name= "Estudiante.buscarPorEdad",query="SELECT p FROM Estudiante p WHERE p.edad= :datoEdad ")
@NamedQuery(name= "Estudiante.buscarPorNombre",query="SELECT p FROM Estudiante p WHERE p.nombre= :datoNombre ORDER BY p ASC")


@NamedNativeQuery(name="Estudiante.buscarPorCedulaNative",query="SELECT * FROM estudiante WHERE estu_cedula=:datoCedula",resultClass =Estudiante.class)
@NamedNativeQuery(name="Estudiante.buscarPorNombreNative",query="SELECT * FROM estudiante WHERE estu_nombre=:datoNombre",resultClass =Estudiante.class)
public class Estudiante {
	@Id
	@Column(name="Estu_id_sec")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Estu_id_sec")
	@SequenceGenerator(name = "Estu_id_sec", sequenceName = "Estu_id_sec", allocationSize = 1)
	private int id;
	@Column(name="estu_nombre")
	private String nombre;
	@Column(name="estu_apellido")
	private String apellido;
	@Column(name="estu_cedula")
	private String cedula;
	@Column(name="estu_edad")
	private int edad;

	
	public Estudiante() {
	
	}
	
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", edad=" + edad + "]";
	}
	
	//set y get
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
