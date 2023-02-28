package com.groupeisi.schoolEjb.data.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="registrations")
public class RegistrationModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String details;

	@ManyToOne
	private StudentModel student;

	@ManyToOne
	private SchoolYearModel schoolYear;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "registrations_courses",
		joinColumns = { @JoinColumn(name = "registration_id") },
		inverseJoinColumns = { @JoinColumn(name = "course_id") }
	)
	private List<CourseModel> courses;

	public RegistrationModel() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}

	public SchoolYearModel getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(SchoolYearModel schoolYear) {
		this.schoolYear = schoolYear;
	}

	public List<CourseModel> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseModel> courses) {
		this.courses = courses;
	}  
}
