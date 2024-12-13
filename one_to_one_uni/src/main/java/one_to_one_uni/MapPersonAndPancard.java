package one_to_one_uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapPersonAndPancard {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		int pid = 1;
		int pcid = 1;
		Person p = em.find(Person.class, pid);
		PanCard pc = em.find(PanCard.class, pcid);

		p.setName("raju");
		p.setPc(pc);

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(p);
		et.commit();
	}
}
