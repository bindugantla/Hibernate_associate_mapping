package many_to_many_uni;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PrintAllStudentByBatchId {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Batch id :");
	int bId=sc.nextInt();
	Batch b = em.find(Batch.class, bId);
	System.out.println(b.getName());
	
	List<Student> std = b.getStudents();
	System.out.println(b.getName());
	for (Student s1 : std) {
		System.out.println(s1.getName());
	}
}
}
