package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {

	//CRUD
	//C: crear/insertar
	public void insertar(Estudiante e);
	
	//R: leer/buscar
	public Estudiante buscarPorId(Integer id);
	
	//U: actualizar
	public void actualizar(Estudiante e);
		
	//D: eliminar
	public void eliminar(Integer id);
}
