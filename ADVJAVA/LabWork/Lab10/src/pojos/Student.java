package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students_tbl")
public class Student extends BaseEntity{
	@Column(length = 20)
private String name;
	@Column(length = 20,unique = true)
private String email;
//bi directional association: many to one association
	@ManyToOne
	@JoinColumn(name="course_id",nullable = false)
private Course selectedCourse;

public Student() {
	System.out.println("in Student constr");
}

public Student(String name, String email) {
	super();
	this.name = name;
	this.email = email;
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

public Course getSelectedCourse() {
	return selectedCourse;
}

public void setSelectedCourse(Course selectedCourse) {
	this.selectedCourse = selectedCourse;
}

//never give association property in toString to avoid recursion
@Override
public String toString() {
	return "Student [name=" + name + ", email=" + email + "]";
}


}
