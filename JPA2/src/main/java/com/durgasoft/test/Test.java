package com.durgasoft.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.durgasoft.bean.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
	 EntityManagerFactory factory=Persistence.createEntityManagerFactory("emp");
	 EntityManager manager=factory.createEntityManager();
	 EntityTransaction transaction=manager.getTransaction();
	 transaction.begin();
	 Employee emp=manager.find(Employee.class, 11);
     manager.remove(emp);
	 transaction.commit();
	 System.out.println("Deletion Success");
	}

}
