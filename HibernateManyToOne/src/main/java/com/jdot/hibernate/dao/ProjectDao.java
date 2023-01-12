package com.jdot.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jdot.hibernate.entity.Project;
import com.jdot.hibernate.util.HibernateUtil;

public class ProjectDao {
	
	public void saveProject(Project project) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the employee object
			session.save(project);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}

