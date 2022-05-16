package jpa.service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO {

	

	Scanner sc = new Scanner(System.in);
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentByEmail(String sEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		// TODO Auto-generated method stub
			// create session factory
			SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Course.class)								
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
				
			// create session
			Session session = factory.getCurrentSession();
			try {			
				
				// start a transaction
				session.beginTransaction();		
				
				// This gets the student from database
				Student tempStudent = session.get(Student.class, sEmail);
				
				if(tempStudent.getsEmail().equals(sEmail) && tempStudent.getsPass().equals(sPassword)) {
					System.out.println("\nYou are Successfully logged in!!");
					
					//this prints the individuals students name
					System.out.println("\nLoaded student: " + tempStudent.getsName()+"\n");
					
					//this prints all the individual students courses that they registered for    
					System.out.println("\n"+ tempStudent.getsName()+"s' Course List: " + tempStudent.getsCourses());
					
					System.out.println("\nTO REGISTER FOR A CLASS ENTER 1.\nELSE, ENTER 2 TO LOG OFF.");
					int regClass = sc.nextInt();
				
					StudentService stu = new StudentService();
					if(regClass == 1) {
						CourseService allClasses= new CourseService();
												
						System.out.println(allClasses.getAllCourses());
						
						System.out.println("\nENTER YOUR EMAIL.\nTHEN ENTER THE COURSE ID NUMBER OF THE CLASS YOU WOULD LIKE TO REGISTER FOR:");
						stu.registerStudentToCourse(sc.next(), sc.nextInt());
					}
					if(regClass == 2) {
						System.out.println("YOU HAVE BEEN LOGGED OUT.");
					}
					return true;
				}
				else {
					return false;	
				}
			}
			catch(NullPointerException e){
				System.out.println("YOU HAVE THE WRONG INFORMATION. TRY AGAIN LATER. GOODBYE.");
				return false;
			}
			
			finally {
				// add clean up code
				session.close();
				
				factory.close();
			}
			
	}

	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		// TODO Auto-generated method stub
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Course.class)								
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
				
			
			
			// This gets the student from database
			Student tempStudent = session.get(Student.class, sEmail);
			
			System.out.println("\nLoaded student: " + tempStudent.getsName());
			System.out.println("\n"+ tempStudent.getsName()+"s' Course List:" + tempStudent.getsCourses());		
			
			
				
			Course aCourse =  session.get(Course.class, cId);
			
			if(tempStudent.getsCourses().contains(aCourse)) {
				System.out.println("you already are registered for this course.");
			}else {
				tempStudent.addCourse(aCourse);
				System.out.println("\nTHE CLASS WAS ADDED!");
				System.out.println("\n"+ tempStudent.getsName()+"s' Updated Course List:" + tempStudent.getsCourses());		
			}
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}
		

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}
