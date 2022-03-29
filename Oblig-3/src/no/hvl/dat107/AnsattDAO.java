package no.hvl.dat107;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {

	
	 public static Ansatt finnAnsattMedId(int id) {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));

	        EntityManager em = emf.createEntityManager();

	        Ansatt a = null;
	        
	        try {
	            a = em.find(Ansatt.class, id);

	        } finally {
	            em.close();
	        }

	        return a;
		}

	 public static Ansatt finnPersonMedBrukernavn(String brukernavn) {
		 
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));

	        EntityManager em = emf.createEntityManager();
		 
	
		 String queryString = ("select a from Ansatt a Where a.brukernavn = :brukernavn");
	        
	        try {
	        	// starter en transatksjon med database. 
	            em.getTransaction().begin();
	            //hva som skal bli gjort i databasen
	            TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
	            //hva som blir lagret fra databasen
	            query.setParameter("brukernavn", brukernavn);
	            
	            //lagrer alt som har blitt gjort i transaksjonen.
	            em.getTransaction().commit();
	            
	            //returnere første infoen vi fikk tak i.
	            return query.getSingleResult();
	            

	        } catch(NoResultException e) {
	        	return null;
	        }
	        finally {
	            em.close();
	        }
	 }
	 
	 public static List<Ansatt> listeAlleAnsatte() {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));
			

	        EntityManager em = emf.createEntityManager();
	        
	        
	        String queryString = "select a from Ansatt a";

	        
	        try {
	 
	            em.getTransaction().begin();
	            TypedQuery<Ansatt> query = em.createQuery(queryString,Ansatt.class);
	            em.getTransaction().commit();
	            
	            return query.getResultList();
	            

	        } catch(NoResultException e) {
	        	return null;
	        }
	        finally {
	            em.close();
	        }
		}
	 
	 public static Ansatt oppdaterLonn(Integer ansattid, Integer nyLonn) {
		 
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));
			

	        EntityManager em = emf.createEntityManager();
		 
	        Ansatt a = null;
	        
	        try {
	        	a = em.find(Ansatt.class, ansattid);
	        	a.setMonedslonn(nyLonn);
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

		public static Ansatt oppdaterStilling(Integer ansattid, String nyStilling) {
			
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));

			EntityManager em = emf.createEntityManager();

			Ansatt a = null;
			try {
				a = em.find(Ansatt.class, ansattid);
				a.setStilling(nyStilling);
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
	 
	 public static Ansatt oppdaterStillingOgLonn(Integer ansattid, String nyStilling, Integer nyLonn) {
		 
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));
			

	        EntityManager em = emf.createEntityManager();
	        
	        Ansatt a = null;
	        try {
	        	a= em.find(Ansatt.class, ansattid);
	        	a.setStilling(nyStilling);
	        	a.setMonedslonn(nyLonn);
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
	 
	 public static Ansatt leggTilAnsatt(Integer ansattid, String brukernavn, String fornavn, String etternavn,
				LocalDate ansattdato, String stilling, Integer monedslonn, Integer avdeling) {
		 
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("ansattPersistenceUnit", 
					Map.of("javax.persistence.jdbc.password", "1234"));
			

	        EntityManager em = emf.createEntityManager();
	    	EntityTransaction tx = em.getTransaction();
	    	
	    	Ansatt a = new Ansatt(ansattid, brukernavn, fornavn, etternavn,
			ansattdato, stilling, monedslonn, avdeling);

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
 
			
}

