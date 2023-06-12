package com.hotelAlura.pruevas;

import java.util.Date;

import com.hotelAlura.clases.Cliente;
import com.hotelAlura.dao.ClientesDao;
import com.hotelAlura.utiles.JPAUtils;

import jakarta.persistence.EntityManager;


public class clientesPrueba {

	public static void main(String[] args) {
	try (JPAUtils entityManagerUtil = new JPAUtils()) {
            EntityManager em = entityManagerUtil.getEntityManager();
            Cliente cl1 = new Cliente("Kevin", "Alonso", new Date(), "Costarricense", Long.parseLong("80205792"), "Kef2829", "masteryi");
            Cliente cl2 = new Cliente("Kevin", "Ferrer", new Date(), "Costarricense", Long.parseLong("70205792"), "Kef2029", "master100");
            ClientesDao c1 = new ClientesDao(em);
            
            c1.guardarCliente(cl1);
            c1.guardarCliente(cl2);
         
            cl2.setTelefono(Long.parseLong("90205792"));
            c1.actualizarCliente(cl2);
           
		}catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
