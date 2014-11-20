package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.controller.interfaces.ReportControllerInf;
import ie.ucc.bis.supportinglife.form.CcmDemographicForm;
import ie.ucc.bis.supportinglife.form.CcmSymptomsClassificationsForm;
import ie.ucc.bis.supportinglife.form.CcmTreatmentForm;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;
import ie.ucc.bis.supportinglife.service.helper.SupportingLifeRefDataHelperInf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * Returns National Health Id's filtered according to the user's search term
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/getFilteredNationalHealthIds", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, List<String>> filterNationalHealthIds(@RequestParam String term) {		
		log.info("GET National Health IDs");

		Map<String, List<String>> results = new HashMap<String, List<String>>();
		List<String> nationalHealthIds = supportingLifeService.getAllPatientsByNationalHealthIdFilter(term);
	
		results.put("nationalHealthIds", nationalHealthIds);
		return results;		
	}
		
	/**
	 * Returns the CCM Report Form
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/ccm_custom_report_form", method=RequestMethod.GET, headers="Accept=html/text")
	public String getCcmReportSelectionCriteria(ModelMap model) {
		final String reportName = "ccm_custom_report";
		
		log.info("GET form page for report: " + reportName);
		
		// Spring uses InternalResourceViewResolver and returns back report criteria jsp
		return REPORT_PREFIX + reportName;		
	}
	
	/**
	 * Returns the selection criteria for the CCM Demographic Report
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/ccm_demographic_report_form", method=RequestMethod.GET, headers="Accept=html/text")
	public String getCcmDemographicReportSelectionCriteria(ModelMap model) {
		final String reportName = "ccm_demographic_report";
		
		log.info("GET form page for report: " + reportName);
		
		CcmDemographicForm ccmDemographicForm = new CcmDemographicForm();
		
		model.addAttribute("ccmDemographicFormBean", ccmDemographicForm);
		// Spring uses InternalResourceViewResolver and returns back report criteria jsp
		return REPORT_PREFIX + reportName;		
	}
	
	/**
	 * Returns the selection criteria for the CCM Symptom / Classification Report
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/ccm_symptom_classification_report_form", method=RequestMethod.GET, headers="Accept=html/text")
	public String getCcmSymptomsClassificationsReportSelectionCriteria(ModelMap model) {
		final String reportName = "ccm_symptom_classification_report";
		
		log.info("GET form page for report: " + reportName);
		
		CcmSymptomsClassificationsForm ccmSymptomsClassificationsForm = new CcmSymptomsClassificationsForm();
		ccmSymptomsClassificationsForm.setLookSymptoms(SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getLookSymptoms());
		ccmSymptomsClassificationsForm.setAskLookSymptoms(SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getAskLookSymptoms());
		ccmSymptomsClassificationsForm.setClassifications(SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getClassifications());
		
		model.addAttribute("ccmSymptomsClassificationsFormBean", ccmSymptomsClassificationsForm);
		// Spring uses InternalResourceViewResolver and returns back report criteria jsp
		return REPORT_PREFIX + reportName;		
	}
	
	/**
	 * Returns the selection criteria for the CCM Treatment Report
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/ccm_treatment_report_form", method=RequestMethod.GET, headers="Accept=html/text")
	public String getCcmTreatmentReportSelectionCriteria(ModelMap model) {
		final String reportName = "ccm_treatment_report";
		
		log.info("GET form page for report: " + reportName);
		
		CcmTreatmentForm ccmTreatmentForm = new CcmTreatmentForm();
		ccmTreatmentForm.setTreatments(SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getTreatments());
		
		model.addAttribute("ccmTreatmentFormBean", ccmTreatmentForm);
		// Spring uses InternalResourceViewResolver and returns back report criteria jsp
		return REPORT_PREFIX + reportName;		
	}
		
	/**
	 * Returns the resultset for the CCM Demographic Report
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/ccm_demographic_report", method=RequestMethod.POST, headers="Accept=html/text")
	public String getCcmDemographicReport(@ModelAttribute("ccmDemographicFormBean") CcmDemographicForm ccmDemographicForm, Model model) {
		final String reportName = "ccm_demographic_report";
			
		log.info("GET resultset for report: " + reportName);
		log.info("CCM Demographic Form: " + ccmDemographicForm.toString());

		// 1. pull back all patient visits which meet the demographic criteria
		List<CcmPatientVisit> patientVisits = 
				supportingLifeService.getPatientVisits(ccmDemographicForm.getPatientId(),
													   ccmDemographicForm.getNationalId(),
													   ccmDemographicForm.getNationalHealthId(),
													   ccmDemographicForm.getHsaUserId(),
													   ccmDemographicForm.getAssessmentDateFrom(),
													   ccmDemographicForm.getAssessmentDateTo());
		model.addAttribute("patientVisits", patientVisits);
        return REPORT_PREFIX + "ccm_report_results";
	}
	

	/**
	 * Returns the resultset for the CCM Symptom / Classification Report
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/ccm_symptom_classification_report", method=RequestMethod.POST, headers="Accept=html/text")
	public String getCcmSymptomClassificationReport(CcmSymptomsClassificationsForm ccmSymptomsClassificationsForm, Model model) {
		final String reportName = "ccm_symptom_classification_report";
		
		log.info("GET resultset for report: " + reportName);	
		log.info("CCM Symptom / Classification Form: " + ccmSymptomsClassificationsForm.toString());

		// 1. pull back all patient visits which meet the symptoms / classifications criteria
		List<CcmPatientVisit> patientVisits = 
				supportingLifeService.getPatientVisits(ccmSymptomsClassificationsForm.getLookSymptoms(),
													   ccmSymptomsClassificationsForm.getAskLookSymptoms(),
													   ccmSymptomsClassificationsForm.getClassifications());	
		model.addAttribute("patientVisits", patientVisits);
        return REPORT_PREFIX + "ccm_report_results";
	}
	
	/**
	 * Returns the resultset for the CCM Treatment Report
	 * 
	 * @param model
	 * 
	 * @return String
	 */
	@RequestMapping(value="/ccm_treatment_report", method=RequestMethod.POST, headers="Accept=html/text")
	public String getCcmTreatmentReport(CcmTreatmentForm ccmTreatmentForm, Model model) {
		final String reportName = "ccm_treatment_report";
		
		log.info("GET resultset for report: " + reportName);
		log.info("CCM Treatment Form: " + ccmTreatmentForm.toString());

		// 1. pull back all patient visits which meet the treatments criteria
		List<CcmPatientVisit> patientVisits = 
				supportingLifeService.getPatientVisits(ccmTreatmentForm.getTreatments());
		
		model.addAttribute("patientVisits", patientVisits);
        return REPORT_PREFIX + "ccm_report_results";
	}
} // end of class