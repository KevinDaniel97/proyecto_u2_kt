package com.uce.edu.demo.autor.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.autor.modelo.Libro;
@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	
	}

	@Override
	public Libro buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(buscarPorId(id));
	}

}
