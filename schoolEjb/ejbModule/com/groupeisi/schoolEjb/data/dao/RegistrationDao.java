package com.groupeisi.schoolEjb.data.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.schoolEjb.data.dao.interfaces.IRegistrationDao;
import com.groupeisi.schoolEjb.data.entities.RegistrationModel;

@Stateless
public class RegistrationDao extends Repository<RegistrationModel> implements IRegistrationDao {

	@PersistenceContext
	private EntityManager em;

	public RegistrationDao() {
		super(RegistrationModel.class, "RegistrationModel");
	}

	@Override
    public EntityManager getEntityManager() {
        return em;
    }
}
