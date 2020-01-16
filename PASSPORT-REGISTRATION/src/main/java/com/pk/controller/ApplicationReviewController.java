package com.pk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pk.domain.EducationDetails;
import com.pk.domain.PassportDetails;
import com.pk.domain.PersonDetails;
import com.pk.service.PassportMgmtService;

/**
 * This Is ApplicationReviewController class
 * 
 * @author Pankaj Kumar
 *
 */
@Controller
public class ApplicationReviewController {

	@Autowired
	private PassportMgmtService passportService;

	/**
	 * This is displayApplicationReviewForm method .This method Display the
	 * application_review Form
	 * 
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/appReview")
	public String displayApplicationReviewForm(HttpServletRequest req, Model model) {

		int educationId = Integer.parseInt(req.getParameter("eduId"));

		EducationDetails eduDetails = passportService.getEducationalDetailsById(educationId);

		PersonDetails perDetails = passportService.getPersonDetailsById(eduDetails.getPid());

		PassportDetails passportDetails = new PassportDetails();

		BeanUtils.copyProperties(eduDetails, passportDetails);
		BeanUtils.copyProperties(perDetails, passportDetails);

		model.addAttribute("passportDetails", passportDetails);
		return "application_review";
	}

}
