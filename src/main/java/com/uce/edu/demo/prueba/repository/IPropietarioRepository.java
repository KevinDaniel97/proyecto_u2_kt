package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.modelo.Propietario;

public interface IPropietarioRepository {
	
	public Propietario consultar(String cedula);

	public void crear(Propietario propietario);
	
	public int eliminarPorCedula(String cedula);
	
}
