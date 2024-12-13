//
package many_to_many_uni;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddNewStudentsToExistingBatch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter batch id :");
		int bId = sc.nextInt();
		Batch b = em.find(Batch.class, bId);
		if (b == null) {
			System.err.println("Invalid id.....");
			return;
		}
		List<Student> std = new ArrayList<Student>();
		boolean flag = true;

		while (flag) {
			System.out.println("Do you want to add Student to Batch(Y/N)");
			char ch = sc.next().charAt(0);
			if (ch == 'Y' || ch == 'y') {
				Student s = new Student();
				System.out.println("Enter student name :");
				s.setName(sc.next());
				System.out.println("Enter student email :");
				s.setEmail(sc.next());
				std.add(s);
			} else {
				flag = false;
			}
		}
      List<Student> osl = b.getStudents();
      osl.addAll(std);
      
      et.begin();
     for (Student s : std) {
		em.persist(s);
	}
      em.merge(b);
      et.commit();
      System.out.println("Done...");
	}
}
