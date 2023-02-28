package com.groupeisi.schoolEjb.data.dao.interfaces;

import javax.ejb.Local;

import com.groupeisi.schoolEjb.data.entities.StudentModel;

@Local
public interface IStudentDao extends IRepository<StudentModel> {

}
