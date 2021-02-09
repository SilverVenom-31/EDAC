package dao;

import pojos.Course;
import pojos.Student;

public interface IStudentDao {
//student admission
	String admitStudent(Student student,String courseTitle);
	String cancelAdmission(String courseName,int studId);
}
