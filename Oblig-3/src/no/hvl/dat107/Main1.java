package no.hvl.dat107;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main1 {

	public static void main(String[] args) {
		
	String queryString = "SELECT a from Ansatt a";
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "1234"));

		EntityManager em = emf.createEntityManager();
		

		try {
	        TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
	        List<Ansatt> ansatte = query.getResultList();
		    
	        for (Ansatt a : ansatte) {
	            System.out.println(" Id: " + a.getAnsattid());
	            System.out.println(", Brukernavn: " + a.getBrukernavn());
	            System.out.println(", Navn: " + a.getFornavn() + a.getEtternavn());
	            System.out.println(", Ansattdato " + a.getAnsattdato());
	            System.out.println(", Stilling: " + a.getStilling());
	            System.out.println(", Månedslønn: " + a.getMonedslonn());
	        }
		} finally {
	        em.close();
		}
	}
}
