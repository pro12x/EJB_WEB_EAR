package com.groupeisi.schoolEjb.data.dao.interfaces;

import javax.ejb.Local;

import com.groupeisi.schoolEjb.data.entities.RegistrationModel;

@Local
public interface IRegistrationDao extends IRepository<RegistrationModel> {

}
