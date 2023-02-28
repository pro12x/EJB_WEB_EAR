package com.groupeisi.schoolEjb.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.groupeisi.schoolEjb.data.dto.StudentDto;
import com.groupeisi.schoolEjb.data.entities.StudentModel;

@Local
public interface IStudentService {

	List<StudentModel> list();

	StudentModel create(StudentDto studentData);

	StudentModel update(int id, StudentDto studentData);

	StudentModel get(int id);
}
