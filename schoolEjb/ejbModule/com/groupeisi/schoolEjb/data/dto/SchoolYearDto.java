package com.groupeisi.schoolEjb.data.dto;

import java.util.Map;

import com.groupeisi.schoolEjb.data.entities.SchoolYearModel;

public class SchoolYearDto {

	private int startDate;

	private int endDate;

	public SchoolYearDto() {}

	public SchoolYearDto(Map<String, String[]> parameters) {
		this.startDate = Integer.parseInt(parameters.get("startDate")[0]);
		this.endDate = Integer.parseInt(parameters.get("endDate")[0]);
	}

	public SchoolYearModel toModel(SchoolYearModel model) {
		model.setStartDate(startDate);
		model.setEndDate(endDate);
		return model;
	}
}
