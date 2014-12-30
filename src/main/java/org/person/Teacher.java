package org.person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Teacher extends Person{
	String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
