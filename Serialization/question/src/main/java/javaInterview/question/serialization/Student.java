package javaInterview.question.serialization;

import java.io.Serializable;
public class Student  implements Serializable {
	private int id;
	private String name;
	transient private int salary;
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
	
	public Student(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public int hashCode() {
		return this.id*10;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj ==null || getClass()!=obj.getClass())
		{
			return false;
		}
		Student s1 =  (Student)obj;
		if(this.id!=s1.id || this.name != s1.name)
		{
			return false;
		}
		return true;
		
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	

}
