package com.pk.service;

import java.util.List;

import com.pk.domain.EducationDetails;
import com.pk.domain.PersonDetails;
import com.pk.entity.PassportAppDetailsEntity;

public interface PassportMgmtService {
	
	public int savePrsnDtlsForPassport(PersonDetails perDtls);
	
	public List<String> getAllDegree();
	
	public List<String> getAllUniversity();
	
	public List<String> getAllPassoutYear();
	
	public PersonDetails getPersonDetailsById(Integer pid);
	
	public int saveEducationDetails(EducationDetails eduDetails);
	
	public EducationDetails getEducationalDetailsById(Integer pid);
	
	public PassportAppDetailsEntity savePasspostDetails(Integer pid);
	
}
