package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.respository.modelo.Persona;

public interface IPersonaJpaService {

	public Persona buscarPorId(Integer id);
	public void insertar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar(Integer id);
	public Persona buscarPorCedula(String cedula);

	public List<Persona> buscarPorApellido(String apellido);

}
