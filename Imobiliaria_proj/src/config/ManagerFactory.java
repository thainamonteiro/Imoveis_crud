package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactory {

	private static EntityManagerFactory manager;
	private static String factory;

	/**
	 * Método responsável por gerenciar a fabrica de entidades
	 * 
	 * @param unidadePersistencia
	 * @return
	 */
	public static EntityManager getSession(String unidadePersistencia) {
		try {
			if (manager.isOpen() && ManagerFactory.factory.equals(unidadePersistencia)) {
				return manager.createEntityManager();
			} else {
				factory = unidadePersistencia;
				manager = Persistence.createEntityManagerFactory(unidadePersistencia);
				return manager.createEntityManager();
			}
		} catch (NullPointerException e) {
			factory = unidadePersistencia;
			manager = Persistence.createEntityManagerFactory(factory);
			return manager.createEntityManager();
		}
	}
}
