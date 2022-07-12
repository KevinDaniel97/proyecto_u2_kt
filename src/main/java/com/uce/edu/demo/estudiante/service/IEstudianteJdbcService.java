package com.uce.edu.demo.estudiante.service;

import java.util.List;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.to.EstudianteTo;

public interface IEstudianteJdbcService {


	public void guardar(EstudianteTo e);
	public EstudianteTo buscar(int id);
	public void actualizar(EstudianteTo e);
	public void eliminar(int id);

}
