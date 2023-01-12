package com.jdot.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="studentrno")
	private int studentrno;
	
	@Column(name="name")
	private String name;

	@Column(name="email")
	private String email;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	

	
	
	
public Student() {
		
	}
	
	
	
	public Student(int studentrno, String name, String email) {
		super();
		this.studentrno = studentrno;
		this.name = name;
		this.email = email;
		
	}



		public int getStudentrno() {
		return studentrno;
	}



	public void setStudentrno(int studentrno) {
		this.studentrno = studentrno;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getDate() {
		return dateOfBirth;
	}



	public void setDate(Date date) {
		this.dateOfBirth = date;
	}



}