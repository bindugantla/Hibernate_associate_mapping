package many_to_one_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteTeamByTeamId {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Team Id : ");
	int id=sc.nextInt();
	Team t = em.find(Team.class, id);
	if(t==null)
	{
		System.out.println("Invalid id....");
		return;
	}
	Query q = em.createQuery("from Player");
	 List<Player> pl = q.getResultList();
	 for (Player p : pl) {
		p.setTeam(null);
	}
	 et.begin();
	 em.remove(t);
	 et.commit();
	 System.out.println("done..");
}
}
