package com.uce.edu.demo.repository;

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

import com.uce.edu.demo.respository.modelo.Persona;

@Repository
@Transactional
public class PersonJpaRespositoryImpl implements IPersonaJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarPorId(Integer id) {
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona persona) {
		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		Persona persona = this.buscarPorId(id);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// SELECT * FROM persona Where pers_cedula='111215';
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula= :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Persona) jpqlQuery.getSingleResult();
	}

	@Override
	public Persona busacarPorCedulaTyped(String cedula) {
		TypedQuery<Persona> miTypèdQuery = this.entityManager
				.createQuery("SELECT p FROM Persona p WHERE p.cedula= :datoCedula", Persona.class);
		miTypèdQuery.setParameter("datoCedula", cedula);
		return miTypèdQuery.getSingleResult();
	}

	@Override
	public Persona busacarPorCedulaNamed(String cedula) {
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona busacarPorCedulaTypedNamed(String cedula) {
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}
	//-------------NATIVE----------------------------
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM persona WHERE pers_cedula=:datoCedula",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		TypedQuery<Persona> myQuery=this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative",Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}
	//-----------------CRITERIAL API--------------------
	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		//creamos una instancia de la interfaz CriterialBuilder fabrica para construccion 
		CriteriaBuilder myBuilder= this.entityManager.getCriteriaBuilder();
		//especificamos el retorno de mi SLQ
		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);
		
		//aqui empezamos a construir el SQL
		//Root FROM
		Root<Persona> personaFrom=myQuery.from(Persona.class);//FROM Persona
		//myQuery.select(personaFrom);//Select p FROM Persona
		//La condiciones where en criteria Api se los conoce como predicados
		Predicate p1= myBuilder.equal(personaFrom.get("cedula"), cedula);//p.cedula=: datoCedula
		
		//CriteriaQuery<Persona> myQueryCompleto=myQuery.select(personaFrom).where(p1);
		CriteriaQuery<Persona> myQueryCompleto=myQuery.select(personaFrom).where(p1);

		//Finalizado mi Query completo
		
		TypedQuery<Persona> myQueryFinal=this.entityManager.createQuery(myQueryCompleto);
		
		return myQueryFinal.getSingleResult();
	}
	@Override
    public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
        CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

        Root<Persona> myTabla = myQuery.from(Persona.class);

        Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
        Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);

        Predicate miPredicadoFinal = null;

        if (genero.equals("M")) {
            miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
        } else {
            miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
        }

        myQuery.select(myTabla).where(miPredicadoFinal);
        TypedQuery<Persona> myQueryFinal = this.entityManager
                .createQuery(myQuery);

        return myQueryFinal.getSingleResult();
    }

	@Override
    public Persona buscarDinamicamenteNombre(String nombre, String apellido, String genero) {
        CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

        Root<Persona> myTabla = myQuery.from(Persona.class);

        Predicate predicadoGenero = myCriteria.equal(myTabla.get("genero"), genero);
        Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
        Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);

        Predicate miPredicadoFinal = null;

        if (genero.equals("M")) {
            miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
            miPredicadoFinal = myCriteria.and(miPredicadoFinal, predicadoGenero);

        } else {
            miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
            miPredicadoFinal = myCriteria.or(miPredicadoFinal, predicadoGenero);

        }

        myQuery.select(myTabla).where(miPredicadoFinal);
        TypedQuery<Persona> myQueryFinal = this.entityManager
                .createQuery(myQuery);

        return myQueryFinal.getSingleResult();
    }
	
	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido= :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNombreApellido",
				Persona.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		Query nombreQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre= :datoNombre");
		nombreQuery.setParameter("datoNombre", nombre);
		return nombreQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		Query generoeQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero= :datoGenero");
		generoeQuery.setParameter("datoGenero", genero);
		return generoeQuery.getResultList();
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		Query myQuery = this.entityManager
				.createQuery("UPDATE Persona p SET p.genero = :datoGenero WHERE p.apellido= :datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();
	}

	@Override
	public int eliminarPorGenero(String genero) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero= :genero");
		myQuery.setParameter("genero", genero);
		return myQuery.executeUpdate();
	}

	

	

}
