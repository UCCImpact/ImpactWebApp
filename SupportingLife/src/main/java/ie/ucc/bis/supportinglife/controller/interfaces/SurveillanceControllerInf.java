package ie.ucc.bis.supportinglife.controller.interfaces;

import java.sql.SQLException;

import org.springframework.ui.ModelMap;


public interface SurveillanceControllerInf {
	public String getAllSurveillanceRecords(ModelMap model) throws SQLException;
}
