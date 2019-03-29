package com.acc;
 
import java.util.*;
 
class Employee {
	private String name;
	private int age;
	
	public Employee(String name,int age){
		this.name = name;
		this.age = age;
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