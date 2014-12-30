package org.person;

import javax.persistence.Entity;

@Entity
public class Student extends Person{
	Integer marks;
	
	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	
}