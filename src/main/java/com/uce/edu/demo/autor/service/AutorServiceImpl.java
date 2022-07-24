package com.uce.edu.demo.autor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.autor.modelo.Autor;
import com.uce.edu.demo.autor.repository.IAutorRepository;

@Service
public class AutorServiceImpl implements IAutorService{

	@Autowired
	private IAutorRepository iAutorRepository;
	
	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.iAutorRepository.insertar(autor);
	}

	@Override
	public Autor buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iAutorRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.iAutorRepository.actualizar(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
		this.iAutorRepository.eliminar(id);
	}

}
