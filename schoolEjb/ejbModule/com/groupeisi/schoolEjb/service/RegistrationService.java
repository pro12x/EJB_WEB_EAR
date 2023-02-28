package com.groupeisi.schoolEjb.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.groupeisi.schoolEjb.data.dao.interfaces.ICourseDao;
import com.groupeisi.schoolEjb.data.dao.interfaces.IRegistrationDao;
import com.groupeisi.schoolEjb.data.dao.interfaces.ISchoolYearDao;
import com.groupeisi.schoolEjb.data.dao.interfaces.IStudentDao;
import com.groupeisi.schoolEjb.data.dto.RegistrationDto;
import com.groupeisi.schoolEjb.data.entities.RegistrationModel;
import com.groupeisi.schoolEjb.service.interfaces.IRegistrationService;

@Stateless
public class RegistrationService implements IRegistrationService {

	@EJB
	private IRegistrationDao registrationDao;

	@EJB
	private IStudentDao studentDao;

	@EJB
	private ICourseDao courseDao;

	@EJB
	private ISchoolYearDao schoolYearDao;

	@Override
	public List<RegistrationModel> list() {
		return this.registrationDao.list();
	}

	@Override
	public RegistrationModel create(RegistrationDto registrationData) {
		return this.registrationDao.add(registrationData.toModel(new RegistrationModel(), studentDao, schoolYearDao, courseDao));
	}

	@Override
	public RegistrationModel update(int id, RegistrationDto registrationData) {
		RegistrationModel registration = this.registrationDao.get(id);
		assert registration != null;

		return this.registrationDao.update(registrationData.toModel(registration, studentDao, schoolYearDao, courseDao));
	}

	@Override
	public RegistrationModel get(int id) {
		return this.registrationDao.get(id);
	}
}
