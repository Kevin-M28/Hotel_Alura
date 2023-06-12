package com.hotelAlura.dao;

import java.util.List;

import com.hotelAlura.clases.Reserva;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ReservaDao {
	private EntityManager em;

	public ReservaDao(EntityManager em) {
		this.em = em;
	}

	public void guardarReserva(Reserva res) {
		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			this.em.persist(res);
			trasaction.commit();
		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	public Reserva buscarReserva(long id) {
		return this.em.find(Reserva.class, id);
	}

	public void actualizarReserva(Reserva res) {

		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			this.em.merge(res);
			trasaction.commit();

		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	public void eliminarReserva(long id) {
		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			Reserva res = this.em.find(Reserva.class, id);
			if (res != null) {
				this.em.remove(res);
			}
			trasaction.commit();
		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
		}
	}

	public List<Reserva> listaReservas() {
		String jqpl = "SELECT R FROM Reserva AS R";
		return this.em.createQuery(jqpl, Reserva.class).getResultList();
	}

	public List<Reserva> listaReservasPorUsuario(long id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Reserva> query = cb.createQuery(Reserva.class);
		Root<Reserva> root = query.from(Reserva.class);

		Predicate condicion = cb.equal(root.get("cliente").get("id"), id);

		query.select(root).where(condicion);

		return em.createQuery(query).getResultList();
	}
}
