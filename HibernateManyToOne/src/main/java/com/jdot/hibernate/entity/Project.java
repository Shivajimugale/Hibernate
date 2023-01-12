package com.jdot.hibernate.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name="project")  
public class Project {
	
    @Id
    @Column(name="project_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int projectId;
    
    @Column(name="project_title", nullable = false)
    private String projectTitle;
    
    @Column(name="client_code", nullable = false)
    private String clientCode;
    
    @Column(name="start_date", nullable = false)
    private Date startDate;
    
    @Column(name="release_date", nullable = false)
    private Date releaseDate;
    
    /*  
	mappedBy attribute is used in bidirectional association to link with other side of entity.
	If the relationship is bidirectional, the non-owning side must use the mappedBy element of 
        the OneToOne annotation to specify the relationship field or property of the owning side.
    */
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="project")
    private List<Employee> employees;
    
    public Project(){

    }

	public Project(String projectTitle, String clientCode) {
		super();
		this.projectTitle = projectTitle;
		this.clientCode = clientCode;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
   
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}
}
