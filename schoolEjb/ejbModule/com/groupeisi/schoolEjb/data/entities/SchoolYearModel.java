package com.groupeisi.schoolEjb.data.entities;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

@Entity
@Table(name="schoolYears")
public class SchoolYearModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int startDate;

	private int endDate;

	public SchoolYearModel() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStartDate() {
		return this.startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return this.endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
}
