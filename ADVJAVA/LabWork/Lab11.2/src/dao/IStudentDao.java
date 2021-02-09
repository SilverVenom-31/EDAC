package dao;

import java.util.List;

import pojos.Course;
import pojos.Student;

public interface IStudentDao {
//student admission
	String admitStudent(Student student,String courseTitle);
	String cancelAdmission(String courseName,int studId);
	String admitStudentWithAC(Student student, int courseId);
	List<Student> getStudDetByCourse(String courseName);
}
