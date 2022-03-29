package no.hvl.dat107;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProsjektDAO {

	 public static Prosjekt leggTilProsjekt(Integer prosjektid, String prosjektnavn, String beskrivelse) {
		 
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));
			

	        EntityManager em = emf.createEntityManager();
	    	EntityTransaction tx = em.getTransaction();
	    	
	    	Prosjekt a = new Prosjekt(prosjektid, prosjektnavn, beskrivelse);

			try {
				tx.begin();
				em.persist(a); 
				tx.commit();
			
			} catch (Throwable e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				em.close();
			}
	       
	        
	       return a; 
	 }
	 
	 public static ProsjektDeltagelse registrereProsjektDeltagelse (Integer ansattid, Integer prosjektid, Integer timer, String rolle) {
		 
		 EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));
			

	        EntityManager em = emf.createEntityManager();
	        
	        ProsjektDeltagelse a = new ProsjektDeltagelse(ansattid, prosjektid, timer, rolle);
	        
	        try {
	         	em.getTransaction().begin();
	    		em.persist(a);
	   			em.getTransaction().commit();
	    	    } catch (Throwable e) {
	    			e.printStackTrace();
	    			em.getTransaction().rollback();
	    	        } finally {
	    			em.close();
	    	        }
	
		 return a;
	 }
	 
	 public static ProsjektDeltagelse foreTimer (Integer prosjektid, Integer timer) {
		 
		 EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));
			

	        EntityManager em = emf.createEntityManager();
	        
	        ProsjektDeltagelse a = null;
	        
	        try {
	        	a = em.find(ProsjektDeltagelse.class, prosjektid);
	        	a.setTimer(timer);
	        	em.getTransaction().begin();
	        	em.merge(a);
	        	em.getTransaction().commit();
	        } catch (Throwable e) {
	        	e.printStackTrace();
	        	em.getTransaction().rollback();
	        } finally {
	        	em.close();
	        }
		 return a;
	 }
	 
	 public static List<Ansatt> UtlistingAvProsjekt (Integer prosjekt) {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));

		    EntityManager em = emf.createEntityManager();
		 

		    String queryString = "select a from Ansatt a Where a.Prosjekt= :Prosjekt";
		    	
		    try {
		    	
		    		em.getTransaction().begin();
		    	
		    		
		    		TypedQuery<Ansatt> query = em.createQuery(queryString,Ansatt.class);
		    		
		    		query.setParameter("Prosjekt", prosjekt);
		        
		    		
		    		em.getTransaction().commit();
		        
		       
		    		return query.getResultList();
		        

		    	} catch(NoResultException e) {
		    		return null;
		    		}
		    		finally {
		    		em.close();
		    }
		}
}
