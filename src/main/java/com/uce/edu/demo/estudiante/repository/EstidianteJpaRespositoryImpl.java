package com.uce.edu.demo.estudiante.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
@Repository
@Transactional
public class EstidianteJpaRespositoryImpl implements IEstudianteJpaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante e) {
		 this.entityManager.persist(e);		
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.entityManager.find(Estudiante.class,id);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.entityManager.merge(e);		
	}

	@Override
	public void eliminar(Integer id) {
		Estudiante estudiante=this.buscarPorId(id);
		this.entityManager.remove(estudiante);
	}


}
