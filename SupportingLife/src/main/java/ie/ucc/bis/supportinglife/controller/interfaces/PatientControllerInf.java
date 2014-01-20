package ie.ucc.bis.supportinglife.controller.interfaces;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


public interface PatientControllerInf {
	public String getAllPatientsForBrowser(ModelMap model) throws SQLException;
	public String getAllPatientsByFirstName(@PathVariable String firstName, ModelMap model);
	public @ResponseBody CcmPatient getPatientForAndroid(@PathVariable("id") long id);
	public @ResponseBody CcmPatient addPatientForAndroid(@Valid @RequestBody CcmPatient patient, BindingResult result) throws BindException;
}
