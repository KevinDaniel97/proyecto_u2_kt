package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.IPropietarioRepository;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired 
	private IPropietarioRepository propietarioRepository;
	
	@Override
	public void crear(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepository.crear(propietario);
	}


	@Override
	public Propietario consultar(String cedula) {
		// TODO Auto-generated method stub
		return this.propietarioRepository.consultar(cedula);
	}

	@Override
	public int eliminarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.propietarioRepository.eliminarPorCedula(cedula);
	}

}
