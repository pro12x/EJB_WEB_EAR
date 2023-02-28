package com.groupeisi.schoolEjb.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.groupeisi.schoolEjb.data.dto.SchoolYearDto;
import com.groupeisi.schoolEjb.data.entities.SchoolYearModel;

@Local
public interface ISchoolYearService {

	List<SchoolYearModel> list();

	SchoolYearModel create(SchoolYearDto schoolYearData);

	SchoolYearModel update(int id, SchoolYearDto schoolYearData);

	SchoolYearModel get(int id);
}
