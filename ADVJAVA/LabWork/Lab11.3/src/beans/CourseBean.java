//Created by @AkhilD on 08/02/2021
package beans;

import dao.CourseDaoImpl;

public class CourseBean {

	private CourseDaoImpl cDao;
	
	public CourseBean() {
		cDao = new CourseDaoImpl();
		System.out.println("In course bean");
	}

	public CourseDaoImpl getcDao() {
		return cDao;
	}

	public void setcDao(CourseDaoImpl cDao) {
		this.cDao = cDao;
	}
	
}
