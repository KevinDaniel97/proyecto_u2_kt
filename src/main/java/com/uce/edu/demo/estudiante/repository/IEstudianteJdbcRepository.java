package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.to.Estudiante;

public interface IEstudianteJdbcRepository {
	
	
	
	//CRUD
	//C: crear/insertar
	public void insertar(Estudiante e);
	
	//R: leer/buscar
	public Estudiante buscarPorId(int id);
	
	//U: actualizar
	public void actualizar(Estudiante e);
		
	//D: eliminar
	public void eliminar(int id);
}
