package jpa.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class CourseService implements CourseDAO{
	
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Course> getAllCourses() {
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
						
					System.out.println("\nTHE AVAILABLE COURSES ARE: \n");
					
					String hql="FROM Course";
					org.hibernate.query.Query query=session.createQuery(hql);
					java.util.List results=query.list();
					System.out.println("Saved the course: " + results);
					
					/*STACK OVERFLOWS EXAMPLE TO GET THE CONTENTS A WHOLE TABLE
					@SuppressWarnings("deprecation")
					Criteria criteria = session.createCriteria(Course.class);
					List<Course> list = criteria.list();
					for(Course test: list) {
					    System.out.println(test.getcId() + " " + test.getcName() + " " + test.getcInstructorName());					   
					} */
				
					
								
					// commit transaction
					session.getTransaction().commit();
					System.out.println("THESE ARE ALL THE AVAILABLE COURSES.");
					
					
				}
				finally {
					
					// add clean up code
					session.close();
					
					factory.close();
				}
			
		return null;
	}



}
