package many_to_one_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PrintAllPlayerNamesByplayerId {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Player Id : ");
	int id=sc.nextInt();
	Player p = em.find(Player.class, id);
	if(p==null)
	{
		System.err.println("Invalid player id....");
		return;
	}
	
	Query q = em.createQuery("from Player");
	List <Player> p1 = q.getResultList();
	
	for (Player p2 : p1) {
		if(p2.getTeam().getId()==p.getTeam().getId())
		{
			System.out.println(p2.getName());
		}
	}
}
}
