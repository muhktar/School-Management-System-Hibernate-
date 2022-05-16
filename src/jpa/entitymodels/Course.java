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

@Entity
@Table (name ="course")
public class Course {
	
	//sets variable cId to be id column of my course table. & the @Id annotation makes it the primary key
	@Id
	@Column(name= "id")
	private int cId;
	
	//sets variable cName to be id column of my course table
	@Column(name= "name")
	private String cName;
	
	//sets variable cInstructorName to be id column of my course table
	@Column(name = "instructor")
	private String cInstructorName;
	
	//this joins the table for course & student in order to populate the student course table 
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="student_course",
			joinColumns=@JoinColumn (name="course_id"),
			inverseJoinColumns=@JoinColumn (name="stu_email"))
	
	//	this represents an individual courses student list	
	private List<Student> cStudent;
	
	
	

	public Course() {
		
	}
	
	public Course(int cId, String cName, String cInstructorName) {
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcInstructorName() {
		return cInstructorName;
	}

	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

	public List<Student> getcStudent() {
		return cStudent;
	}

	public void setcStudent(List<Student> cStudent) {
		this.cStudent = cStudent;
	}
	
	//this enables you to get the values as seen in the database when printing, instead of the memory location
	@Override
	public String toString() {
		return "\nCourse [id=" + cId + ", name=" + cName +", instructor=" + cInstructorName+ "]";
	}
	
}
