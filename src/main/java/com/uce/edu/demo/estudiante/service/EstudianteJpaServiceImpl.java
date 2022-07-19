package com.uce.edu.demo.estudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteContadorEdad;
import com.uce.edu.demo.estudiante.repository.modelo.EstudianteSencillo;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService{

	@Autowired
	private IEstudianteJpaRepository iEstudianteJpaRepository;
	
	@Override
	public void guardar(Estudiante e) {
		this.iEstudianteJpaRepository.insertar(e);
	}

	@Override
	public Estudiante buscarPorId(int id) {
		
		return this.iEstudianteJpaRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.iEstudianteJpaRepository.actualizar(e);
		
	}

	@Override
	public void eliminar(int id) {
		this.iEstudianteJpaRepository.eliminar(id);
		
	}

	@Override
	public Estudiante busacarPorCedulaTyped(String cedula) {
		return this.iEstudianteJpaRepository.busacarPorCedulaTyped(cedula);
	}

	@Override
	public Estudiante busacarPorEdadTyped(Integer edad) {
		return this.iEstudianteJpaRepository.busacarPorEdadTyped(edad);
	}

	@Override
	public Estudiante busacarPorCedulaNamed(String cedula) {
		return this.iEstudianteJpaRepository.busacarPorCedulaNamed(cedula);
	}

	@Override
	public Estudiante busacarPorEdadNamed(Integer edad) {
		return this.iEstudianteJpaRepository.busacarPorEdadNamed(edad);
	}

	@Override
	public Estudiante busacarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.busacarPorCedulaTypedNamed(cedula);
	}

	@Override
	public Estudiante busacarPorEdadTypedNamed(Integer edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.busacarPorEdadTypedNamed(edad);
	}

	@Override
	public List<Estudiante> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombre(nombre);
	}

	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaNative(cedula);
	}

	@Override
	public List<Estudiante> buscarPorEdadNative(Integer edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorEdadNative(edad);
	}

	@Override
	public Estudiante buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorCedulaNamedNative(cedula);
	}

	@Override
	public List<Estudiante> buscarPorNombreNamedNative(String nombre) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreNamedNative(nombre);
	}

	@Override
	public List<Estudiante> buscarPorEdadCriterialApi(Integer edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorEdadCriterialApi(edad);
	}

	@Override
	public List<Estudiante> buscarDinamicamente(String nombre, String apellido, Integer edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarDinamicamente(nombre, apellido, edad);
	}

	@Override
	public List<EstudianteSencillo> buscarPorEdadSencillo(Integer edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorEdadSencillo(edad);
	}

	@Override
	public List<EstudianteContadorEdad> consultarCantidadPorEdad() {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.consultarCantidadPorEdad();
	}

}
