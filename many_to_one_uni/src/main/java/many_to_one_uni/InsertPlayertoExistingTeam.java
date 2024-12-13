package many_to_one_uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertPlayertoExistingTeam {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Team id : ");
		int id = sc.nextInt();
		Team t = em.find(Team.class, id);
		if (t == null) {
			System.err.println("Invalid team id....");
			return;

		}

		System.out.println("Enter playe name : ");
		String name = sc.next();
		System.out.println("Enter player jersey no : ");
		int jerseyNo = sc.nextInt();
		Player p = new Player(0, name, jerseyNo, t);

		et.begin();
		em.persist(p);
		et.commit();
		System.out.println("Done....");
	}
}
