package manytomany_bi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_bi.dto.Course;
import manytomany_bi.dto.Student;

public class Main {

	public static void main(String[] args) {
		
		Course c = new Course();
		c.setName("SQL");
		c.setFees(12000);
		c.setDuaration(1.5);
		
		Course c1 = new Course();
		c1.setName("Java");
		c1.setFees(18000);
		c1.setDuaration(4);
		
		Course c2 = new Course();
		c2.setName("Manual Testing");
		c2.setFees(10000);
		c2.setDuaration(1.5);
		
		Course c3 = new Course();
		c3.setName("J2EE");
		c3.setFees(19000);
		c3.setDuaration(2.5);
		
		Student s = new Student();
		s.setName("Shubham");
		s.setPhone(908767564);
		s.setAddress("Solapur");  
		List<Course> list1 = new ArrayList<Course>();
		list1.add(c);
		list1.add(c1);
		list1.add(c3);
		s.setC(list1);
		
		Student s1 = new Student();
		s1.setName("Ankita");
		s1.setPhone(123467564);
		s1.setAddress("Mumbai");
		List<Course> list2 = new ArrayList<Course>();
		list2.add(c);
		list2.add(c1);
		list2.add(c2);
		s1.setC(list2);

		Student s2 = new Student();
		s2.setName("Rohan");
		s2.setPhone(000067564);
		s2.setAddress("Nashik");
		List<Course> list = new ArrayList<Course>();
		list.add(c);
		list.add(c1);
		list.add(c2);
		list.add(c3);
		s2.setC(list);
		
		List<Student> l1 = new ArrayList<Student>();
		l1.add(s);
		l1.add(s1);
		l1.add(s2);
		c.setS(l1);
		
		List<Student> l2 = new ArrayList<Student>();
		l2.add(s);
		l2.add(s1);
		l2.add(s2);
		c1.setS(l1);
		
		List<Student> l3 = new ArrayList<Student>();
		l3.add(s1);
		l3.add(s2);
		c2.setS(l1);
		
		List<Student> l4 = new ArrayList<Student>();
		l4.add(s);
		l4.add(s2);
		c3.setS(l1);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sujit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(s);
		manager.persist(s1);
		manager.persist(s2);
		manager.persist(c);
		manager.persist(c1);
		manager.persist(c2);
		manager.persist(c3);
		transaction.commit();
	}

}
