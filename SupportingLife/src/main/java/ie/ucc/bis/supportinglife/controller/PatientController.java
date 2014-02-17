package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.controller.interfaces.PatientControllerInf;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/patients")
public class PatientController implements PatientControllerInf {

	@Autowired
	private SupportingLifeServiceInf supportingLifeService;

	/**
	 * Default Constructor
	 * 
	 */
	public PatientController() {}	
	
	/**
	 * Constructor
	 * 
	 * @param supportingLifeService
	 */
	public PatientController(SupportingLifeService supportingLifeService) {
		this.supportingLifeService = supportingLifeService;
	}
	
	/**
	 * Returns all patient records (HTTP Request)
	 * 
	 * 
	 * @param model
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(method = RequestMethod.GET, headers="Accept=html/text")
	public String getAllPatientsForBrowser(ModelMap model) throws SQLException {
		List<CcmPatient> patients = supportingLifeService.getAllPatients();
		
		model.addAttribute("patients", patients);
		
		// Spring uses InternalResourceViewResolver and returns back patients.jsp
		return"patients";
	}
	
	/**
	 * Returns the requested patient records 
	 * based on the patient's first name (HTTP Request)
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/search/{firstName}", method=RequestMethod.GET, headers="Accept=html/text")
	public String getAllPatientsByFirstName(@PathVariable String firstName, ModelMap model) {
		List<CcmPatient> patients = supportingLifeService.getAllPatientsByFirstName(firstName);
				
		model.addAttribute("patients", patients);
		
		// Spring uses InternalResourceViewResolver and returns back patients.jsp
		return "patients";		
	}	
} // end of class