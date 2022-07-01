package com.uce.edu.demo.estudiante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.estudiante.to.EstudianteTo;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService{

	@Autowired
	private IEstudianteJdbcRepository estudianteRepository;

	@Override
	public void guardar(EstudianteTo e) {
		this.estudianteRepository.insertar(e);
	}

	@Override
	public EstudianteTo buscar(int id) {
		return this.estudianteRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(EstudianteTo e) {
		this.estudianteRepository.actualizar(e);
	}

	@Override
	public void eliminar(int id) {
		this.estudianteRepository.eliminar(id);		
	}



}
