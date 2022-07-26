package com.uce.edu.demo.service.deber.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.deber.onetomany.ILibroAutor2Repository;
import com.uce.edu.demo.respository.modelo.deber.onetomany.LibroAutor2;
@Service
public class LibroAutor2ServiceImpl implements ILibroAutor2Service {

	@Autowired
	private ILibroAutor2Repository iLibroAutor2Repository;
	
	@Override
	public void insertar(LibroAutor2 libroAutor2) {
		// TODO Auto-generated method stub
		this.iLibroAutor2Repository.insertar(libroAutor2);
	}

}
