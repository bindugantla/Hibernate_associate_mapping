package many_to_many_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PrintBatchNamebyBatchId {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Batch id :");
		int bId=sc.nextInt();
		Batch b = em.find(Batch.class, bId);
		List<Student> std = b.getStudents();
		System.out.println(b.getName());
		List<Batch> bl= em.createQuery("from Batch").getResultList();
		
		for (Batch batch : bl) {
			List<Student> ssl=batch.getStudents();
			if(ssl.containsAll(std))  {
	           System.out.println(batch.getName());
           }
 
		}
	}
}
