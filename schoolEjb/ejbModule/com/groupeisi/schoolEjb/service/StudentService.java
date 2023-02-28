package com.groupeisi.schoolEjb.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.groupeisi.schoolEjb.data.dao.interfaces.IStudentDao;
import com.groupeisi.schoolEjb.data.dto.StudentDto;
import com.groupeisi.schoolEjb.data.entities.StudentModel;
import com.groupeisi.schoolEjb.service.interfaces.IStudentService;

@Stateless
public class StudentService implements IStudentService {

	@EJB
	private IStudentDao studentDao;

	@Override
	public List<StudentModel> list() {
		return this.studentDao.list();
	}

	@Override
	public StudentModel create(StudentDto studentData) {
		return this.studentDao.add(studentData.toModel(new StudentModel()));
	}

	@Override
	public StudentModel update(int id, StudentDto studentData) {
		StudentModel student = this.studentDao.get(id);
		assert student != null;

		return this.studentDao.update(studentData.toModel(student));
	}

	@Override
	public StudentModel get(int id) {
		return this.studentDao.get(id);
	}
}
