package one_to_many;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveModule
{
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		Module m = new Module();
	
		m.setName("Arrays");
		et.begin();
		Module dbm= em.merge(m);
		et.commit();
		System.out.println(dbm);
		System.out.println("Done...");
	}
}
