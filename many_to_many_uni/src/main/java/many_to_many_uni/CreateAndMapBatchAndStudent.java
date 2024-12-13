package many_to_many_uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndMapBatchAndStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student s1 = new Student(0, "Dileep", "dileep@gmail.com");
		Student s2 = new Student(0, "Nandha", "nandha@gmail.com");
		Student s3 = new Student(0, "Naveen", "naveen@gmail.com");
		Student s4 = new Student(0, "ObulReddy", "obulreddy@gmail.com");
		Student s5 = new Student(0, "Girish", "girish@gmail.com");

		List<Student> std = new ArrayList<Student>();
		std.add(s1);
		std.add(s2);
		std.add(s3);
		std.add(s4);
		std.add(s5);
		Batch b1 = new Batch(0, "Advance java", "JHE-FFHES-M6", std);
		Batch b2= new Batch(0, "java", "JHE-FFHES-M28", std);
		Batch b3 = new Batch(0, "SQl", "JHE-FFHES-M62", std);
		Batch b4 = new Batch(0, "Web Technology", "JHE-FFHES-M54", std);
		Batch b5 = new Batch(0, "Core Java", "JHE-FFHES-M21", std);
		et.begin();
		
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(b4);
		em.persist(b5);
		et.commit();
		System.out.println("Done.....");

	}
}
