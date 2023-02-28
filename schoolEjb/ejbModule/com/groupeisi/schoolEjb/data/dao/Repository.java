package com.groupeisi.schoolEjb.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.groupeisi.schoolEjb.data.dao.interfaces.IRepository;

public abstract class Repository<T> implements IRepository<T>  {

	private Class<T> entityClass;

	private String tableName;

    protected Repository(Class<T> entityClass, String tableName) {
        this.entityClass = entityClass;
        this.tableName = tableName;
    }

    protected abstract EntityManager getEntityManager();

	@Transactional
	@Override
	public T add(T t) {
		getEntityManager().persist(t);
		return t;
	}

	@Transactional
	@Override
	public int delete(T t) {
		getEntityManager().remove(t);
		return 0;
	}

	@Transactional
	@Override
	public T update(T t) {
		getEntityManager().merge(t);
		return t;
	}

	@Override
	public List<T> list() {
		return (List<T>)getEntityManager().createQuery("from " + tableName, entityClass).getResultList();
	}

	@Override
	public T get(int id) {
		return (T) getEntityManager().find(entityClass, Long.valueOf(id));
	}

}
