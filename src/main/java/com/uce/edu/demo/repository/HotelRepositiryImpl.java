package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.respository.modelo.onetomany.Hotel;

@Repository
@Transactional
public class HotelRepositiryImpl implements IHotelRepository{

	@Autowired
	private EntityManager entityManager;
	@Override
	public void insetar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

}
