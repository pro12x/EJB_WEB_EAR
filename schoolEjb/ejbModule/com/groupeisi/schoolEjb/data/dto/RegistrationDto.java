package com.groupeisi.schoolEjb.data.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.groupeisi.schoolEjb.data.dao.interfaces.ICourseDao;
import com.groupeisi.schoolEjb.data.dao.interfaces.ISchoolYearDao;
import com.groupeisi.schoolEjb.data.dao.interfaces.IStudentDao;
import com.groupeisi.schoolEjb.data.entities.CourseModel;
import com.groupeisi.schoolEjb.data.entities.RegistrationModel;
import com.groupeisi.schoolEjb.data.entities.SchoolYearModel;
import com.groupeisi.schoolEjb.data.entities.StudentModel;

public class RegistrationDto {

	private String details;

	private int studentId;

	private int schoolYearId;

	private Set<Integer> courseIds;

	public RegistrationDto() {}

	public RegistrationDto(Map<String, String[]> parameters) {
		this.details = parameters.get("details")[0];
		this.studentId = Integer.parseInt(parameters.get("studentId")[0]);
		this.schoolYearId = Integer.parseInt(parameters.get("schoolYearId")[0]);
		this.courseIds = Set.of(parameters.get("courseIds")).stream().map(Integer::parseInt).collect(Collectors.toSet());
	}

	public RegistrationModel toModel(RegistrationModel model, IStudentDao studentDao, ISchoolYearDao schoolYearDao, ICourseDao courseDao) {
		model.setDetails(details);

		StudentModel student = studentDao.get(studentId);
		assert student != null;
		model.setStudent(student);

		SchoolYearModel schoolYear = schoolYearDao.get(schoolYearId);
		assert schoolYear != null;
		model.setSchoolYear(schoolYear);

		List<CourseModel> courses = new ArrayList<>();
		for(Integer courseId : courseIds) {
			CourseModel course = courseDao.get(courseId);
			assert course != null;
			courses.add(course);
		}
		model.setCourses(courses);

		return model;
	}
}
