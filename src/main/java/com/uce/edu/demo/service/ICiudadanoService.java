package com.uce.edu.demo.service;

import com.uce.edu.demo.respository.modelo.onetoone.Ciudadano;

public interface ICiudadanoService  {

	public void insertar(Ciudadano ciudadano);
	public Ciudadano buscarPorId(Integer id);
	public void actualizar(Ciudadano ciudadano);	
	public void eliminar(Integer id);
}
