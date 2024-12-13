package many_to_one_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeletePlayerByTeamId {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Team id :");
	int id=sc.nextInt();
	Team t = em.find(Team.class, id);
	if(t==null)
	{
		System.err.println("Invalid id ...");
		return;
	}
	Query q= em.createQuery("from Player");
	List <Player> p = q.getResultList();
	for (Player p1 : p) {
		if(p1.getTeam().getId()==t.getId())
		{
			et.begin();
			em.remove(p1);
			et.commit();
		}
	}
}
}
