package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.communication.PatientAssessmentComms;
import ie.ucc.bis.supportinglife.controller.interfaces.PatientVisitControllerInf;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/patientvisits")
public class PatientVisitController implements PatientVisitControllerInf {

	@Autowired
	private SupportingLifeServiceInf supportingLifeService;

	/**
	 * Default Constructor
	 * 
	 */
	public PatientVisitController() {}	
	
	/**
	 * Constructor
	 * 
	 * @param supportingLifeService
	 */
	public PatientVisitController(SupportingLifeService supportingLifeService) {
		this.supportingLifeService = supportingLifeService;
	}
	
	/**
	 * Returns all patient visit records (HTTP Request)
	 * 
	 * 
	 * @param model
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(method = RequestMethod.GET, headers="Accept=html/text")
	public String getAllPatientVisitsForBrowser(ModelMap model) throws SQLException {
		List<CcmPatientVisit> patientVisits = supportingLifeService.getAllPatientVisits();
		
		model.addAttribute("patientVisits", patientVisits);
		
		// Spring uses InternalResourceViewResolver and returns back patient_visits.jsp
		return"patient_visits";
	}
	
	
	/**
	 * Returns the requested patient visit record (HTTP Request)
	 * 
	 * @param visitId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{visitId}", method=RequestMethod.GET, headers="Accept=html/text")
	public String getPatientVisitForBrowser(@PathVariable long visitId, ModelMap model) {
		
		// 1. pull back the specific details on the visit
		CcmPatientVisit patientVisit = supportingLifeService.getPatientVisitbyVisitId(visitId);
		
		model.addAttribute("patientVisit", patientVisit);
		
		// 2. pull back the 'look' assessment symptom data
		CcmPatientLookSymptoms patientLookSymptoms = supportingLifeService.getLookSymptomsByVisit(patientVisit);
		model.addAttribute("patientLookSymptoms", patientLookSymptoms);
		
		// 3. pull back the 'ask look' assessment symptom data
		CcmPatientAskLookSymptoms patientAskLookSymptoms = supportingLifeService.getAskLookSymptomsByVisit(patientVisit);
		model.addAttribute("patientAskLookSymptoms", patientAskLookSymptoms);
		
		// 4. pull back the determined classifications associated with this assessment 
		List<CcmPatientClassification> patientClassifications = supportingLifeService.getPatientClassificationsByVisit(patientVisit);
		model.addAttribute("patientClassifications", patientClassifications);

		// 5. pull back the treatments associated with this assessment 
		List<CcmPatientTreatment> patientTreatments = supportingLifeService.getPatientTreatmentsByVisit(patientVisit);
		model.addAttribute("patientTreatments", patientTreatments);
		
		// Spring uses InternalResourceViewResolver and returns back patient_visit.jsp
		return "patient_visit";		
	}
	
	
	/**
	 * Adds the patient record (JSON Request)
	 * 
	 * @param patientAssessment
	 * 
	 * @return @ResponseBody
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST,  produces={"application/json"}, consumes={"application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Long addPatientAssessmentForAndroid(@RequestBody PatientAssessmentComms patientAssessment) {
		
		Long patientId = supportingLifeService.addPatientVisit(patientAssessment);
	
		return patientId;
	}
	
} // end of class