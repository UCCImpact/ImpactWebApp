package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.service.helper.SupportingLifeRefDataHelperInf;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/welcome")
public class BaseController {
	
	@Autowired
	private SupportingLifeRefDataHelperInf SupportingLifeRefDataHelper;
	
	Logger log = Logger.getLogger(BaseController.class); 
	
	@RequestMapping(method = RequestMethod.GET, headers="Accept=html/text")
	public String welcome(ModelMap model) {
	
		// Spring uses InternalResourceViewResolver and returns back welcome.jsp
		return"sl_welcome";
	}
}