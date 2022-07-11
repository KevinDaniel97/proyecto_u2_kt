package com.uce.edu.demo.prueba.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.respository.modelo.Persona;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {
	
	@PersistenceContext
	private EntityManager entityManager; 

	@Override
	public void insertar(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		Vehiculo vehiculo=this.buscar(placa);
		this.entityManager.remove(vehiculo);
	}

	@Override
	public Vehiculo buscar(String placa) {
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Vehiculo p WHERE p.placa= :datoPlaca");
		jpqlQuery.setParameter("datoPlaca", placa);
		return (Vehiculo)jpqlQuery.getSingleResult();
	}

	@Override
	public int actualizar(String tipo, String placa ) {
		Query myQuery=this.entityManager.createQuery("UPDATE Vehiculo p SET p.tipo = :datoTipo WHERE p.placa= :datoPlaca");
		myQuery.setParameter("datoTipo", tipo);
		myQuery.setParameter("datoPlaca", placa);
		return myQuery.executeUpdate();
	}
}
