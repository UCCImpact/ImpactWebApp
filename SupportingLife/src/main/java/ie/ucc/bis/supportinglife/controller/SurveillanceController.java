package ie.ucc.bis.supportinglife.controller;

import ie.ucc.bis.supportinglife.controller.interfaces.SurveillanceControllerInf;
import ie.ucc.bis.supportinglife.service.SupportingLifeService;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/surveillance")
public class SurveillanceController implements SurveillanceControllerInf {

	private static final String SURVEILLANCE_PAGE_PREFIX = "sl_";
	
	@Autowired
	private SupportingLifeServiceInf supportingLifeService;

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
	 * Returns all disease surveillance records (HTTP Request)
	 * 
	 * 
	 * @param model
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(method = RequestMethod.GET, headers="Accept=html/text")
	public String getAllSurveillanceRecords(ModelMap model) throws SQLException {
//		List<CcmPatient> patients = supportingLifeService.getAllPatients();
		
//		model.addAttribute("patients", patients);
		
		// Spring uses InternalResourceViewResolver and returns back sl_surveillance.jsp
		return SURVEILLANCE_PAGE_PREFIX + "surveillance";
	}
} // end of class