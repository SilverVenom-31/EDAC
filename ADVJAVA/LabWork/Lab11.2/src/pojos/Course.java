package pojos;
//id(inherited from BaseEntity class),title,strtDate,endDate,fees,capacity,List<student>

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "courses_tbl")
public class Course extends BaseEntity {
	@Column(length = 30)
	private String title;
	@Temporal(TemporalType.DATE) // not required for LocalDate Time
	@Column(name = "start_date")
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	private double fees;
	private int capacity;
//one to many association
	// value of mappedBy should name of the property as in owning side
	@OneToMany(mappedBy = "selectedCourse", cascade = CascadeType.ALL,orphanRemoval = true) //fetch = FetchType.EAGER (not recommended)
	private List<Student> students = new ArrayList<>();

	// def constructor
	public Course() {
		System.out.println("in course constr");
	}

	public Course(String title, Date startDate, Date endDate, double fees, int capacity) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// tip:avoid recurssion : never give students details
	@Override
	public String toString() {
		return "Course [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", fees=" + fees
				+ ", capacity=" + capacity + "]";
	}

	// add helper methods for bidirectional assoc,for establishing between parent
	// and child as well as child to parent
	// not mandatory but recommended
	public void addStudent(Student s) {//linking
		students.add(s);//parent to child
	    s.setSelectedCourse(this); //child to parent
	}

	public void removeStudent(Student s) {// unlinking
		students.remove(s);
		s.setSelectedCourse(null);
	}

}
