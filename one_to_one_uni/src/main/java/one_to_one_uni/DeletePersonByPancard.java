package one_to_one_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeletePersonByPancard
{
  public static void main(String[] args)
{
   EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
   EntityManager em=emf.createEntityManager();
   
   int pcid=1;//or user input we give
   PanCard pc= em.find(PanCard.class, pcid);
  Query q= em.createQuery("from Person");
    List <Person> li = q.getResultList();
    for (Person p : li) {
		 if(p.getPc().getId()==pcid)
		 {
			 EntityTransaction et=em.getTransaction();
			 et.begin();
			 em.remove(p);
			 et.commit();
			 System.out.println("Done");
		 }
	}
}
}
