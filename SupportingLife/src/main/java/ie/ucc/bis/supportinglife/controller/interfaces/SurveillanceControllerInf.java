package ie.ucc.bis.supportinglife.controller.interfaces;

import ie.ucc.bis.supportinglife.communication.SurveillanceRequestComms;
import ie.ucc.bis.supportinglife.surveillance.SurveillanceRecord;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;


public interface SurveillanceControllerInf {
	public String displaySurveillance(ModelMap model) throws SQLException ;
	public List<SurveillanceRecord> getSurveillanceRecords(@RequestBody SurveillanceRequestComms surveillanceRequestComms) throws SQLException;
}
