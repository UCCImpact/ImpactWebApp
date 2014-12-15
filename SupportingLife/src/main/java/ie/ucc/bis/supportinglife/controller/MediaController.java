package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.controller.interfaces.MediaControllerInf;
import ie.ucc.bis.supportinglife.form.NewsEntryCreationForm;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/media")
public class MediaController implements MediaControllerInf {

	private static final String FORM_PREFIX = "sl_";
	Logger log = Logger.getLogger(MediaController.class); 
	
	@Autowired
	private SupportingLifeServiceInf supportingLifeService;

	/**
	 * Default Constructor
	 * 
	 */
	public MediaController() {}	
	
	/**
	 * Constructor
	 * 
	 * @param supportingLifeService
	 */
	public MediaController(SupportingLifeService supportingLifeService) {
		this.supportingLifeService = supportingLifeService;
	}
	
	
	/**
	 * Returns the media news entry creation form
	 * 
	 * @return @ResponseBody
	 */
	@Override
	@RequestMapping(value="/create_news_entry_form", method=RequestMethod.GET, headers="Accept=html/text")
	public String displayUserForm(@RequestParam(required=false) Boolean newsEntryCreated, ModelMap model) {
		final String reportName = "create_news_entry_form";
		
		log.info("Display News Entry Creation Form " + reportName);
		
		NewsEntryCreationForm newsEntryCreationForm = new NewsEntryCreationForm();
		model.addAttribute("newsEntryCreationForm", newsEntryCreationForm);
		
		if(newsEntryCreated != null && newsEntryCreated) {
			model.addAttribute("newsEntryCreated", true);
		}
		
		// Spring uses InternalResourceViewResolver and returns back report criteria jsp
		return FORM_PREFIX + reportName;
	}
		
	/**
	 * Creates a news entry
	 * 
	 * @param User
	 * 
	 * @return @ResponseBody
	 */
	@Override
	@RequestMapping(value="/create_news_entry", method=RequestMethod.POST, headers="Accept=html/text")
	public ModelAndView createNewsEntry(@ModelAttribute("newsEntry") NewsEntryCreationForm newsEntryCreationForm, ModelMap model) {		
		supportingLifeService.createNewsEntry(newsEntryCreationForm);
		
		// redirect and flag that a new news entry has been successfully recorded
		return new ModelAndView("redirect:/media/create_news_entry_form?newsEntryCreated=true");
	}
	
	/**
	 * Displays all news items
	 * 
	 * @return String
	 */
	@RequestMapping(value="/news", method = RequestMethod.GET, headers="Accept=html/text")
	public ModelAndView displayNewsItems(ModelMap model) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("newsItems", supportingLifeService.getNewsItems());
		// pull back the news items
//		model.addAttribute("newsItems", supportingLifeService.getNewsItems());
	
		// Spring uses InternalResourceViewResolver and returns back sl_news.jsp
//		return"sl_news";
		mav.setViewName("sl_news");
		return mav;
	}
} // end of class