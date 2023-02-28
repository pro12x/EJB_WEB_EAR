package com.groupeisi.schoolEjb.data.dto;

import java.time.LocalDate;
import java.util.Map;

import com.groupeisi.schoolEjb.data.entities.StudentModel;

public class StudentDto {

	private String firstName;

	private String lastName;

	private LocalDate birthdate;

	private String phone;

	public StudentDto() {}

	public StudentDto(Map<String, String[]> parameters) {
		this.firstName = parameters.get("firstName")[0];
		this.lastName = parameters.get("lastName")[0];
		this.phone = parameters.get("phone")[0];
		this.birthdate = LocalDate.parse(parameters.get("birthdate")[0]);
	}

	public StudentModel toModel(StudentModel model) {
		model.setFirstName(firstName);
		model.setLastName(lastName);
		model.setPhone(phone);
		model.setBirthdate(birthdate);
		return model;
	}
}
