package jpa.mainrunner;

import java.util.Scanner;

import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentService stuServ = new StudentService();
		CourseService coServ = new CourseService();
		Scanner sc = new Scanner(System.in);
		
		//stuServ.validateStudent("aiannitti7@is.gd", "TWP4hf5j");
		//email: cstartin3@flickr.com ,name: Clem Startin ,password: XYHzJ1S

		System.out.println("TO LOG IN TYPE YOUR EMAIL AND PRESS ENTER. \nTHEN ENTER YOUR PASSWORD AND PRESS ENTER.");
		stuServ.validateStudent(sc.next(), sc.next());
		
		
		
		//stuServ.registerStudentToCourse("aiannitti7@is.gd", 1);
		//stuServ.registerStudentToCourse("cjaulme9@bing.com", 2);
		//stuServ.registerStudentToCourse("cjaulme9@bing.com", 1);
	
	}

}
