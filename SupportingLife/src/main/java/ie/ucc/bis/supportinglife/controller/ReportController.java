package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.controller.interfaces.ReportControllerInf;
import ie.ucc.bis.supportinglife.report.form.CcmCustomForm;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;
import ie.ucc.bis.supportinglife.service.helper.SupportingLifeRefDataHelperInf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	 * Specify to the Controller the format which it will receive
	 * dates
	 * 
	 * @param webDataBinder
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	
	/**
	 * Returns the selection criteria for the CCM Custom Report
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/ccm_custom_report_form", method=RequestMethod.GET, headers="Accept=html/text")
	public String getCcmCustomReportSelectionCriteria(ModelMap model) {
		final String reportName = "ccm_custom_report";
		
		log.info("GET form page for report: " + reportName);
		
		CcmCustomForm ccmCustomForm = new CcmCustomForm();
		ccmCustomForm.setLookSymptoms(SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getLookSymptoms());
		ccmCustomForm.setAskLookSymptoms(SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getAskLookSymptoms());
		ccmCustomForm.setClassifications(SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getClassifications());
		ccmCustomForm.setTreatments(SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getTreatments());
		
		model.addAttribute("ccmCustomFormBean", ccmCustomForm);
		
		// Spring uses InternalResourceViewResolver and returns back report criteria jsp
		return REPORT_PREFIX + reportName;		
	}
	
	/**
	 * Returns the resultset for the CCM Custom Report
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/ccm_custom_report", method=RequestMethod.POST, headers="Accept=html/text")
	public String getCcmCustomReport(@ModelAttribute("ccmCustomFormBean") CcmCustomForm ccmCustomForm, Model model) {
		final String reportName = "ccm_custom_report";
			
		log.info("GET resultset for report: " + reportName);
		
		log.info("CCM Custom Form: " + ccmCustomForm.toString());

		// 1. pull back all patient visits which meet the criteria
		List<CcmPatientVisit> patientVisits = 
				supportingLifeService.getPatientVisits(ccmCustomForm.getPatientId(),
													   ccmCustomForm.getNationalId(),
													   ccmCustomForm.getNationalHealthId(),
													   ccmCustomForm.getHsaUserId(),
													   ccmCustomForm.getAssessmentDateFrom(),
													   ccmCustomForm.getAssessmentDateTo(),
													   ccmCustomForm.getLookSymptoms(),
													   ccmCustomForm.getAskLookSymptoms(),
													   ccmCustomForm.getClassifications(),
													   ccmCustomForm.getTreatments());
		
		
		model.addAttribute("patientVisits", patientVisits);
		
        return REPORT_PREFIX + "ccm_report_results";
	}
	
} // end of class