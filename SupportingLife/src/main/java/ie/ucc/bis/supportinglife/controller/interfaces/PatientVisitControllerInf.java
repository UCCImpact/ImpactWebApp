package ie.ucc.bis.supportinglife.controller.interfaces;

import ie.ucc.bis.supportinglife.communication.PatientAssessmentComms;
import ie.ucc.bis.supportinglife.communication.PatientAssessmentResponseComms;

import java.sql.SQLException;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


public interface PatientVisitControllerInf {
	public String getAllPatientVisitsForBrowser(ModelMap model) throws SQLException;
	public String getPatientVisitForBrowser(@PathVariable long visitId, ModelMap model);
	public @ResponseBody PatientAssessmentResponseComms addPatientAssessmentForAndroid(@RequestBody PatientAssessmentComms patientAssessmentComms);
}
