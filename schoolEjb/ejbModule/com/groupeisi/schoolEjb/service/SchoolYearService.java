package com.groupeisi.schoolEjb.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.groupeisi.schoolEjb.data.dao.interfaces.ISchoolYearDao;
import com.groupeisi.schoolEjb.data.dto.SchoolYearDto;
import com.groupeisi.schoolEjb.data.entities.SchoolYearModel;
import com.groupeisi.schoolEjb.service.interfaces.ISchoolYearService;

@Stateless
public class SchoolYearService implements ISchoolYearService {

	@EJB
	private ISchoolYearDao schoolYearDao;

	@Override
	public List<SchoolYearModel> list() {
		return this.schoolYearDao.list();
	}

	@Override
	public SchoolYearModel create(SchoolYearDto schoolYearData) {
		return this.schoolYearDao.add(schoolYearData.toModel(new SchoolYearModel()));
	}

	@Override
	public SchoolYearModel update(int id, SchoolYearDto schoolYearData) {
		SchoolYearModel schoolYear = this.schoolYearDao.get(id);
		assert schoolYear != null;

		return this.schoolYearDao.update(schoolYearData.toModel(schoolYear));
	}

	@Override
	public SchoolYearModel get(int id) {
		return this.schoolYearDao.get(id);
	}
}
