package org.person;

import javax.persistence.Entity;

@Entity
public class Student extends Person{
	int marks;
	
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}