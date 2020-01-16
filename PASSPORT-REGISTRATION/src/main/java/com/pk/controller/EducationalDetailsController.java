package com.pk.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pk.domain.EducationDetails;
import com.pk.domain.PersonDetails;
import com.pk.service.PassportMgmtService;

/**
 * This is EducationalDetailsController class
 * 
 * @author Pankaj Kumar
 *
 */
@Controller
public class EducationalDetailsController {

	@Autowired
	private PassportMgmtService service;

	/**
	 * This method display educational_details form With all drop downs
	 * 
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/eduDetails")
	public String displayEducationalDetails(HttpServletRequest req, Model model) {

		int pid = Integer.parseInt(req.getParameter("pid"));

		EducationDetails eduDetails = new EducationDetails();
		eduDetails.setPid(pid);

		List<String> degreeList = service.getAllDegree();
		model.addAttribute("degreeList", degreeList);

		List<String> universityList = service.getAllUniversity();
		model.addAttribute("unvrList", universityList);

		List<String> passoutYearList = service.getAllPassoutYear();
		model.addAttribute("yearList", passoutYearList);

		model.addAttribute("educationalDetails", eduDetails);

		return "educational_details";
	}

	/**
	 * This method is to handel submit button
	 * 
	 * @param eduDetails
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/saveEduDtls")
	public String handelSubmitButton(@ModelAttribute("educationalDetails") EducationDetails eduDetails, Model model) {

		int educationId = service.saveEducationDetails(eduDetails);

		return "redirect:/appReview?eduId=" + educationId;
	}

	/**
	 * This Method is to handle previous button
	 * 
	 * @param req
	 * @param model
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/editPersonDtls", method = RequestMethod.GET)
	public String editPersonDetails(HttpServletRequest req, Model model) throws ParseException {
		int personId = Integer.parseInt(req.getParameter("perId"));

		PersonDetails persnDtls = service.getPersonDetailsById(personId);

		java.util.Date dobUtilDate = new java.util.Date(persnDtls.getDob().getTime());

		SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");

		String format = sm.format(dobUtilDate);

		Date date = sm.parse(format);

		model.addAttribute("personDetails", persnDtls);

		return "person_details";

	}
}
