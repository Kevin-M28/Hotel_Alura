package com.hotelAlura.pruevas;

import com.hotelAlura.utiles.JPAUtils;

import jakarta.persistence.EntityManager;

public class PruebaConexion {


	public static void main(String[] args) {
		try (JPAUtils entityManagerUtil = new JPAUtils()) {
            EntityManager entityManager = entityManagerUtil.getEntityManager();

			String verifica;
			if (entityManager.isOpen())
				verifica = "Esta abrierta";
			else
				verifica = "Esta Cerrada";
			System.out.println(verifica);
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
