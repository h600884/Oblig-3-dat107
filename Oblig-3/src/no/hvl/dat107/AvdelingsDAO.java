package no.hvl.dat107;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AvdelingsDAO {

	
	public static Avdeling finnAvdelingMedId(Integer avdelingsid) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "1234"));

        EntityManager em = emf.createEntityManager();

        Avdeling a = null;
        
        try {
        	
            a = em.find(Avdeling.class, avdelingsid);
            
        } finally {
        	
            em.close();
            
        }

        return a;
	}
	
	public static Ansatt FinnSjef (Integer avdeling) {
		Integer p =  finnAvdelingMedId(avdeling).getAvdelingssjef();
		return AnsattDAO.finnAnsattMedId(p);
	}
	
	public static List<Ansatt> UtlistingAvAnsattePaaAvdeling (Integer avdeling) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "1234"));

	    EntityManager em = emf.createEntityManager();
	 

	    String queryString = "select a from Ansatt a Where a.avdeling= :avdeling";
	    
	    Ansatt p = FinnSjef(avdeling);
	    System.out.println(p);
	    	
	    try {
	    	
	    		em.getTransaction().begin();
	    	
	    		
	    		TypedQuery<Ansatt> query = em.createQuery(queryString,Ansatt.class);
	    		
	    		query.setParameter("avdeling", avdeling);
	        
	    		
	    		em.getTransaction().commit();
	        
	       
	    		return query.getResultList();
	        

	    	} catch(NoResultException e) {
	    		return null;
	    		}
	    		finally {
	    		em.close();
	    }
	}
	
	
	public static Avdeling oppdaterAvdeling(Integer ansattid, Integer nyAvdeling) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "1234"));

		EntityManager em = emf.createEntityManager();

		Avdeling a = null;
		try {
			a = em.find(Avdeling.class, ansattid);
			a.setAvdelingsid(nyAvdeling);
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
	
	public static Avdeling leggTilAvdeling() {
		return null;
	}
}
