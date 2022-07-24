package com.uce.edu.demo.autor.service;

import com.uce.edu.demo.autor.modelo.Libro;

public interface ILibroService {

	public void insertar(Libro libro);
	public Libro buscarPorId(Integer id);
	public void actualizar(Libro libro);	
	public void eliminar(Integer id);
}
