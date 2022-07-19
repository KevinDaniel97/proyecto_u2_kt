package com.uce.edu.demo.estudiante.service;

import java.util.List;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteContadorEdad;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;

public interface IEstudianteJpaService {


	public void guardar(Estudiante e);
	public Estudiante buscarPorId(int id);
	public void actualizar(Estudiante e);
	public void eliminar(int id);
	public  Estudiante busacarPorCedulaTyped(String cedula);
	public  Estudiante busacarPorEdadTyped(Integer edad);
	public  Estudiante busacarPorCedulaNamed(String cedula);
	public  Estudiante busacarPorEdadNamed(Integer edad);
	public Estudiante busacarPorCedulaTypedNamed(String cedula); 
	public Estudiante busacarPorEdadTypedNamed(Integer edad); 
	public List<Estudiante> buscarPorNombre(String nombre);
	
	public Estudiante buscarPorCedulaNative(String cedula);
	public List<Estudiante> buscarPorEdadNative(Integer edad);
	public Estudiante buscarPorCedulaNamedNative(String cedula);
	public List<Estudiante> buscarPorNombreNamedNative(String nombre);

	public List<Estudiante> buscarPorEdadCriterialApi(Integer edad);
	public List<Estudiante> buscarDinamicamente(String nombre, String apellido,Integer edad);

	public List<EstudianteSencillo> buscarPorEdadSencillo(Integer edad);
	public List<EstudianteContadorEdad> consultarCantidadPorEdad();
}
