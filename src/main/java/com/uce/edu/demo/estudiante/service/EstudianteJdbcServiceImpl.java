package com.uce.edu.demo.estudiante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.estudiante.to.Estudiante;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService{

	@Autowired
	private IEstudianteJdbcRepository estudianteRepository;

	@Override
	public void guardar(Estudiante e) {
		this.estudianteRepository.insertar(e);
	}

	@Override
	public Estudiante buscar(int id) {
		return this.estudianteRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.estudianteRepository.actualizar(e);
	}

	@Override
	public void eliminar(int id) {
		this.estudianteRepository.eliminar(id);		
	}



}
