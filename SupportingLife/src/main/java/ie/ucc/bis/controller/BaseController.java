package ie.ucc.bis.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/test")
public class BaseController {
	
	Logger log = Logger.getLogger(BaseController.class); 
	
	@RequestMapping(value="/greeting", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Supporting LIFE - Welcome");
		
		// Spring uses InternalResourceViewResolver and returns back welcome.jsp
		return"welcome";
	}
	
	@RequestMapping(value="/greeting/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		log.info("GET API called for name : " + name);
		
		model.addAttribute("message", "Supporting LIFE - Welcome " + name);

		// Spring uses InternalResourceViewResolver and returns back welcome.jsp
		return"welcome";		
	}	
}