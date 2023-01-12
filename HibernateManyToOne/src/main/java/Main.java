import java.util.Calendar;
import java.util.Date;

import com.jdot.hibernate.dao.EmployeeDao;
import com.jdot.hibernate.dao.ProjectDao;
import com.jdot.hibernate.entity.Employee;
import com.jdot.hibernate.entity.Project;

public class Main {
	public static void main(String[] args) {

		EmployeeDao employeeDao = new EmployeeDao();
		
		
		Calendar cal=Calendar.getInstance();
		cal.set(2022, 6, 01);
		Date startDate=cal.getTime();
		
		cal.set(2022, 8, 01);
		Date releaseDate=cal.getTime();

		Project project = new Project("LMS","Jdot");
		project.setStartDate(startDate);
		project.setReleaseDate(releaseDate);
		
		ProjectDao projectDao=new ProjectDao();
		projectDao.saveProject(project);
		
		Employee employee = new Employee("Scott", "scott@gmail.com");
		employee.setProject(project);
		employeeDao.saveEmployee(employee);
		
		employee =new Employee("Rose", "rose@gmail.com");
		employee.setProject(project);
		employeeDao.saveEmployee(employee);

		employee =new Employee("Mark", "mark@gmail.com");
		employee.setProject(project);
		employeeDao.saveEmployee(employee);
		
			}
}

