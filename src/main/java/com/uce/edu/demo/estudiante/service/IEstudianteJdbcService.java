package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.to.EstudianteTo;

public interface IEstudianteJdbcService {


	public void guardar(EstudianteTo e);
	public EstudianteTo buscar(int id);
	public void actualizar(EstudianteTo e);
	public void eliminar(int id);
}
