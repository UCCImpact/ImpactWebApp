package ie.ucc.bis.supportinglife.controller.interfaces;

import ie.ucc.bis.supportinglife.ccm.domain.Patient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


public interface PatientControllerInf {
	
	public @ResponseBody Patient getPatientForAndroid(@PathVariable("id") long id);
	
}
