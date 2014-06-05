package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.communication.UserAuthenticationComms;
import ie.ucc.bis.supportinglife.controller.interfaces.UserControllerInf;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/user")
public class UserController implements UserControllerInf {

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
	
} // end of class