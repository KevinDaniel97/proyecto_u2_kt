package com.uce.edu.demo.cajero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.cajero.modelo.Factura;
import com.uce.edu.demo.cajero.respository.IFacturaRespository;
@Service
public class FacturaServiceImpl implements IFacturaService {

	
	@Autowired
	private IFacturaRespository iFacturaRespository;
	
	@Override
	public Factura consultar(Integer id) { 
		
		 return this.iFacturaRespository.consultar(id);
	}

}
