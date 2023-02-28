package com.groupeisi.schoolEjb.data.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CourseModel
 *
 */
@Entity
@Table(name="courses")
public class CourseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String program;

	public CourseModel() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getProgram() {
		return this.program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseModel other = (CourseModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	
}
