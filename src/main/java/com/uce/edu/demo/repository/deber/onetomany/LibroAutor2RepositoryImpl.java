package com.uce.edu.demo.repository.deber.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.respository.modelo.deber.onetomany.LibroAutor2;
@Repository
@Transactional
public class LibroAutor2RepositoryImpl implements ILibroAutor2Repository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(LibroAutor2 libroAutor2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libroAutor2);
	}

}
