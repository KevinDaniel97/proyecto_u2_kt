package com.uce.edu.demo.estudiante.repository;


import java.util.List;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {

	public void insertar(Estudiante e);
	
	public Estudiante buscarPorId(Integer id);
	
	public void actualizar(Estudiante e);
		
	public void eliminar(Integer id);
	
	public  Estudiante busacarPorCedulaTyped(String cedula);
	public  Estudiante busacarPorEdadTyped(Integer edad);

	public  Estudiante busacarPorCedulaNamed(String cedula);
	public  Estudiante busacarPorEdadNamed(Integer edad);

	public Estudiante busacarPorCedulaTypedNamed(String cedula); 
	public Estudiante busacarPorEdadTypedNamed(Integer edad); 

	public List<Estudiante> buscarPorNombre(String nombre);

}
