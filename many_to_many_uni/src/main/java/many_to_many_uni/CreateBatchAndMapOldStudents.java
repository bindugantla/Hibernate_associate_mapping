package many_to_many_uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateBatchAndMapOldStudents {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
//	Student s16 = em.find(Student.class, 16);
//	Student s17 = em.find(Student.class, 17);
	
	
	Student s16 = new Student(0,"Raju", "raju@gmail.com");
	Student s17 = new Student(0,"Ramu", "ramu@gmail.com");
	List<Student> std=new ArrayList<Student>();
	std.add(s16);
	std.add(s17);
	Batch b = new Batch(0, "Social", "FGYF34-FT45", std);
	et.begin();
	em.persist(b);
	em.persist(s16);
	em.persist(s17);
	et.commit();
	System.out.println("Done........m");
	 
	
	
}
}
