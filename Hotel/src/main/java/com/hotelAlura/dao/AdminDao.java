package com.hotelAlura.dao;

import com.hotelAlura.clases.Administrador;

import jakarta.persistence.*;

public class AdminDao {
	private EntityManager em;

	public AdminDao(EntityManager em) {
		this.em = em;
	}

	public void guardarAdmin(Administrador admin) {
		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			this.em.persist(admin);
			trasaction.commit();
		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	public Administrador buscarAdmin(long id) {
		return this.em.find(Administrador.class, id);
	}

	public void actualizarAdmin(Administrador admin) {

		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			this.em.merge(admin);
			trasaction.commit();
			
		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	public void eliminarAdmin(long id) {
		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			Administrador administrador = this.em.find(Administrador.class, id);
			if (administrador != null) {
				this.em.remove(administrador);
			}
			trasaction.commit();
		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
		}
	}
}
