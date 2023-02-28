package com.groupeisi.schoolEjb.data.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.schoolEjb.data.dao.interfaces.ICourseDao;
import com.groupeisi.schoolEjb.data.entities.CourseModel;

@Stateless
public class CourseDao extends Repository<CourseModel> implements ICourseDao {

	@PersistenceContext
	private EntityManager em;

	public CourseDao() {
		super(CourseModel.class, "CourseModel");
	}

	@Override
    public EntityManager getEntityManager() {
        return em;
    }
}
