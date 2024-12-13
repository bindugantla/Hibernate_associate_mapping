package one_to_one_uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchPersonById 
{
 public static void main(String[] args) 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	System.out.println("Enter id of person");
	Person p= em.find(Person.class,  new Scanner(System.in).nextInt());
	System.out.println(p.getName());
	System.out.println(p.getEmail());
	System.out.println(p.getPc().getPin());
	System.out.println(p.getPc().getpNo());
}
}
