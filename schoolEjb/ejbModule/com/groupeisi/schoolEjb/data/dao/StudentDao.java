package com.groupeisi.schoolEjb.data.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.schoolEjb.data.dao.interfaces.IStudentDao;
import com.groupeisi.schoolEjb.data.entities.StudentModel;

@Stateless
public class StudentDao extends Repository<StudentModel> implements IStudentDao {

	@PersistenceContext
	private EntityManager em;

	public StudentDao() {
		super(StudentModel.class, "StudentModel");
	}

	@Override
    public EntityManager getEntityManager() {
        return em;
    }
}
