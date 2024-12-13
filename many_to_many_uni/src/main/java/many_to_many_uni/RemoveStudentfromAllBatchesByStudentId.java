package many_to_many_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RemoveStudentfromAllBatchesByStudentId {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student id : ");
		int sid = sc.nextInt();

		Student std = em.find(Student.class, sid);
		if (std == null) {
			System.err.println("Invalid Student  id ....");
			return;
		}
		Query q = em.createQuery("from Batch");
		List<Batch> bl = q.getResultList();

		for (Batch b : bl) {
			List<Student> sl = b.getStudents();
			if (sl.contains(std)) {
				sl.remove(std);
			}
			//b.setStudents(sl);
			et.begin();
			em.merge(b);
			et.commit();

		}
		System.out.println("Done......");

	}
}
