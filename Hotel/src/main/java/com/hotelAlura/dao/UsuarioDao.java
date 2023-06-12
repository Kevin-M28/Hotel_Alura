package com.hotelAlura.dao;

import java.util.List;

import com.hotelAlura.clases.Administrador;
import com.hotelAlura.clases.Cliente;
import com.hotelAlura.clases.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UsuarioDao {
	private EntityManager em;

	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	public void guardarUsuario(Usuario user) {
		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			this.em.persist(user);
			trasaction.commit();
		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	public Usuario buscarUsuario(long id) {
		return this.em.find(Usuario.class, id);
	}

	public void actualizarUsuario(Usuario user) {

		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			this.em.merge(user);
			trasaction.commit();

		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	public void eliminarUsuario(long id) {
		EntityTransaction trasaction = this.em.getTransaction();
		try {
			trasaction.begin();
			Usuario user = this.em.find(Usuario.class, id);
			if (user != null) {
				this.em.remove(user);
			}
			trasaction.commit();
		} catch (Exception e) {
			if (trasaction != null && trasaction.isActive()) {
				trasaction.rollback();
			}
		}
	}

	public Usuario verificarCredenciales(String usuario, String contrasenna) {
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
	    Root<Usuario> root = query.from(Usuario.class);

	    Predicate usuarioPredicate = cb.equal(root.get("usuario"), usuario);
	    Predicate contrasennaPredicate = cb.equal(root.get("contrasenna"), contrasenna);
	    query.where(usuarioPredicate, contrasennaPredicate);

	    TypedQuery<Usuario> typedQuery = em.createQuery(query);
	    List<Usuario> usuarios = typedQuery.getResultList();

	    if (!usuarios.isEmpty()) {
	        Usuario usuarioEncontrado = usuarios.get(0);

	        String tipoUsuario = usuarioEncontrado.getClass().getSimpleName();

	        if (tipoUsuario.equals("Cliente")) {
	            Cliente cliente = em.find(Cliente.class, usuarioEncontrado.getId_usuarios());
	            return cliente;
	        } else if (tipoUsuario.equals("Administrador")) {
	            Administrador administrador = em.find(Administrador.class, usuarioEncontrado.getId_usuarios());
	            return administrador;
	        }
	    }
	    return null;
	}
}


