package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bd_imoveis"); 
		factory.close();
		
		System.out.println("Tables geradas!");
	}	
}
