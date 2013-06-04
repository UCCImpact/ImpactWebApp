package ie.ucc.bis.controller.interfaces;

import ie.ucc.bis.domain.Patient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


public interface PatientControllerInf {
	
	public @ResponseBody Patient getPatientForAndroid(@PathVariable("id") long id);
	
}
