package com.hotelAlura.pruevas;

import com.hotelAlura.clases.Administrador;
import com.hotelAlura.dao.AdminDao;
import com.hotelAlura.utiles.JPAUtils;

import jakarta.persistence.EntityManager;

public class adminPrueba {
	private static Administrador adm = new Administrador("Kevin","Admin","Admin");
	
	public static void main(String[] args) {
		try (JPAUtils entityManagerUtil = new JPAUtils()) {
            EntityManager entityManager = entityManagerUtil.getEntityManager();
            AdminDao ad = new AdminDao(entityManager);
            ad.guardarAdmin(adm);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
