package com.acc;
 
import java.util.*;
 
class Employee implements Comparable<Employee>{
	private String name;
	private int age;
	
	public Employee(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Employee emp) {  
		if(this.name>emp.name){
			return -1;
		}else if(this.name<emp.name){
			return 1;
		}else{
			if(this.age>emp.age){
				return 1;
			}else if(this.age<emp.age){
				return -1;
			}else{
				return 0;
			}
		}
	}
	
	public String toString(){
		return "NAME"+this.name+", AGE"+this.age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}