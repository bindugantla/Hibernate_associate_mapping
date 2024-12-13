package one_to_many;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int semester;
	private String branch;
	@OneToMany
    private List<Module> m;

	public Subject()
	{
		
	}
	
	public Subject(int id, String name, int semester, String branch, List<Module> m) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.branch = branch;
		this.m = m;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public List<Module> getM() {
		return m;
	}
	public void setM(List<Module> m) {
		this.m = m;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", semester=" + semester + ", branch=" + branch + ", m=" + m
				+ "]";
	}
	
}
