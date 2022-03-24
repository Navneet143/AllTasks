package Yaml;

import java.util.List;

public class Employee01 {
	private String name;
	private int age;
	private String address;
	private List<Employee01> employee;
	
	public Employee01() {}
	
	public Employee01(String address,int age , String name, List<Employee01> employee) {
		this.name=name;
		this.age=age;
		this.address=address;
		this.employee=employee;
	}
	public List<Employee01> getemployee(){
		return employee;
	}
	
	public String getname() {
		return name;
	}
	
	public int getage() {
		return age;
	}
	
	public String getaddress() {
		return address;
	}
	
	public void print() {
		System.out.println("My name is "+name+"\nMy age is "+age+"\nI live in: "+address);
	}
}
