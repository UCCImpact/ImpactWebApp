package ie.ucc.bis.controller;

import ie.ucc.bis.controller.interfaces.PatientControllerInf;
import ie.ucc.bis.domain.Patient;
import ie.ucc.bis.service.SupportingLifeService;
import ie.ucc.bis.service.SupportingLifeServiceInf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value="/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody Patient getPatientForAndroid(@PathVariable("id") long id) {
		return supportingLifeService.getPatientById(id);
	}
} // end of class

