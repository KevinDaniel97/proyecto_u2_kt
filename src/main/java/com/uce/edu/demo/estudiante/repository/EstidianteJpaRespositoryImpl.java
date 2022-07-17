package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.repository.modelo.Estudiante;
@Repository
@Transactional
public class EstidianteJpaRespositoryImpl implements IEstudianteJpaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante e) {
		 this.entityManager.persist(e);		
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.entityManager.find(Estudiante.class,id);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.entityManager.merge(e);		
	}

	@Override
	public void eliminar(Integer id) {
		Estudiante estudiante=this.buscarPorId(id);
		this.entityManager.remove(estudiante);
	}

	@Override
	public Estudiante busacarPorCedulaTyped(String cedula) {
		TypedQuery<Estudiante> miTypèdQuery=this.entityManager.createQuery("SELECT p FROM Estudiante p WHERE p.cedula= :datoCedula",Estudiante.class);
		miTypèdQuery.setParameter("datoCedula", cedula);
		return miTypèdQuery.getSingleResult();
	}

	@Override
	public Estudiante busacarPorEdadTyped(Integer edad) {
		TypedQuery<Estudiante> miTypèdQuery2=this.entityManager.createQuery("SELECT p FROM Estudiante p WHERE p.edad= :datoEdad",Estudiante.class);
		miTypèdQuery2.setParameter("datoEdad", edad);
		return miTypèdQuery2.getSingleResult();
	}

	@Override
	public Estudiante busacarPorCedulaNamed(String cedula) {
		Query myNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedula");
		myNamedQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myNamedQuery.getSingleResult();
		
	}

	@Override
	public Estudiante busacarPorEdadNamed(Integer edad) {
		Query myNamedQuery2 = this.entityManager.createNamedQuery("Estudiante.buscarPorEdad");
		myNamedQuery2.setParameter("datoEdad", edad);
		return (Estudiante) myNamedQuery2.getSingleResult();
	}

	@Override
	public Estudiante busacarPorCedulaTypedNamed(String cedula) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedula",Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante busacarPorEdadTypedNamed(Integer edad) {
		TypedQuery<Estudiante> myQuery2 = this.entityManager.createNamedQuery("Estudiante.buscarPorEdad",Estudiante.class);
		myQuery2.setParameter("datoEdad", edad);
		return myQuery2.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombre(String nombre) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre",Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_cedula=:datoCedula",
				Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorEdadNative(Integer edad) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_edad=:datoEdad",
				Estudiante.class);
		myQuery.setParameter("datoEdad", edad);
		return (List<Estudiante>) myQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNamedNative(String cedula) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorCedulaNative",Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreNamedNative(String nombre) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorNombreNative",Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadCriterialApi(Integer edad) {
				CriteriaBuilder myBuilder= this.entityManager.getCriteriaBuilder();
				CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
				
				Root<Estudiante> estudianteFrom=myQuery.from(Estudiante.class);
				
				Predicate e1= myBuilder.equal(estudianteFrom.get("edad"), edad);
				CriteriaQuery<Estudiante> myQueryCompleto=myQuery.select(estudianteFrom).where(e1);
				TypedQuery<Estudiante> myQueryFinal=this.entityManager.createQuery(myQueryCompleto);
				
				return myQueryFinal.getResultList();
	}

	@Override
	public List<Estudiante> buscarDinamicamente(String nombre, String apellido, Integer edad) {
		   CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
	        CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);

	        Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

	        Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
	        Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
	        Predicate predicadoEdad = myCriteria.equal(myTabla.get("edad"), edad);


	        Predicate miPredicadoFinal = null;
 
	        if (edad<=24) {
	            miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
	            miPredicadoFinal = myCriteria.and(miPredicadoFinal, predicadoEdad);

	        } else {
	            miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
	            miPredicadoFinal = myCriteria.or(miPredicadoFinal, predicadoEdad);

	        }

	        myQuery.select(myTabla).where(miPredicadoFinal);
	        TypedQuery<Estudiante> myQueryFinal = this.entityManager
	                .createQuery(myQuery);

	        return myQueryFinal.getResultList();
	}


	

}
