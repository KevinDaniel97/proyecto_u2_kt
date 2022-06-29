package com.uce.edu.demo.estudiante.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.to.Estudiante;
import com.uce.edu.demo.to.PersonaTo;


@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertar(Estudiante e) {

		this.jdbcTemplate.update("insert into estudiante (id, nombre, apellido, cedula, edad)values(?,?,?,?,?)", 
				new Object[] {e.getId(),e.getNombre(),e.getApellido(),e.getCedula(),e.getEdad()});
	}

	@Override
	public Estudiante buscarPorId(int id) {
		return this.jdbcTemplate.queryForObject("select * from estudiante where id=?", 
				new Object[] {id},new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}
	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update estudiante set nombre=?, edad=? where id=?",
				new Object[] {e.getNombre(),e.getEdad(),e.getId()});
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		System.out.println("se elimino el usuario: "+id);
		this.jdbcTemplate.update("delete from Estudiante where id=?",new Object[] {id});
	}

		
	

}
