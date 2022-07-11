package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.modelo.Vehiculo;

public interface IVehiculoService {

	public void insertar(Vehiculo vehiculo);

	public int actualizarPorApellido(String tipo, String placa);

	public void eliminar(String placa);

	public Vehiculo buscar(String placa);
}
