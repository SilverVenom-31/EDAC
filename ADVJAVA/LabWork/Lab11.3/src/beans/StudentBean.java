//Created by @AkhilD on 08/02/2021
package beans;

import dao.StudentDaoImpl;

public class StudentBean {
	private StudentDaoImpl sDao;
	
	
	public StudentBean() {
		sDao=new StudentDaoImpl();
	}


	public StudentDaoImpl getsDao() {
		return sDao;
	}


	public void setsDao(StudentDaoImpl sDao) {
		this.sDao = sDao;
	}

}
