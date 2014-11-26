package br.com.trixmaps.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("trixmaps");

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
/*	public static void main(String args[]){
		EntityManagerFactory factory = Persistence.
		          createEntityManagerFactory("trixmaps");

		    factory.close();
	}*/
}
