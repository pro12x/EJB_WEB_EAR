package com.groupeisi.schoolEjb.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.groupeisi.schoolEjb.data.dto.CourseDto;
import com.groupeisi.schoolEjb.data.entities.CourseModel;

@Local
public interface ICourseService {

	List<CourseModel> list();

	CourseModel create(CourseDto courseData);

	CourseModel update(int id, CourseDto courseData);

	CourseModel get(int id);
}
