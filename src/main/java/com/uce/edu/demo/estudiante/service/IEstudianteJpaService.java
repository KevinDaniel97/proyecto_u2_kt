package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

public interface IEstudianteJpaService {


	public void guardar(Estudiante e);
	public Estudiante buscarPorId(int id);
	public void actualizar(Estudiante e);
	public void eliminar(int id);
}
