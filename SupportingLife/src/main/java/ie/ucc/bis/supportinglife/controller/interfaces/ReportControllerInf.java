package ie.ucc.bis.supportinglife.controller.interfaces;

import ie.ucc.bis.supportinglife.report.form.CcmDemographicForm;
import ie.ucc.bis.supportinglife.report.form.CcmSymptomsClassificationsForm;
import ie.ucc.bis.supportinglife.report.form.CcmTreatmentForm;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;


public interface ReportControllerInf {
	public Map<String, List<String>> filterNationalHealthIds(String term);
	public String getCcmDemographicReportSelectionCriteria(ModelMap model);
	public String getCcmSymptomsClassificationsReportSelectionCriteria(ModelMap model);
	public String getCcmTreatmentReportSelectionCriteria(ModelMap model);
	public String getCcmDemographicReport(CcmDemographicForm ccmDemographicForm, Model model);
	public String getCcmSymptomClassificationReport(CcmSymptomsClassificationsForm ccmSymptomsClassificationsForm, Model model);
	public String getCcmTreatmentReport(CcmTreatmentForm ccmTreatmentForm, Model model);
}