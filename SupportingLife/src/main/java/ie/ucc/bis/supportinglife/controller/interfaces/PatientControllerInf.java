package ie.ucc.bis.supportinglife.controller.interfaces;

import java.sql.SQLException;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;


public interface PatientControllerInf {
	public String getAllPatientsForBrowser(ModelMap model) throws SQLException;
	public String getAllPatientsByFirstName(@PathVariable String firstName, ModelMap model);
}
