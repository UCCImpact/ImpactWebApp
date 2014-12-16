package ie.ucc.bis.supportinglife.service;

import ie.ucc.bis.supportinglife.ccm.dao.CcmAskLookSymptomsDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmAssessmentAnalyticsDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmLookSymptomsDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientClassificationDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientTreatmentDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientVisitDao;
import ie.ucc.bis.supportinglife.ccm.dao.ContactsDao;
import ie.ucc.bis.supportinglife.ccm.dao.Dao;
import ie.ucc.bis.supportinglife.ccm.dao.NewsDao;
import ie.ucc.bis.supportinglife.ccm.dao.UserDao;
import ie.ucc.bis.supportinglife.ccm.domain.CcmAssessmentAnalytics;
import ie.ucc.bis.supportinglife.ccm.domain.CcmAssessmentSensorReadings;
import ie.ucc.bis.supportinglife.ccm.domain.CcmClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.ccm.domain.CcmTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.NewsEntry;
import ie.ucc.bis.supportinglife.ccm.domain.User;
import ie.ucc.bis.supportinglife.communication.PatientAssessmentComms;
import ie.ucc.bis.supportinglife.communication.PatientAssessmentResponseComms;
import ie.ucc.bis.supportinglife.communication.PersonContactComms;
import ie.ucc.bis.supportinglife.communication.SurveillanceRequestComms;
import ie.ucc.bis.supportinglife.communication.TreatmentRecommendation;
import ie.ucc.bis.supportinglife.communication.UserAuthenticationComms;
import ie.ucc.bis.supportinglife.form.NewsEntryCreationForm;
import ie.ucc.bis.supportinglife.form.UserCreationForm;
import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.NewsItem;
import ie.ucc.bis.supportinglife.reference.Treatment;
import ie.ucc.bis.supportinglife.surveillance.SurveillancePeriodStats;
import ie.ucc.bis.supportinglife.surveillance.SurveillanceRecord;
import ie.ucc.bis.supportinglife.utilities.DateUtilities;

import java.awt.Color;
import java.awt.GradientPaint;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SupportingLifeService implements SupportingLifeServiceInf, ResourceLoaderAware {

	Logger log = Logger.getLogger(SupportingLifeService.class); 
	
	private Map<String, Dao> daoBeans;
	private ResourceLoader resourceLoader;
	
	/*******************************************************************************/
	/************************************Users**************************************/
	/*******************************************************************************/
	@Override
	public User getUserByUserId(String userId) {
		UserDao userDao = (UserDao) getDaoBeans().get("UserDao");
		return userDao.getUserByUserId(userId);
	}	
	
	@Override
	public Boolean registerUser(UserAuthenticationComms userDetails) {
		UserDao userDao = (UserDao) getDaoBeans().get("UserDao");
		boolean authenticatedUser = userDao.authenticateUser(userDetails.getHsaUserId(), userDetails.getPassword());
		if (authenticatedUser) {
			// user authenticated so record user registration
			userDao.registerUser(getUserByUserId(userDetails.getHsaUserId()));
		}
		return authenticatedUser;
	}
	
	@Override
	public void createUser(UserCreationForm userDetails) {
		UserDao userDao = (UserDao) getDaoBeans().get("UserDao");
		userDao.addUser(userDetails);
	}
	
	@Override
	public Boolean checkUserIdExistence(String userId) {
		UserDao userDao = (UserDao) getDaoBeans().get("UserDao");
		if (userDao.getUserByUserId(userId) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*******************************************************************************/
	/***********************************Patients************************************/
	/*******************************************************************************/

	@Override
	public List<CcmPatient> getAllPatients() {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getAllPatients();
	}
	
	@Override
	public Long getPatientIdByNationalId(String nationalId) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getPatientIdByNationalId(nationalId);
	}
	
	@Override
	public Long getPatientByNationalHealthId(String nationalHealthId) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getPatientIdByNationalHealthId(nationalHealthId);
	}
	
	@Override
	public List<CcmPatient> getAllPatientsByFirstName(String firstName) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getAllPatientsByFirstName(firstName);
	}
	
	@Override
	public List<String> getAllPatientsByNationalHealthIdFilter(String nationalHealthIdFilter) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getFilteredNationalHealthIds(nationalHealthIdFilter);
	}

	/**
	 * Responsible for obtaining patient reference - if it is an existing patient, we will
	 * retrieve the reference using the 'national id' or 'national health id', otherwise
	 * we will create a new CcmPatient instance.
	 * 
	 * @param patientAssessment
	 * @return
	 */
	private CcmPatient obtainCcmPatientReference(PatientAssessmentComms patientAssessment) {
		
		CcmPatient ccmPatient = null;
		Date currentDate = DateUtilities.getTodaysDate(PatientAssessmentComms.DATE_TIME_CUSTOM_FORMAT);
		Long patientId = null;
		
		// check national id
		if (patientAssessment.getNationalId() != null) {
			patientId = getPatientIdByNationalId(patientAssessment.getNationalId());
		}
			
		// check national health id
		if (patientId != null && patientAssessment.getNationalHealthId() != null) {
			patientId = getPatientByNationalHealthId(patientAssessment.getNationalHealthId());
		}
		
		// if no luck finding reference, create new instance
		if (patientId == null) {
			ccmPatient = new CcmPatient(patientAssessment.getNationalId(), patientAssessment.getNationalHealthId(),
					patientAssessment.getChildFirstName(), patientAssessment.getChildSurname(),
					patientAssessment.getBirthDate(), patientAssessment.getMonthsAge(), patientAssessment.getGender(),
					patientAssessment.getCaregiverName(), patientAssessment.getRelationship(),
					patientAssessment.getPhysicalAddress(),
					patientAssessment.getVillage(),patientAssessment.getTa(), currentDate, currentDate);
			
			// need to persist this new ccmPatient instance to obtain a valid 'patient_id'
			CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
			patientDao.addPatient(ccmPatient);
		}
		else {
			// already exists so just need to update the 'updated' field
			ccmPatient = new CcmPatient();
			ccmPatient.setPatientId(patientId);
		}
		return ccmPatient;
	}
	
	/*******************************************************************************/
	/*********************************Visits****************************************/
	/*******************************************************************************/
	
	@Override
	@Transactional
	public PatientAssessmentResponseComms addPatientVisit(PatientAssessmentComms patientAssessment) {
		
		// 1. retrieve or create 'patient' instance
		CcmPatient ccmPatient = obtainCcmPatientReference(patientAssessment);
		
		// 2. retrieve reference to HSA user
		User hsaUser = new User();
		hsaUser.setUserId(patientAssessment.getHsaUserId());
		
		// 3. create 'patient visit' instance
		CcmPatientVisit ccmPatientVisit = new CcmPatientVisit(ccmPatient, patientAssessment.getDeviceGeneratedAssessmentId(),
				patientAssessment.getVisitDate(), hsaUser);
		
		// 4. create the 'Look' symptoms
		CcmPatientLookSymptoms ccmPatientLookSymptoms = new CcmPatientLookSymptoms(ccmPatientVisit, ccmPatient, patientAssessment.isChestIndrawing(),
							patientAssessment.getBreathsPerMinute(), patientAssessment.isSleepyUnconscious(), patientAssessment.isPalmarPallor(),
							patientAssessment.getMuacTapeColour(), patientAssessment.isSwellingBothFeet());
				
		// 5. create the 'Ask + Look' symptoms
		CcmPatientAskLookSymptoms ccmPatientAskLookSymptoms = new CcmPatientAskLookSymptoms(ccmPatientVisit, ccmPatient, patientAssessment.getProblem(), 
							patientAssessment.isCough(), patientAssessment.getCoughDuration(), patientAssessment.isDiarrhoea(),
							patientAssessment.getDiarrhoeaDuration(), patientAssessment.isBloodInStool(), patientAssessment.isFever(),
							patientAssessment.getFeverDuration(), patientAssessment.isConvulsions(), patientAssessment.isDifficultyDrinkingOrFeeding(),
							patientAssessment.isUnableToDrinkOrFeed(), patientAssessment.isVomiting(), patientAssessment.isVomitsEverything(),
							patientAssessment.isRedEye(), patientAssessment.getRedEyeDuration(), patientAssessment.isDifficultySeeing(),
							patientAssessment.getDifficultySeeingDuration(), patientAssessment.getCannotTreatProblemDetails());
		
		// associate the symptoms with the patient visit
		ccmPatientVisit.setCcmPatientLookSymptoms(ccmPatientLookSymptoms);
		ccmPatientVisit.setCcmPatientAskLookSymptoms(ccmPatientAskLookSymptoms);
				
		// 6. associate the classifications with the patient visit
		for (Map.Entry<String, String> entry : patientAssessment.getClassifications().entrySet()) {
			ccmPatientVisit.getCcmPatientClassificationList().add(new CcmPatientClassification(ccmPatientVisit, new CcmClassification(entry.getKey(), entry.getValue()), ccmPatient));
		}
		
		// 7. associate the treatments with the patient visit
		Map<String, String> treatments = new HashMap<String, String>();
		for (TreatmentRecommendation treatment : patientAssessment.getTreatments()) {
			treatments.put(treatment.getTreatmentIdentifier(), treatment.getTreatmentDescription());
		}
		
		for (TreatmentRecommendation treatment : patientAssessment.getTreatments()) {
			ccmPatientVisit.getCcmPatientTreatmentList().add(new CcmPatientTreatment(ccmPatientVisit, 
					new CcmTreatment(treatment.getTreatmentIdentifier(), treatment.getTreatmentDescription(),
							treatment.isDrugAdministered(), treatment.isTreatmentAdministered()), ccmPatient));
		}
		
		// 8. create the 'sensor vital sign readings' record
		CcmAssessmentSensorReadings ccmAssessmentSensorReadings = new CcmAssessmentSensorReadings(ccmPatientVisit, patientAssessment.getSensorHeartRate(),
				patientAssessment.getSensorRespiratoryRate(), patientAssessment.getSensorBodyTemperature());
		
		// associate the 'sensor vital sign readings' with the patient visit
		ccmPatientVisit.setCcmAssessmentSensorReadings(ccmAssessmentSensorReadings);	
		
		// 9. create the 'assessment analytics' record
		CcmAssessmentAnalytics ccmAssessmentAnalytics = new CcmAssessmentAnalytics(ccmPatientVisit, patientAssessment.isBreathCounterUsed(), 
				patientAssessment.isBreathFullTimeAssessment(), patientAssessment.getLatitudeLocation(), patientAssessment.getLongitudeLocation());
		
		// associate the assessment analytics with the patient visit
		ccmPatientVisit.setCcmAssessmentAnalytics(ccmAssessmentAnalytics);
		
		// 10. add the CcmPatientVisit record to the DB
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		patientVisitDao.addPatientVisit(ccmPatientVisit);
						
		// 11. construct 'communication response' for reply to device
		PatientAssessmentResponseComms assessmentResponse = new PatientAssessmentResponseComms(patientAssessment.getDeviceGeneratedAssessmentId(), 
																	ccmPatientVisit.getVisitId(), ccmPatient.getPatientId(), ccmPatient.getNationalId(), 
																	ccmPatient.getNationalHealthId(), ccmPatient.getChildFirstName(), 
																	ccmPatient.getChildSurname());
		
		return assessmentResponse;
	}
	
	
	@Override
	public List<CcmPatientVisit> getPatientVisitbyVisitId(long visitId) {
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		return patientVisitDao.getPatientVisitbyVisitId(visitId);
	}
	
	@Override
	public List<CcmPatientVisit> getPatientVisitsbyPatientId(long patientId) {
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		return patientVisitDao.getPatientVisitsByPatientId(patientId);
	}
	
	@Override
	public List<CcmPatientVisit> getAllPatientVisits() {
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		return patientVisitDao.getAllPatientVisits();
	}
	
	@Override
	public List<CcmPatientVisit> getPatientVisits(String patientId,
												String nationalId,
												String nationalHealthId, 
												String hsaUserId, 
												Date assessmentDateFrom,
												Date assessmentDateTo) {
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		
		return patientVisitDao.getPatientVisits(patientId, nationalId, nationalHealthId,
											hsaUserId, assessmentDateFrom, assessmentDateTo);
	}
	
	
	@Override
	public List<CcmPatientVisit> getPatientVisits(List<CheckboxFormElement> lookSymptoms,
												List<CheckboxFormElement> askLookSymptoms,
												List<CheckboxFormElement> classifications) {
		// 1. identify symptoms selected by user
		List<CheckboxFormElement> selectedLookSymptoms = identifySelectedSymptoms(lookSymptoms);
		List<CheckboxFormElement> selectedAskLookSymptoms = identifySelectedSymptoms(askLookSymptoms);
		
		// 2. identify classifications selected by user
		List<CheckboxFormElement> selectedClassifications = identifySelectedClassifications(classifications);
		
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		return patientVisitDao.getPatientVisits(selectedLookSymptoms, selectedAskLookSymptoms, selectedClassifications);		
	}
	
	
	@Override
	public List<CcmPatientVisit> getPatientVisits(List<Treatment> treatments) {		
		// 1. identify treatments selected by user
		List<Treatment> selectedTreatments = identifySelectedTreatments(treatments);

		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		return patientVisitDao.getPatientVisits(selectedTreatments);
	}
	
	/*******************************************************************************/
	/*********************************Patient Symptoms******************************/
	/*******************************************************************************/
	@Override
	public List<CcmPatientLookSymptoms> getLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit) {
		CcmLookSymptomsDao lookSymptomsDao = (CcmLookSymptomsDao) getDaoBeans().get("CcmLookSymptomsDao");
		return lookSymptomsDao.getLookSymptomsByVisit(ccmPatientVisit);
	}
	
	@Override
	public List<CcmPatientAskLookSymptoms> getAskLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit) {
		CcmAskLookSymptomsDao askLookSymptomsDao = (CcmAskLookSymptomsDao) getDaoBeans().get("CcmAskLookSymptomsDao");
		return askLookSymptomsDao.getAskLookSymptomsByVisit(ccmPatientVisit);		
	}
	
	/*******************************************************************************/
	/******************************Patient Classifications**************************/
	/*******************************************************************************/	
	@Override
	public List<CcmPatientClassification> getPatientClassificationsByVisit(CcmPatientVisit ccmPatientVisit) {
		CcmPatientClassificationDao patientClassificationDao = (CcmPatientClassificationDao) getDaoBeans().get("CcmPatientClassificationDao");
		return patientClassificationDao.getPatientClassificationsByVisit(ccmPatientVisit);				
	}
	
	/*******************************************************************************/
	/*******************************Patient Treatments******************************/
	/*******************************************************************************/	
	@Override
	public List<CcmPatientTreatment> getPatientTreatmentsByVisit(CcmPatientVisit ccmPatientVisit) {
		CcmPatientTreatmentDao patientTreatmentDao = (CcmPatientTreatmentDao) getDaoBeans().get("CcmPatientTreatmentDao");
		return patientTreatmentDao.getPatientTreatmentsByVisit(ccmPatientVisit);				
	}

	
	/*******************************************************************************/
	/*******************************Disease Surveillance****************************/
	/*******************************************************************************/
	@Override
	public List<SurveillanceRecord> getSurveillanceRecords(SurveillanceRequestComms surveillanceRequestComms) {	
		CcmAssessmentAnalyticsDao surveillanceDao = (CcmAssessmentAnalyticsDao) getDaoBeans().get("CcmAssessmentAnalyticsDao");
		
		// check if at least a single classification has been passed through
		if (surveillanceRequestComms.getClassificationKeys().size() > 0) {	
			List<SurveillanceRecord> daoSurveillanceRecords = surveillanceDao.getSurveillanceRecords(surveillanceRequestComms);
			
			// check for any duplicated coordinates and modify slightly so
			// they each are displayed on the browser map
			return modifyDuplicatedCoordinates(daoSurveillanceRecords);
		}
		else {
			return null;
		}
	}
	
	
	/**
	 * Responsible for examining a group of surveillance records and determining whether
	 * any duplicates exist. A duplicate is identified as having the same longitude and
	 * latitude coordinate values.
	 * 
	 * Duplicate records have their coordinate values manipulated slightly by an offset.
	 * This is ensure they are assigned their own marker on the map.
	 * 
	 * @param originalRecords
	 * @return modifiedRecords
	 */
	private List<SurveillanceRecord> modifyDuplicatedCoordinates(Collection<SurveillanceRecord> originalRecords) {
		final List<SurveillanceRecord> modifiedRecords = new ArrayList<SurveillanceRecord>();
		final String defaultCoordinateLocation = "0.0";

		@SuppressWarnings("serial")
		Set<SurveillanceRecord> surveillanceSet = new HashSet<SurveillanceRecord>() {
			@Override
			public boolean add(SurveillanceRecord element) {
				if (contains(element)) {
					Double latitude = Double.valueOf(element.getLatitude()) + ((Math.random()*10)/10000); // minor adjustment only
					Double longitude = Double.valueOf(element.getLongitude()) + ((Math.random()*10)/10000); // minor adjustment only
					element.setLatitude(Double.toString(latitude));
					element.setLongitude(Double.toString(longitude));
				}
				modifiedRecords.add(element);
				return super.add(element);
			}
		};

		for (SurveillanceRecord record : originalRecords) {
			// need to exclude those records for which a location was not provided. 
			// this could have occurred if the phone user has configured a setting 
			// on the phone to turn off location. In this case, a default location
			// of longitude: 0, and latitude: 0, would have configured for the 
			// record.
			if (record.getLatitude().equalsIgnoreCase(defaultCoordinateLocation) == false && 
					record.getLongitude().equalsIgnoreCase(defaultCoordinateLocation) == false) {
				surveillanceSet.add(record);
			}
		}
		return modifiedRecords;
	}
	
	
	@Override
	public SurveillancePeriodStats performDiseaseSurveillancePeriodCheck(List<String> symptoms) {
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		SurveillancePeriodStats stats = patientVisitDao.performDiseaseSurveillancePeriodCheck(symptoms);
		generateSurveillanceBarChart(stats); 
	     return stats;
	}

	/**
	 * Responsible for creating image bar chart of disease surveillance chart which
	 * will be incorporated into automated email
	 * 
	 * @param stats
	 */
	private void generateSurveillanceBarChart(SurveillancePeriodStats stats) {
		DefaultCategoryDataset bardataset = new DefaultCategoryDataset();  
	     bardataset.setValue(stats.getTwentyFourHours(),"Cases" ,"24 Hours" );
	     bardataset.setValue(stats.getSevenDays(),"Cases" ,"7 Days" );
	     bardataset.setValue(stats.getThirtyDays(),"Cases" ,"30 Days" );
	     
	     JFreeChart barchart = ChartFactory.createBarChart3D(  
	         "Diarrhoea Cases",      	// Title  
	         "Time Period",             // X-axis Label  
	         "Cases",               	// Y-axis Label  
	         bardataset,             	// Dataset  
	         PlotOrientation.VERTICAL,  // Plot orientation  
	         false,                		// Show legend  
	         true,                		// Use tooltips  
	         false                		// Generate URLs  
	      );
	     
	     barchart.getTitle().setPaint(Color.BLACK);   	 			// Set the colour of the title  
	     barchart.setBackgroundPaint(Color.WHITE);    				// Set the background colour of the chart  
	     CategoryPlot categoryPlot = barchart.getCategoryPlot();  	// Get the Plot object for a bar graph  
	     categoryPlot.setBackgroundPaint(Color.WHITE);       		// Set the plot background colour
	     categoryPlot.setRangeGridlinePaint(Color.DARK_GRAY);		// Set the colour of the plot gridlines 
	     
	     GradientPaint gradientPaint = new GradientPaint(0.0F, 0.0F, Color.RED, 0.0F, 0.0F, Color.LIGHT_GRAY);  
	     BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();   
	     barRenderer.setSeriesPaint(0, gradientPaint);				// Set the bar colour
	     barRenderer.setSeriesPaint(1, gradientPaint);				// Set the bar colour
	     barRenderer.setSeriesPaint(2, gradientPaint);				// Set the bar colour

	     try {
			ChartUtilities.saveChartAsJPEG((getResource("resources/images/surveillance_bar_chart.jpg").getFile()), barchart, 500, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*******************************************************************************/
	/*******************************Contacts/Newsletter*****************************/
	/*******************************************************************************/		
	public void addPersonContact(PersonContactComms personContact) {
		ContactsDao contactsDao = (ContactsDao) getDaoBeans().get("ContactsDao");
		contactsDao.addPersonContact(personContact);
	}
	
	public void addNewsletterContact(String emailAddress) {
		ContactsDao contactsDao = (ContactsDao) getDaoBeans().get("ContactsDao");
		contactsDao.addNewsletterContact(emailAddress);		
	}

	
	/*******************************************************************************/
	/************************************Media/News*********************************/
	/*******************************************************************************/	
	@Override
	public void createNewsEntry(NewsEntryCreationForm newsEntryCreationForm) {
		NewsDao newsDao = (NewsDao) getDaoBeans().get("NewsDao");
		newsDao.addNewsEntry(newsEntryCreationForm);		
	}
	
	@Override
	public List<NewsItem> getNewsItems() {
		NewsDao newsDao = (NewsDao) getDaoBeans().get("NewsDao");
		List<NewsEntry> newsEntries = newsDao.getNewsItems();
		
		List<NewsItem> newsItems = new ArrayList<NewsItem>();
		for (NewsEntry newsEntry : newsEntries) {
		    System.out.println("bytes" + newsEntry.getPicture());
		    byte[] encodeBase64 = Base64.encodeBase64(newsEntry.getPicture());
		    String base64Encoded;
			try {
				base64Encoded = new String(encodeBase64, "UTF-8");
				newsItems.add(new NewsItem(newsEntry.getHeadline(), newsEntry.getEntry(), newsEntry.getNewsDate().toString(), 
						new String("data:image/jpg;base64," + base64Encoded)));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// sort the news items by date
		Collections.sort(newsItems, new Comparator<NewsItem>() {
		    public int compare(NewsItem newsItem1, NewsItem newsItem2) {
		    	int comparison = 0;
		        try {
		        	comparison = DateUtilities.parseDate(newsItem2.getNewsDate(), NewsItem.NEWS_DATE_FORMAT)
							.compareTo(DateUtilities.parseDate(newsItem1.getNewsDate(), NewsItem.NEWS_DATE_FORMAT));
				} catch (ParseException e) {
					log.error("Parse exception attemping to sort news items");
					e.printStackTrace();
				}
		        return comparison;
		    }
		});
		
		return newsItems;
	}
	
	/*******************************************************************************/
	/*********************************Utility Methods*******************************/
	/*******************************************************************************/
	
	/**
	 * Utility method to identify those symptoms which have been checked
	 * by a user from a symptom list
	 * 
	 * @param symptoms
	 * 
	 * @return List<Symptom>
	 */
	private List<CheckboxFormElement> identifySelectedSymptoms(List<CheckboxFormElement> symptoms) {
		List<CheckboxFormElement> symptomsSelected = new ArrayList<CheckboxFormElement>();
		
		for (CheckboxFormElement symptom : symptoms) {
			if (symptom.isChecked()) {
				symptomsSelected.add(symptom);
			}
		}	
		return symptomsSelected;
	}

	/**
	 * Utility method to identify those classifications which have been checked
	 * by a user from a classification list
	 * 
	 * @param classifications
	 * 
	 * @return List<Classification>
	 */
	private List<CheckboxFormElement> identifySelectedClassifications(List<CheckboxFormElement> classifications) {
		List<CheckboxFormElement> classificationsSelected = new ArrayList<CheckboxFormElement>();
		
		for (CheckboxFormElement classification : classifications) {
			if (classification.getChecked()) {
				classificationsSelected.add(classification);
			}
		}	
		return classificationsSelected;
	}
	
	/**
	 * Utility method to identify those treatments which have been checked
	 * by a user from a treatment list
	 * 
	 * @param treatment
	 * 
	 * @return List<Treatment>
	 */
	private List<Treatment> identifySelectedTreatments(List<Treatment> treatments) {
		List<Treatment> treatmentsSelected = new ArrayList<Treatment>();
		
		for (Treatment treatment : treatments) {
			if (treatment.getChecked()) {
				treatmentsSelected.add(treatment);
			}
		}	
		return treatmentsSelected;
	}
	
	/*******************************************************************************/
	/*********************************Getters/Setters*******************************/
	/*******************************************************************************/
	public Map<String, Dao> getDaoBeans() {
		return daoBeans;
	}

	public void setDaoBeans(Map<String, Dao> daoBeans) {
		this.daoBeans = daoBeans;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
 
	public Resource getResource(String location){
		return resourceLoader.getResource(location);
	}
}
