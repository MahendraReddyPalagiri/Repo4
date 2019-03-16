package com.durgasoft.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.durgasoft.bean.Employee;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
	    EntityTransaction tx=null;	
	try {
		System.out.println("Hi");
		factory=Persistence.createEntityManagerFactory("emp");
	    manager=factory.createEntityManager();
		tx=manager.getTransaction();
		tx.begin();
		Employee emp=new Employee();
		emp.setEno(453);
		emp.setEname("BBB");
		emp.setEsal(777);
		emp.setEaddr("HYY");
		 manager.persist(emp);
		 System.out.println("Employee Insertion Success");
		 tx.commit();
		} catch (Exception e) {
          tx.rollback();
          e.printStackTrace();
          System.out.println("Employee Insertion faliuyre");
		}finally {
			factory.close();
			manager.close();
		}

	}

}
