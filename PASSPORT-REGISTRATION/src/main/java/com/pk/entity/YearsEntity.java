package com.pk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * This is YearsEntity Class
 * @author Pankaj Kumar
 *
 */
@Data
@Entity
@Table(name = "YEARS_MASTER")
public class YearsEntity {
	
	@Id
	@Column(name = "YEAR_ID")
	private Integer yearId;
	
	@Column(name = "YEAR")
	private String year;

}
