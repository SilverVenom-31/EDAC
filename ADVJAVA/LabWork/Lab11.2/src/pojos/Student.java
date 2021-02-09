package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
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
	
	@Embedded
	private AadharCard aadharCard;

@ElementCollection
@CollectionTable(name = "educational_qual" ,joinColumns = @JoinColumn(name="student_id"))
@Column(name = "education_qual")
private List<EducationalQual> educationalQuals=new ArrayList<>(); 

public List<EducationalQual> getEducationalQuals() {
	return educationalQuals;
}

public void setEducationalQuals(List<EducationalQual> educationalQuals) {
	this.educationalQuals = educationalQuals;
}

public Student() {
	System.out.println("in Student constr");
}

public Student(String name, String email) {
	super();
	this.name = name;
	this.email = email;
}
public AadharCard getAadharCard() {
	return aadharCard;
}

public void setAadharCard(AadharCard aadharCard) {
	this.aadharCard = aadharCard;
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
