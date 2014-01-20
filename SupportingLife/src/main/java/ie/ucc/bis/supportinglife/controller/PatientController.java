package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.controller.interfaces.PatientControllerInf;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
		
	/**
	 * Returns the requested patient record (JSON Request)
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody CcmPatient getPatientForAndroid(@PathVariable("id") long id) {
		return supportingLifeService.getPatientById(id);
	}
		
	/**
	 * Adds the patient record (JSON Request)
	 * 
	 * @param patient
	 * @param result
	 * @param response
	 * 
	 * @return @ResponseBody
	 * @throws BindException 
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST,  produces={"application/json"}, consumes={"application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody CcmPatient addPatientForAndroid(@Valid @RequestBody CcmPatient patient, BindingResult result) throws BindException {
		if(result.hasErrors()) {
			throw new BindException(result);
		}
		
		supportingLifeService.addPatient(patient);
		return patient;
	}	
} // end of class