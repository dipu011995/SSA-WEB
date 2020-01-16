package com.pk.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/**
 * This is PersonDetails Model Class
 * @author Pankaj Kumar
 *
 */
@Data
public class PersonDetails {

	private Integer pid;
	private String fname;
	private String lname;
	private String email;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dob;
	private String gender;
	private Long adharNo;
	
}
