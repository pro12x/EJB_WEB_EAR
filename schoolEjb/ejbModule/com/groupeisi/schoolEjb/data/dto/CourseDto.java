package com.groupeisi.schoolEjb.data.dto;

import java.util.Map;

import com.groupeisi.schoolEjb.data.entities.CourseModel;

public class CourseDto {

	private String name;

	private String program;

	public CourseDto() {}

	public CourseDto(Map<String, String[]> parameters) {
		this.name = parameters.get("name")[0];
		this.program = parameters.get("program")[0];
	}

	public CourseModel toModel(CourseModel model) {
		model.setName(name);
		model.setProgram(program);
		return model;
	}
}
