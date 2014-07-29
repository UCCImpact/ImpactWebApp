package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.communication.SurveillanceRequestComms;
import ie.ucc.bis.supportinglife.controller.interfaces.SurveillanceControllerInf;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;
import ie.ucc.bis.supportinglife.service.helper.SupportingLifeRefDataHelperInf;
import ie.ucc.bis.supportinglife.surveillance.SurveillanceRecord;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/surveillance")
public class SurveillanceController implements SurveillanceControllerInf {

	private static final String SURVEILLANCE_PAGE_PREFIX = "sl_";
	
	@Autowired
	private SupportingLifeServiceInf supportingLifeService;
	@Autowired
	private SupportingLifeRefDataHelperInf SupportingLifeRefDataHelper;

	/**
	 * Default Constructor
	 * 
	 */
	public SurveillanceController() {}	
	
	/**
	 * Constructor
	 * 
	 * @param supportingLifeService
	 */
	public SurveillanceController(SupportingLifeService supportingLifeService) {
		this.supportingLifeService = supportingLifeService;
	}
	

	/**
	 * Display Disease Surveillance Map
	 * 
	 * 
	 * @param model
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(method = RequestMethod.GET, headers="Accept=html/text")
	public String displaySurveillance(ModelMap model) throws SQLException {
		
		model.addAttribute("classifications", SupportingLifeRefDataHelper.getCcmCustomReportReferenceCriteria().getClassifications());
		
		// Spring uses InternalResourceViewResolver and returns back sl_surveillance.jsp
		return SURVEILLANCE_PAGE_PREFIX + "surveillance";
	}
	
	/**
	 * Returns all disease surveillance records (HTTP Request)
	 * 
	 * 
	 * @param model
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(value="/getSurveillanceRecords", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public List<SurveillanceRecord> getSurveillanceRecords(@RequestBody SurveillanceRequestComms surveillanceRequestComms) throws SQLException {
		List<SurveillanceRecord> surveillanceRecords = supportingLifeService.getSurveillanceRecords(surveillanceRequestComms);
		
		return surveillanceRecords;
	}
} // end of class