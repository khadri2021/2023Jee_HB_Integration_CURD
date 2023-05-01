package com.khadri.jee.hibernate.integration.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	public static EntityManager createEntityManager() {

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("PERSISTENCE_UNIT_MYSQL");

		return entityManagerFactory.createEntityManager();
	}

}
