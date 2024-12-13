package one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapModuleToSubject 
{
  public static void main(String[] args) 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	int m1=1;
	int m2=2;
	int m3=3;
	int m4=4;
	int m5=5;
	
	int s1=1;
	
	Module module1 = em.find(Module.class, m1);
	Module module2 = em.find(Module.class, m2);
	Module module3 = em.find(Module.class, m3);
	Module module4 = em.find(Module.class, m4);
	Module module5 = em.find(Module.class, m5);
	
	Subject sub1= em.find(Subject.class, s1);
	
	List <Module> modules=new ArrayList<Module>();
	modules.add(module1);
	modules.add(module2);
	modules.add(module3);
	modules.add(module4);
	modules.add(module5);
	
	sub1.setM(modules);
	
	et.begin();
	em.merge(sub1);
	et.commit();
	System.out.println("Done....");
}
}
