package com.uce.edu.demo.estudiante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService{

	@Autowired
	private IEstudianteJpaRepository iEstudianteJpaRepository;
	
	@Override
	public void guardar(Estudiante e) {
		this.iEstudianteJpaRepository.insertar(e);
	}

	@Override
	public Estudiante buscarPorId(int id) {
		
		return this.iEstudianteJpaRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.iEstudianteJpaRepository.actualizar(e);
		
	}

	@Override
	public void eliminar(int id) {
		this.iEstudianteJpaRepository.eliminar(id);
		
	}

}
