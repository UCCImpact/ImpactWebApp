package ie.ucc.bis.supportinglife.controller.interfaces;

import ie.ucc.bis.supportinglife.surveillance.SurveillanceRecord;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.ModelMap;


public interface SurveillanceControllerInf {
	public String displaySurveillance(ModelMap model) throws SQLException ;
	public List<SurveillanceRecord> getSurveillanceRecords(ModelMap model) throws SQLException;
}
