package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.respository.modelo.Persona;
import com.uce.edu.demo.respository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.respository.modelo.PersonaSencilla;

public interface IPersonaJpaService {

	public Persona buscarPorId(Integer id);
	public void insertar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar(Integer id);
	public Persona buscarPorCedula(String cedula);
	public List<Persona> buscarPorApellido(String apellido);
	public List<Persona> buscarPorNombre(String nombre);
	public List<Persona> buscarPorGenero(String genero);
	public  Persona busacarPorCedulaTyped(String cedula);
	public  Persona busacarPorCedulaNamed(String cedula);
	public  Persona busacarPorCedulaTypedNamed(String cedula); 
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);
	public int actualizarPorApellido(String genero,String apellido);
	public int eliminarPorGenero(String genero); 
	
	public Persona buscarPorCedulaNative(String cedula);
	public Persona buscarPorCedulaNamedNative(String cedula);
	public Persona buscarPorCedulaCriteriaApi(String cedula);
	
	public Persona buscarDinamicamente(String nombre, String apellido,String genero);
	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido);
	public List<PersonaContadorGenero> consultarCantidadPorGenero();



	
}
