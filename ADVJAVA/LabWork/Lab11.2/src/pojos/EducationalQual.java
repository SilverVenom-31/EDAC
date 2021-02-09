//Created by @AkhilD on 08/02/2021
package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Embeddable
public class EducationalQual {
@Enumerated(EnumType.STRING)
@Column(length = 20)
	private EducationType type;
@Column(length = 10)
	private String year;
	private double grade;
	
	
	public EducationalQual(EducationType type, String year, double grade) {
		super();
		this.type = type;
		this.year = year;
		this.grade = grade;
	}
	public EducationalQual() {
		System.out.println("in educ qual constr");
	}
	public EducationType getType() {
		return type;
	}
	public void setType(EducationType type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "EducationalQual [type=" + type + ", year=" + year + ", grade=" + grade + "]";
	}
	
}
