package com.uce.edu.demo.autor.repository;

import com.uce.edu.demo.autor.modelo.Autor;

public interface IAutorRepository {

	public void insertar(Autor autor);
	public void actualizar(Autor autor);
	public Autor buscarPorId(Integer id);
	public void eliminar(Integer id);
	
}
