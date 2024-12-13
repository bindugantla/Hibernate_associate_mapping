package many_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndMapPlayerAndTeam {
	public static void main(String[] args) {
      EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
      EntityManager em=emf.createEntityManager();
      EntityTransaction et=em.getTransaction();
      
      Team t = new Team(0, "India", "Gowtham");
      
      Player p1 = new Player(0, "virat", 48, t);
      
      et.begin();
      em.persist(t);
      em.persist(p1);
      et.commit();
	}
}
