package many_to_one_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PrintPlayerNameByTeamId {
 public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Team id :");
	int id=sc.nextInt();
	Team t = em.find(Team.class, id);
	if(t==null)
	{
		System.err.println("Invalid team id....");
		return;
	}
	
	Query q = em.createQuery("from Player");
	List <Player> res = q.getResultList();
	
	for (Player p : res) {
		if(p.getTeam().getId()==t.getId())
		{
			System.out.println(p.getName());
		}
	}
	
}
}
