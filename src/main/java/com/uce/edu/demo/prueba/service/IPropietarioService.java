package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.modelo.Propietario;

public interface IPropietarioService {
	
	public Propietario consultar(String cedula);

	public void crear(Propietario propietario);
	
	public int eliminarPorCedula(String cedula);
	
	
}
