package com.pk.domain;

import lombok.Data;

/**
 * This is EducationDetails Model class
 * 
 * @author Pankaj Kumar
 *
 */
@Data
public class EducationDetails {

	private Integer eid;
	private String highestDegree;
	private String university;
	private Integer passoutYear;
	private Integer pid;

}
