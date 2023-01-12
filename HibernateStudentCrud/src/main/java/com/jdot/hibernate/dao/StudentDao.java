package com.jdot.hibernate.dao;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jdot.hibernate.entity.Student;
import com.jdot.hibernate.util.HibernateUtil;

public class StudentDao {
	
	private static final Object studentrno = null;

	public void saveStudent(Student Student) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			// operation 1
			Object object = session.save(Student);
			
			// operation 2
			//session.get(Student.class, (Serializable) object);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	

	public void updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the Student object
			String hql = "UPDATE Student set name = :name " + "WHERE studentrno = :studentrno";
			Query query = session.createQuery(hql);
			query.setParameter("Name", student.getName());
			System.out.println("***********"+student.getStudentrno());
			query.setParameter("studentrno", student.getStudentrno());
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteStudent(int stid) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			

			Object studentno = null;
			// Delete a Student object
			Student student = session.get(Student.class,stid);
			if (student != null) {
				String hql = "DELETE FROM Student " + "WHERE studentrno = :studentrno";
				Query query = session.createQuery(hql);
				query.setParameter("studentrno", studentrno);
				int result = query.executeUpdate();
				System.out.println("Rows affected: " + result);
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Student getStudent(int stid) {

		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// get an Student object
			String hql = " FROM Student S WHERE S.studentrno = :studentrno";
			Query query = session.createQuery(hql);
			Object studentno = null;
			query.setParameter("studentrno", studentrno);
			List results = query.getResultList();
			
			if (results != null && !results.isEmpty()) {
				student = (Student) results.get(0);
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}

	public List<Student> getStudents() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Student", Student.class).list();
		}
	}
}
