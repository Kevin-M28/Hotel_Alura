package com.hotelAlura.dao;

import com.hotelAlura.clases.Cliente;
import com.hotelAlura.clases.Reserva;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ClientesDao {
	private EntityManager em;

	public ClientesDao(EntityManager em) {
		this.em = em;
	}

	public void guardarCliente(Cliente clien) {
		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			this.em.persist(clien);
			trasaction.commit();
		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	public Cliente buscarCliente(long id) {
		return this.em.find(Cliente.class, id);
	}

	public void actualizarCliente(Cliente clien) {

		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			this.em.merge(clien);
			trasaction.commit();

		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	public void eliminarCliente(long id) {
		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			Cliente clien = this.em.find(Cliente.class, id);
			if (clien != null) {
				this.em.remove(clien);
			}
			trasaction.commit();
		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
		}
	}

	public List<Cliente> listaClientes() {
		String jqpl = "SELECT C FROM Cliente AS C";
		return this.em.createQuery(jqpl, Cliente.class).getResultList();
	}

	public List<Cliente> listaClienteParametros(String nom, String ape) {
		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
			Root<Cliente> root = query.from(Cliente.class);
			List<Predicate> condiciones = new ArrayList<>();
			if (nom != null && !nom.trim().isEmpty()) {
				Predicate nombrePredicate = cb.equal(root.get("nombre"), nom);
	            condiciones.add(nombrePredicate);
			}

			if (ape != null && !ape.trim().isEmpty()) {
				Predicate apellidoPredicate = cb.equal(root.get("apellido"), ape);
	            condiciones.add(apellidoPredicate);
			}
			query.where(condiciones.toArray(new Predicate[0]));

			return em.createQuery(query).getResultList();
		} catch (NoResultException e) {
			return null;
		}

	}
	 public List<Reserva> obtenerReservasCliente(long idCliente) {
	        Cliente cli = em.find(Cliente.class, idCliente);
	        if (cli != null) {
	            return cli.getReservas();
	        }
	        return new ArrayList<>(); 
	    }
}
