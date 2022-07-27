package com.uce.edu.demo.cajero.respository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.modelo.Factura;
@Repository
@Transactional
public class FacturaRespositoryImpl implements IFacturaRespository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Factura consultar(Integer id) {
		// TODO Auto-generated method stub
		 return this.entityManager.find(Factura.class, id);
	}

}
