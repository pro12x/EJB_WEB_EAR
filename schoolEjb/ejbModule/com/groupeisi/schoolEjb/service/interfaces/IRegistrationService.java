package com.groupeisi.schoolEjb.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.groupeisi.schoolEjb.data.dto.RegistrationDto;
import com.groupeisi.schoolEjb.data.entities.RegistrationModel;

@Local
public interface IRegistrationService {

	List<RegistrationModel> list();

	RegistrationModel create(RegistrationDto registrationData);

	RegistrationModel update(int id, RegistrationDto registrationData);

	RegistrationModel get(int id);
}
