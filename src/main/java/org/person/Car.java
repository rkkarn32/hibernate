package org.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Car {

	@Id @GeneratedValue
	int id;
	String model;
	
	@ManyToOne
	Person owner;
	
	public Car() {	}
	
	public Car(String model) {
		super();
		this.model = model;
	}

	public int getId() {
		return id;
	}
	
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
