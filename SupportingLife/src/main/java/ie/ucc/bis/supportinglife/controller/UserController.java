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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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
	public String displayUserForm(@RequestParam(required=false) Boolean userCreated, ModelMap model) {
		final String reportName = "create_user_form";
		
		log.info("Display User Creation Form " + reportName);
		
		UserCreationForm userCreationForm = new UserCreationForm();
		model.addAttribute("userCreationForm", userCreationForm);
		
		if(userCreated != null && userCreated) {
			model.addAttribute("userCreated", true);
		}
		
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
	public ModelAndView createUser(@ModelAttribute("person") UserCreationForm userCreationFormBean, ModelMap model) {		
		supportingLifeService.createUser(userCreationFormBean);
		
		// redirect and flag that a new user has been successfully created
		return new ModelAndView("redirect:/user/create_user_form?userCreated=true");
	//	return "redirect:/user/create_user_form";
	}
	
	/**
	 * Check the existence of a User Id
	 * 
	 * @param model
	 * 
	 * @return Boolean
	 */
	@RequestMapping(value="/checkUserIdExistence", method=RequestMethod.POST, produces={"application/json"}, consumes={"application/json"})
	@ResponseBody
	public Boolean checkUserIdExistence(@RequestBody String username) {		
		log.info("Check User Id Availability");
		Boolean exists = supportingLifeService.checkUserIdExistence(username);
		return exists;		
	}
	
} // end of class