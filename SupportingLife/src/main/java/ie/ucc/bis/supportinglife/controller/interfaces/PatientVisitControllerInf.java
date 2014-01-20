package ie.ucc.bis.supportinglife.controller.interfaces;

import java.sql.SQLException;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;


public interface PatientVisitControllerInf {
	public String getAllPatientVisitsForBrowser(ModelMap model) throws SQLException;
	public String getPatientVisitForBrowser(@PathVariable long visitId, ModelMap model);
}
