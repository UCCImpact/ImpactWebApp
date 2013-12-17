package ie.ucc.bis.controller;

import ie.ucc.bis.controller.interfaces.PatientControllerInf;
import ie.ucc.bis.domain.Patient;
import ie.ucc.bis.service.SupportingLifeService;
import ie.ucc.bis.service.SupportingLifeServiceInf;

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
	public PatientController() {
	}	
	
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
		List<Patient> patients = supportingLifeService.getAllPatients();
//		List<Patient> patients = new ArrayList<Patient>();

		//*********** FOR DEBUGGING FROM LOCAL TOMCAT SERVER ****************// 
//		java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://myslinstance.ckaovsq8slyk.eu-west-1.rds.amazonaws.com:3306/supportinglifedb",
//				"supporting_user", "supporting_pw_14");
		//********************************************************************//
		
		
//		java.sql.Connection connection = DriverManager.getConnection(System.getProperty("JDBC_CONNECTION_STRING"),
//				System.getProperty("AWS_ACCESS_KEY_ID"), System.getProperty("AWS_SECRET_KEY"));
//		
//		
//		java.sql.PreparedStatement s = connection.prepareStatement("SELECT * FROM Patient;");     
//		ResultSet rs = s.executeQuery();
//
//		while (rs.next()) {
//		    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
//		    patients.add(new Patient(rs.getString(2), rs.getString(3)));
//		}
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
		List<Patient> patients = supportingLifeService.getAllPatientsByFirstName(firstName);
		
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
	public @ResponseBody Patient getPatientForAndroid(@PathVariable("id") long id) {
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
	public @ResponseBody Patient addPatientForAndroid(@Valid @RequestBody Patient patient, BindingResult result) throws BindException {
		if(result.hasErrors()) {
			throw new BindException(result);
		}
		
		supportingLifeService.addPatient(patient);
		return patient;
	}	
} // end of class