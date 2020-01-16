package com.pk.domain;

import java.util.Date;

import lombok.Data;
/**
 * This is PassportDetails Model class
 * @author Pankaj Kumar
 *
 */
@Data
public class PassportDetails {
	
	private  Integer passportId;
	private String passportNumber;
	private String fname;
	private String lname;
	private String email;
	private Date dob;
	private String gender;
	private Long adharNo;
	private String highestDegree;
	private String university;
	private Integer passoutYear;

}
