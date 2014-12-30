package org.person;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)		// By default inheritance type is SINGLE_TABLE
public abstract class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	int id;
	String name;
	String phone;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	List<Car> carList = new ArrayList<Car>();

	public void addCar(Car car) {
		carList.add(car);
		car.setOwner(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void showCar() {
		for (Car car : carList) {
			System.out.println("===== Car Model: " + car.getModel());
		}
	}

}
