package com.pk.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.domain.EducationDetails;
import com.pk.domain.PersonDetails;
import com.pk.entity.EducationalDetailsEntity;
import com.pk.entity.PassportAppDetailsEntity;
import com.pk.entity.PersonDetailsEntity;
import com.pk.repositeries.EducationalDetailsRepositeries;
import com.pk.repositeries.HighestDegreeRepositeries;
import com.pk.repositeries.PassportRepositeries;
import com.pk.repositeries.PersonDetailsRepositeries;
import com.pk.repositeries.UniversityRepositeries;
import com.pk.repositeries.YearRepositeries;
/**
 * This is PassportMgmtServiceImpl Class
 * @author Pankaj Kumar
 *
 */
@Service
public class PassportMgmtServiceImpl implements PassportMgmtService {

	@Autowired
	private PersonDetailsRepositeries personRepositeries;
	
	@Autowired
	private HighestDegreeRepositeries degreeRepositeries;
	
	@Autowired
	private UniversityRepositeries univerRepositeries;
	
	@Autowired
	private YearRepositeries yearRepositeries;
	
	@Autowired
	private EducationalDetailsRepositeries eduRepositeries;
	
	@Autowired
	private PassportRepositeries passportRepositeries;
	
	/**
	 * This method is to save PersonDetails
	 */
	@Override
	public int savePrsnDtlsForPassport(PersonDetails perDtls) {
		
		PersonDetailsEntity perEntity = new PersonDetailsEntity();
		
		BeanUtils.copyProperties(perDtls, perEntity);
		
		 java.sql.Date sqlDobDate = new java.sql.Date(perDtls.getDob().getTime());
		 
		 perEntity.setDob(sqlDobDate);
		
		PersonDetailsEntity savePerEntity = personRepositeries.save(perEntity);
		
		return savePerEntity.getPid();
	}

	/**
	 * This Method is to get All Degrees from DEGREE_MASTER table
	 */
	@Override
	public List<String> getAllDegree() {
		return degreeRepositeries.findAllDegrees();
	}

	/**
	 * This Method is to get All Degrees from UNIVERSITY_MASTER table
	 */
	@Override
	public List<String> getAllUniversity() {
		return univerRepositeries.findAllUniversitiesNames();
	}

	/**
	 * This Method is to get All Degrees from YEAR_MASTER table
	 */
	@Override
	public List<String> getAllPassoutYear() {
		return yearRepositeries.findAllpassoutYears();
	}
	
	/**
	 * This method retrive PersonDetails By Id
	 */
	@Override
	public PersonDetails getPersonDetailsById(Integer pid) {
		PersonDetailsEntity personEntity =null;
		
		Optional<PersonDetailsEntity> optEntity = personRepositeries.findById(pid);
		
		if(optEntity!= null) {
			personEntity = optEntity.get();
		}
		
		PersonDetails personDetails = new PersonDetails();
		
		BeanUtils.copyProperties(personEntity, personDetails);
		
		return personDetails;
	}

	/**
	 * This Method save the Education Details
	 */
	@Override
	public int saveEducationDetails(EducationDetails eduDetails) {
		
		EducationalDetailsEntity eduEntity = new EducationalDetailsEntity();
		
		BeanUtils.copyProperties(eduDetails, eduEntity);
		
		EducationalDetailsEntity saveEduEntity = eduRepositeries.save(eduEntity);
		
		return saveEduEntity.getEid();
	}

	/**
	 * This Method Is to get Education Details By Id
	 */
	@Override
	public EducationDetails getEducationalDetailsById(Integer eduId) {
		
		EducationalDetailsEntity  eduEntity = null;
		
		Optional<EducationalDetailsEntity> optEntity = eduRepositeries.findById(eduId);
	
		if(optEntity!=null) {
			eduEntity = optEntity.get();
		}		
		EducationDetails eduDetails = new EducationDetails();
		BeanUtils.copyProperties(eduEntity, eduDetails);
		return eduDetails;
	}
	
	/**
	 * This Methos is to get PassportDetails by pId
	 */
	@Override
	public PassportAppDetailsEntity savePasspostDetails(Integer pid) {
		
		PassportAppDetailsEntity passEntity = new PassportAppDetailsEntity();
		
		passEntity.setPassportNumber(generatePassportNumber());
		passEntity.setPid(pid);
		
		passportRepositeries.save(passEntity);
		
		return null;
	}
	
	/**
	 * This Method is to generate Random Number
	 * @return
	 */
	public  String generatePassportNumber() {
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'a');
		int aNumber = 0;
		aNumber = (int)((Math.random() * 9000000)+1000000);
		return c+""+aNumber;
	}
}
