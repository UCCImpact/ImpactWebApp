package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.controller.interfaces.UserAuthenticationControllerInf;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;
import ie.ucc.bis.supportinglife.service.helper.SupportingLifeRefDataHelperInf;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class UserAuthenticationController implements UserAuthenticationControllerInf {

	private static final String AUTHENTICATION_PAGE_PREFIX = "sl_";
	
	@Autowired
	private SupportingLifeServiceInf supportingLifeService;
	@Autowired
	private SupportingLifeRefDataHelperInf SupportingLifeRefDataHelper;

	/**
	 * Default Constructor
	 * 
	 */
	public UserAuthenticationController() {}	
	
	/**
	 * Constructor
	 * 
	 * @param supportingLifeService
	 */
	public UserAuthenticationController(SupportingLifeService supportingLifeService) {
		this.supportingLifeService = supportingLifeService;
	}
	

	/**
	 * Display Login Form
	 * 
	 * @param model
	 * @return
	 * @throws SQLException 
	 */
	@Override
	@RequestMapping(method = RequestMethod.GET, headers="Accept=html/text")
	public String displayLoginPage(ModelMap model) throws SQLException {
		
		// Spring uses InternalResourceViewResolver and returns back sl_login.jsp
		return AUTHENTICATION_PAGE_PREFIX + "login";
	}
} // end of class