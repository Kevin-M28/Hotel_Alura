package com.hotelAlura.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils implements AutoCloseable{
    private EntityManagerFactory factory;
    private EntityManager entityManager;


	public JPAUtils() {
		 this.factory = Persistence.createEntityManagerFactory("hotel");
	     this.entityManager = factory.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void close() throws Exception {
		this.entityManager.close();
        this.factory.close();
	}
}
