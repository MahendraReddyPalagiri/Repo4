package com.durgasoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		try {

			cfg = new Configuration();
			cfg.configure("config/hibernate.cfg.xml");

			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder = serviceRegistryBuilder.applySettings(cfg.getProperties());
			StandardServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			sf = cfg.buildSessionFactory(serviceRegistry);
			session = sf.openSession();
			tx = session.beginTransaction();
			Employee emp = new Employee();
			emp.setEno(111);
			session.delete(emp);
			tx.commit();
			System.out.println("Employee Deleted Successfully");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Employee Deletion Failure");
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}

	}

}
