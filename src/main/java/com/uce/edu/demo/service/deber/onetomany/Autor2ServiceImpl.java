package com.uce.edu.demo.service.deber.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.deber.onetomany.IAutor2Repository;
import com.uce.edu.demo.respository.modelo.deber.onetomany.Autor2;
@Service
public class Autor2ServiceImpl implements IAutor2Service {

	@Autowired
	private IAutor2Repository iAutor2Repository;

	@Override
	public void insertar(Autor2 autor2) {
		// TODO Auto-generated method stub
		this.iAutor2Repository.insertar(autor2);
	}

	
}
