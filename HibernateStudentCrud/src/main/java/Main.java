import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.jdot.hibernate.dao.StudentDao;
import com.jdot.hibernate.entity.Student;

public class Main {
	public static void main(String[] args) {
        
		StudentDao studentDao = new StudentDao();
		
		
		
		Calendar cal=Calendar.getInstance();
		cal.set(1994, 5, 16);
		Date date1=cal.getTime();
		
		Student student1 = new Student(1,"Scott", "scott@gmail.com");
		student1.setDate(date1);
		studentDao.saveStudent(student1);
		/*
		cal.set(1995, 5, 16);
		Date date2=cal.getTime();
		Student student2 = new Student(2,"Rose", "rose@gmail.com");
		studentDao.saveStudent(student2);
		
		cal.set(1996, 5, 16);
		Date date3=cal.getTime();
		Student student3 = new Student(3,"Mark", "mark@gmail.com");
		studentDao.saveStudent(student3);
		
		*/
		
        // update student1
	/*	cal.set(1997, 6, 16);
		Date date4=cal.getTime();
	
	   Student student2 = new Student(2,"Gorge","gorge@gmail.com");
		student2.setStudentrno(2);
		studentDao.updateStudent(student2);
         
		*/
		// get Students
	/*	List<Student> students = studentDao.getStudents();
		students.forEach(s -> System.out.println(s.getName()));
		*/
		// get single student
	/*	Student student2 = studentDao.getStudent(1);
		System.out.println(student2.getName());
	*/	
		// delete student
    	//studentDao.deleteStudent(1);
	}
}
