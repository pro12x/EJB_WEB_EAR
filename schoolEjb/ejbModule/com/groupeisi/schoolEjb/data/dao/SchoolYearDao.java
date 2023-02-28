package com.groupeisi.schoolEjb.data.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.schoolEjb.data.dao.interfaces.ISchoolYearDao;
import com.groupeisi.schoolEjb.data.entities.SchoolYearModel;

@Stateless
public class SchoolYearDao extends Repository<SchoolYearModel> implements ISchoolYearDao {

	@PersistenceContext
	private EntityManager em;

	public SchoolYearDao() {
		super(SchoolYearModel.class, "SchoolYearModel");
	}

	@Override
    public EntityManager getEntityManager() {
        return em;
    }
}
