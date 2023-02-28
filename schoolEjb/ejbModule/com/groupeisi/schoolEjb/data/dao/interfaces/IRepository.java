package com.groupeisi.schoolEjb.data.dao.interfaces;

import java.util.List;

public interface IRepository <T> {

	public T add(T t);

	public int delete(T t);

	public T update(T t);

	public List<T> list();

	public T get(int id);
}
