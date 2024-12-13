package one_to_many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveSubject {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Subject s = new Subject(0, "Java", 5, "CSE", null);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		Subject dbs = em.merge(s);
		et.commit();
		System.out.println(dbs);
		System.out.println("Done...");
	}
}
