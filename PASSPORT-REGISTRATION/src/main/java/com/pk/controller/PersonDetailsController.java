package com.pk.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pk.domain.PersonDetails;
import com.pk.service.PassportMgmtService;

/**
 * This is PersonDetailsController class
 * 
 * @author Pankaj Kumar
 *
 */
@Controller
public class PersonDetailsController {

	@Autowired
	PassportMgmtService passportService;

	/**
	 * This method is to display person_details Form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/")
	public String displayPersonDetailsForm(Model model) {

		PersonDetails pernDetails = new PersonDetails();
		model.addAttribute("personDetails", pernDetails);

		return "person_details";
	}

	/**
	 * This Method is to save Person details
	 * 
	 * @param perDtls
	 * @param model
	 * @param req
	 * @return
	 * @throws ParseException
	 */
	@PostMapping(value = "/savePerson")
	public String hndlSubmitButton(@ModelAttribute("personDetails") PersonDetails perDtls, Model model,
			HttpServletRequest req) throws ParseException {

		int pid = passportService.savePrsnDtlsForPassport(perDtls);

		return "redirect:/eduDetails?pid=" + pid;
	}

}
