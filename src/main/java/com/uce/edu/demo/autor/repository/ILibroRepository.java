package com.uce.edu.demo.autor.repository;

import com.uce.edu.demo.autor.modelo.Libro;

public interface ILibroRepository {

	public void insertar(Libro libro);
	public void actualizar(Libro libro);
	public Libro buscarPorId(Integer id);
	public void eliminar(Integer id);
	
}
