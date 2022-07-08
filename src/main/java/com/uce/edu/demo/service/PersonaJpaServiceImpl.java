package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.respository.modelo.Persona;
@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService {
	
	@Autowired
	private IPersonaJpaRepository iPersonaJpaRepository;

	@Override
	public Persona buscarPorId(Integer id) {
		return this.iPersonaJpaRepository.buscarPorId(id);
	}

	@Override
	public void insertar(Persona persona) {
		this.iPersonaJpaRepository.insertar(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		this.iPersonaJpaRepository.actualizar(persona);
	}

	@Override
	public void eliminar(Integer id) {
		this.iPersonaJpaRepository.eliminar(id);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		return this.iPersonaJpaRepository.buscarPorCedula(cedula);
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorApellido(apellido);
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		return this.iPersonaJpaRepository.buscarPorNombre(nombre);
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		return this.iPersonaJpaRepository.buscarPorGenero(genero);
	}

}
