package com.uce.edu.demo.autor.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="libro")
public class Libro {

	@Id
	@Column(name="libr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libr_id_sec")
	@SequenceGenerator(name = "libr_id_sec", sequenceName = "libr_id_sec", allocationSize = 1)
	private Integer id;
	
	@Column(name = "libr_titulo")
	private String titulo;
	
	@Column(name = "libr_editorial")
	private String editorial;
	
	@Column(name = "libr_genero")
	private String genero;
	
	@ManyToOne
	@JoinColumn(name="libr_id_autor")
	private Autor autor;

	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", editorial=" + editorial + ", genero=" + genero + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	
}
