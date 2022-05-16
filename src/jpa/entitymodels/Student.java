package jpa.entitymodels;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//signifies this class represents table in my database
@Entity
@Table(name="student")
public class Student {
	
	// sets variable sEmail to be email column of my student table. & the @Id annotation makes it the primary key
	@Id
	@Column(name="email")
	private String sEmail;
	
	// sets variable sName to be name column of my student table
	@Column(name="name")
	private String sName;
	
	// sets variable sPass to be password column of my student table
	@Column(name="password")
	private String sPass;
	
	//this joins the table for student & course in order to populate the student course table 
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="student_course",
			joinColumns=@JoinColumn(name="stu_email"),
			inverseJoinColumns=@JoinColumn(name="course_id")
			)
	//this collection represents a individual students course list
	private List<Course> sCourses;
	
	
	//this method adds a course to an individual students course list
	public void addCourse(Course course) {
		sCourses.add(course);
	}
	public Student() {
		
	}
	
	public Student(String sEmail, String sName, String sPass ) {
		this.sEmail = sEmail;
		this.sName= sName;
		this.sPass = sPass;
		
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}
	
	
	@Override
	public String toString() {
		return "\nStudent [email=" + sEmail + ", name=" + sName + ", password=" + sPass + "]";
	}
}
