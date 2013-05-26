package ie.ucc.bis.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

public interface PatientControllerInf {
	
	public String getPatient(@PathVariable("id") long id, Model model);
	
}
