import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.jdot.hibernate.dao.EmployeeDao;
import com.jdot.hibernate.entity.Employee;
import com.jdot.hibernate.entity.Project;

public class Main {
	public static void main(String[] args) {

		Employee employee = new Employee("Scott", "scott@gmail.com");
		
		List<Project> projects=new ArrayList<Project>();
		
		Calendar cal=Calendar.getInstance();
		cal.set(2022, 6, 30);
		Date startDate=cal.getTime();
		
		cal.set(2022, 8, 29);
		Date releaseDate=cal.getTime();

		Project project = new Project("LMS","Jdot");
		project.setStartDate(startDate);
		project.setReleaseDate(releaseDate);
		project.setEmployee(employee);
		
		projects.add(project);

		cal=Calendar.getInstance();
		cal.set(2022, 6, 30);
		startDate=cal.getTime();
		
		cal.set(2022, 8, 29);
		releaseDate=cal.getTime();

		project = new Project("EMS","Swagen");
		project.setStartDate(startDate);
		project.setReleaseDate(releaseDate);
		project.setEmployee(employee);
		
		projects.add(project);

		employee.setProject(projects);
		
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.saveEmployee(employee);
	}
}

