package ie.ucc.bis.controller;

import ie.ucc.bis.controller.interfaces.PatientControllerInf;
import ie.ucc.bis.service.SupportingLifeService;
import ie.ucc.bis.service.SupportingLifeServiceInf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/patients")
public class PatientController implements PatientControllerInf {

	private SupportingLifeServiceInf supportingLifeService;

	/**
	 * Default Constructor
	 * 
	 */
	public PatientController() {
	}	
	
	/**
	 * Constructor
	 * 
	 * @param supportingLifeService
	 */
	@Autowired
	public PatientController(SupportingLifeService supportingLifeService) {
		this.supportingLifeService = supportingLifeService;
	}
	
	/**
	 * Returns the requested patient record
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getPatient(@PathVariable("id") long id, Model model) {
		model.addAttribute(supportingLifeService.getPatientById(id));
		
		return "patients";
		
	}

	
	
} // end of class

