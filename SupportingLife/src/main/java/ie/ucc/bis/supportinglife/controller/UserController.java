package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.communication.UserAuthenticationComms;
import ie.ucc.bis.supportinglife.controller.interfaces.UserControllerInf;
import ie.ucc.bis.supportinglife.form.UserCreationForm;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/user")
public class UserController implements UserControllerInf {

	private static final String FORM_PREFIX = "sl_";
	Logger log = Logger.getLogger(UserController.class); 
	
	@Autowired
	private SupportingLifeServiceInf supportingLifeService;

	/**
	 * Default Constructor
	 * 
	 */
	public UserController() {}	
	
	/**
	 * Constructor
	 * 
	 * @param supportingLifeService
	 */
	public UserController(SupportingLifeService supportingLifeService) {
		this.supportingLifeService = supportingLifeService;
	}
	
	/**
	 * Attempts to register a user (JSON Request)
	 *  - Will initially check their login details authenticate
	 * 
	 * @param UserAuthenticationComms
	 * 
	 * @return @ResponseBody
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST,  produces={"application/json"}, consumes={"application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Boolean registerUser(@RequestBody UserAuthenticationComms userDetails) {

		// TODO Record the deviceId associated with the user if their details are authenticated
		Boolean registrationResponse = supportingLifeService.registerUser(userDetails);
		return registrationResponse;
	}
	
	/**
	 * Returns the user creation form
	 * 
	 * @return @ResponseBody
	 */
	@RequestMapping(value="/create_user_form", method=RequestMethod.GET, headers="Accept=html/text")
	public String displayUserForm(ModelMap model) {
		final String reportName = "create_user_form";
		
		log.info("Display User Creation Form " + reportName);
		
		UserCreationForm userCreationForm = new UserCreationForm();
		
		model.addAttribute("userCreationForm", userCreationForm);
		
		// Spring uses InternalResourceViewResolver and returns back report criteria jsp
		return FORM_PREFIX + reportName;		
	}
		
	/**
	 * Creates a user account
	 * 
	 * @param User
	 * 
	 * @return @ResponseBody
	 */
	@RequestMapping(value="/create", method=RequestMethod.POST, headers="Accept=html/text")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void createUser(@ModelAttribute("userCreationFormBean") UserCreationForm userCreationFormBean, Model model) {
		supportingLifeService.createUser(userCreationFormBean);
	}
	
} // end of class