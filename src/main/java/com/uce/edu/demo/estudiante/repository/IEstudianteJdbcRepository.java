package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import com.uce.edu.demo.estudiante.to.EstudianteTo;
import com.uce.edu.demo.to.PersonaTo;


public interface IEstudianteJdbcRepository {
	
	
	
	//CRUD
	//C: crear/insertar
	public void insertar(EstudianteTo e);
	
	//R: leer/buscar
	public EstudianteTo buscarPorId(int id);
	
	//U: actualizar
	public void actualizar(EstudianteTo e);
		
	//D: eliminar
	public void eliminar(int id);
	
	
}
