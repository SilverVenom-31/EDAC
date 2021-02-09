package dao;

import java.util.List;

import pojos.Course;

public interface ICourseDao {
String launchCourse(Course c); //c: transient
String cancelCourse(int cId);
Course fetchCourseDetails(String courseName);

}
