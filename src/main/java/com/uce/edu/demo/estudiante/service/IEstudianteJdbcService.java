package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.to.Estudiante;

public interface IEstudianteJdbcService {


	public void guardar(Estudiante e);
	public Estudiante buscar(int id);
	public void actualizar(Estudiante e);
	public void eliminar(int id);
}
