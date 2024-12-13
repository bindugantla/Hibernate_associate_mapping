package many_to_many_uni;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Batch {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String code;
  
  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<Student> students;
  public Batch()
  {
	  
  }
  

public Batch(int id, String name, String code, List<Student> students) {
	super();
	this.id = id;
	this.name = name;
	this.code = code;
	this.students = students;
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

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public List<Student> getStudents() {
	return students;
}

public void setStudents(List<Student> students) {
	this.students = students;
}


@Override
public String toString() {
	return "Batch [id=" + id + ", name=" + name + ", code=" + code + ", students=" + students + "]";
}


@Override
public int hashCode() {
	return Objects.hash(code, id, name, students);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Batch other = (Batch) obj;
	return Objects.equals(code, other.code) && id == other.id && Objects.equals(name, other.name)
			&& Objects.equals(students, other.students);
}

  
  
}
