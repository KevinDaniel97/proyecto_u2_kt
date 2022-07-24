package com.uce.edu.demo.autor.service;

import com.uce.edu.demo.autor.modelo.Autor;

public interface IAutorService {

	public void insertar(Autor autor);
	public Autor buscarPorId(Integer id);
	public void actualizar(Autor autor);	
	public void eliminar(Integer id);
}
