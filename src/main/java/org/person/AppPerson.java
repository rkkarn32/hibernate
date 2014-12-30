package org.person;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppPerson {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry; 
	static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
	public static void main(String[] args) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Person p = new Person();
		Car c1 = new Car("Nano");
		Car c2 = new Car("Hyundai");
		p.setName("Ramesh");
		p.setPhone("434345");
		p.addCar(c1);
		session.persist(p);
		p.setPhone("44444444444");
		Person p1 = new Person();
		p1.setName("Deepesh");
		p1.setPhone("8584844");
		p1.addCar(c2);
		session.persist(p1);
		tx.commit();
		session.close();
		
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Person> list = session.createQuery("from Person").list();
		for (Person person : list) {
			System.out.println("Name: "+person.getName()+", Phone: "+person.getPhone());
			person.showCar();
		}
		tx.commit();
		session.close();
		System.exit(0);
	}
}
