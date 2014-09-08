package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.communication.PersonContactComms;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;
import ie.ucc.bis.supportinglife.service.helper.SupportingLifeRefDataHelperInf;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/welcome")
public class BaseController {
	
	@Autowired
	private SupportingLifeServiceInf supportingLifeService;
	
	@Autowired
	private SupportingLifeRefDataHelperInf SupportingLifeRefDataHelper;
	
	Logger log = Logger.getLogger(BaseController.class); 
	
	@RequestMapping(method = RequestMethod.GET, headers="Accept=html/text")
	public String welcome(ModelMap model) {
		
		// pull back the team members detail for the welcome page
		model.addAttribute("teamMembers", SupportingLifeRefDataHelper.getTeamMembers());
	
		// Spring uses InternalResourceViewResolver and returns back welcome.jsp
		return"sl_welcome";
	}
	
	/**
	 * Adds a person's contact details who has expressed a contact interest
	 * on the main SL landing page
	 * 
	 * @param PersonContactComms
	 * 
	 * @return @ResponseBody
	 */
	@RequestMapping(value="/addPersonContact", method=RequestMethod.POST, produces={"application/json"}, consumes={"application/json"})
	@ResponseBody //this will parse the returned Object to JSONØ
	public Boolean addPersonContact(@RequestBody PersonContactComms personContact) {
		supportingLifeService.addPersonContact(personContact);
		return true;
	}
	
	/**
	 * Adds a person's email address to the newsletter email list of contacts
	 * 
	 * @param String
	 * 
	 * @return @ResponseBody
	 */
	@RequestMapping(value="/addNewsletterContact", method=RequestMethod.POST, produces={"application/json"}, consumes={"application/json"})
	@ResponseBody //this will parse the returned Object to JSONØ
	public Boolean addNewsletterContact(@RequestBody String emailAddress) {
		supportingLifeService.addNewsletterContact(emailAddress);
		return true;
	}
	
	/**
	 * Directs user to SL infographic display
	 * 
	 * @param String
	 * 
	 * @return @ResponseBody
	 */
	@RequestMapping(value="/infographic", method = RequestMethod.GET, headers="Accept=html/text")
	public String displayInfographic(ModelMap model) {
	
		return"sl_about_infographic";
	}
	
}