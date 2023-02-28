package com.groupeisi.schoolEjb.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.groupeisi.schoolEjb.data.dao.interfaces.ICourseDao;
import com.groupeisi.schoolEjb.data.dto.CourseDto;
import com.groupeisi.schoolEjb.data.entities.CourseModel;
import com.groupeisi.schoolEjb.service.interfaces.ICourseService;

@Stateless
public class CourseService implements ICourseService {

	@EJB
	private ICourseDao courseDao;

	@Override
	public List<CourseModel> list() {
		return this.courseDao.list();
	}

	@Override
	public CourseModel create(CourseDto courseData) {
		return this.courseDao.add(courseData.toModel(new CourseModel()));
	}

	@Override
	public CourseModel update(int id, CourseDto courseData) {
		CourseModel course = this.courseDao.get(id);
		assert course != null;

		return this.courseDao.update(courseData.toModel(course));
	}

	@Override
	public CourseModel get(int id) {
		return this.courseDao.get(id);
	}
}
