package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.controller.interfaces.ReportControllerInf;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;
import ie.ucc.bis.supportinglife.service.helper.SupportingLifeRefDataHelperInf;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/reports")
public class ReportController implements ReportControllerInf {

	@Autowired
	private SupportingLifeServiceInf supportingLifeService;
	@Autowired
	private SupportingLifeRefDataHelperInf SupportingLifeRefDataHelper;
	
	// TODO Move to Separate bean
	private static final String REPORT_PREFIX = "sl_";

	Logger log = Logger.getLogger(ReportController.class); 
	
	/**
	 * Default Constructor
	 * 
	 */
	public ReportController() {
	}	
	
	/**
	 * Constructor
	 * 
	 * @param supportingLifeService
	 */
	public ReportController(SupportingLifeService supportingLifeService) {
		this.supportingLifeService = supportingLifeService;
	}
	
	/**
	 * Returns the selection criteria for the CCM Custom Report
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/ccm_custom_report", method=RequestMethod.GET, headers="Accept=html/text")
	public String getCcmCustomReportSelectionCriteria(ModelMap model) {
		final String reportName = "ccm_custom_report";
		
		log.info("GET API called for report: " + reportName);
		
		model.addAttribute("askLookSymptoms", SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getAskLookSymptoms());
		model.addAttribute("classifications", SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getClassifications());
		model.addAttribute("classificationTypes", SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getClassificationTypes());
		
		// Spring uses InternalResourceViewResolver and returns back report criteria jsp
		return REPORT_PREFIX + reportName;		
	}
	
} // end of class