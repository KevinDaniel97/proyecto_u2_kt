package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.modelo.Vehiculo;

public interface IVehiculoRepository {
	
	public void insertar(Vehiculo vehiculo);

	public int actualizar(String tipo, String placa);

	public void eliminar(String placa);

	public Vehiculo buscar(String placa);
}
