package ie.ucc.bis.supportinglife.communication;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


/**
 * 
 * @author timothyosullivan
 */

public class PatientAssessmentComms implements Serializable {

	public static final String BIRTH_DATE_CUSTOM_FORMAT = "dd MMMM yyyy";
	public static final String DATE_TIME_CUSTOM_FORMAT = "dd MMMM yyyy HH:mm";
	public static final Locale LOCALE = Locale.UK;

	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = -3143569878394681227L;

	private int id;

	// device generated patient assessment id
	private String deviceGeneratedAssessmentId;

	// General Patient Details
	private String hsaUserId;
	private String nationalId;
	private String nationalHealthId;
	private String childFirstName;
	private String childSurname;
	private Date birthDate;
	private Integer monthsAge;
	private String gender;
	private String caregiverName;
	private String relationship;
	private String physicalAddress;
	private String village;
	private String ta;
	private Date visitDate;	

	// Look Symptoms
	private boolean chestIndrawing;
	private Integer breathsPerMinute;
	private boolean sleepyUnconscious;	
	private boolean palmarPallor;	
	private String muacTapeColour;	
	private boolean swellingBothFeet;	

	// Ask Look Symptoms
	private String problem;
	private boolean cough;	
	private Integer coughDuration;
	private boolean diarrhoea;
	private Integer diarrhoeaDuration;
	private boolean bloodInStool;
	private boolean fever;
	private Integer feverDuration;
	private boolean convulsions;
	private boolean difficultyDrinkingOrFeeding;
	private boolean unableToDrinkOrFeed;
	private boolean vomiting;
	private boolean vomitsEverything;
	private boolean redEye;
	private Integer redEyeDuration;
	private boolean difficultySeeing;
	private Integer difficultySeeingDuration;
	private boolean cannotTreatProblem;
	private String cannotTreatProblemDetails;
	//new impact variables
	private boolean immunizationNeeded;
	private boolean rdtDone;
	private String rdtResult;
	private boolean otherProblems;

	// classifications
	private Map<String, String> classifications;

	// treatments
	private List<TreatmentRecommendation> treatments;
	
	// assessment specific analytics
	private boolean breathCounterUsed;
	private boolean breathFullTimeAssessment;
	private String longitudeLocation;
	private String latitudeLocation;
	
	// sensor readings
	private String sensorHeartRate;
	private String sensorRespiratoryRate;
	private String sensorBodyTemperature;

	public PatientAssessmentComms() {}

	public PatientAssessmentComms(Integer id, String deviceGeneratedAssessmentId, String nationalId, String nationalHealthId, String hsaUserId, 
			String childFirstName, String childSurname, String birthDate, Integer monthsAge,
			String gender, String caregiverName, String relationship, String physicalAddress,
			String village, String ta, String visitDate, String chestIndrawing, Integer breathsPerMinute,
			String sleepyUnconscious, String palmarPallor, String muacTapeColour, 
			String swellingBothFeet, String problem, String cough, Integer coughDuration,
			String diarrhoea, Integer diarrhoeaDuration, String bloodInStool, String fever,
			Integer feverDuration, String convulsions, String difficultyDrinkingOrFeeding,
			String unableToDrinkOrFeed, String vomiting, String vomitsEverything,
			String redEye, Integer redEyeDuration, String difficultySeeing,
			Integer difficultySeeingDuration, String cannotTreatProblem, 
			String cannotTreatProblemDetails,String immunizationNeeded,String rdtDone,
        String rdtResult, String otherProblems) {
	

		setId(id);
		setDeviceGeneratedAssessmentId(deviceGeneratedAssessmentId);
		setNationalId(nationalId);
		setNationalHealthId(nationalHealthId);
		setHsaUserId(hsaUserId);
		setChildFirstName(childFirstName);
		setChildSurname(childSurname);
		setMonthsAge(monthsAge);
		setGender(gender);
		setCaregiverName(caregiverName);
		setRelationship(relationship);
		setPhysicalAddress(physicalAddress);
		setVillage(village);
		setTa(ta);
		setChestIndrawing(Boolean.valueOf(chestIndrawing));
		setBreathsPerMinute(breathsPerMinute);
		setSleepyUnconscious(Boolean.valueOf(sleepyUnconscious));
		setPalmarPallor(Boolean.valueOf(palmarPallor));
		setMuacTapeColour(muacTapeColour);
		setSwellingBothFeet(Boolean.valueOf(swellingBothFeet));
		setProblem(problem);
		setCough(Boolean.valueOf(cough));
		setCoughDuration(coughDuration);		
		setDiarrhoea(Boolean.valueOf(diarrhoea));
		setDiarrhoeaDuration(diarrhoeaDuration);
		setBloodInStool(Boolean.valueOf(bloodInStool));
		setFever(Boolean.valueOf(fever));
		setFeverDuration(feverDuration);
		setConvulsions(Boolean.valueOf(convulsions));
		setDifficultyDrinkingOrFeeding(Boolean.valueOf(difficultyDrinkingOrFeeding));
		setUnableToDrinkOrFeed(Boolean.valueOf(unableToDrinkOrFeed));
		setVomiting(Boolean.valueOf(vomiting));
		setVomitsEverything(Boolean.valueOf(vomitsEverything));
		setRedEye(Boolean.valueOf(redEye));
		setRedEyeDuration(redEyeDuration);
		setDifficultySeeing(Boolean.valueOf(difficultySeeing));
		setDifficultySeeingDuration(difficultySeeingDuration);
		setCannotTreatProblem(Boolean.valueOf(cannotTreatProblem));
		setCannotTreatProblemDetails(cannotTreatProblemDetails);
		setImmunizationNeeded(Boolean.valueOf(immunizationNeeded));
		setRDTDone(Boolean.valueOf(rdtDone));
		setRDTResult(rdtResult);
		setOtherProblems(Boolean.valueOf(otherProblems));


		try {
			setBirthDate(parseDate(birthDate, BIRTH_DATE_CUSTOM_FORMAT));
			setVisitDate(parseDate(visitDate, DATE_TIME_CUSTOM_FORMAT));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		setClassifications(new HashMap<String, String>());
		setTreatments(new ArrayList<TreatmentRecommendation>());
	}

	public Date parseDate(String dateValue, String slDateFormat) throws ParseException {
		if (dateValue != null) {
			Date dateInstance = new SimpleDateFormat(slDateFormat, LOCALE)
			.parse(dateValue);
			return dateInstance;
		}
		else {
			return null;
		}
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeviceGeneratedAssessmentId() {
		return deviceGeneratedAssessmentId;
	}

	public void setDeviceGeneratedAssessmentId(String deviceGeneratedAssessmentId) {
		this.deviceGeneratedAssessmentId = deviceGeneratedAssessmentId;
	}

	public String getHsaUserId() {
		return hsaUserId;
	}

	public void setHsaUserId(String hsaUserId) {
		this.hsaUserId = hsaUserId;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getNationalHealthId() {
		return nationalHealthId;
	}

	public void setNationalHealthId(String nationalHealthId) {
		this.nationalHealthId = nationalHealthId;
	}

	public String getChildFirstName() {
		return childFirstName;
	}

	public void setChildFirstName(String childFirstName) {
		this.childFirstName = childFirstName;
	}

	public String getChildSurname() {
		return childSurname;
	}

	public void setChildSurname(String childSurname) {
		this.childSurname = childSurname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getMonthsAge() {
		return monthsAge;
	}

	public void setMonthsAge(Integer monthsAge) {
		this.monthsAge = monthsAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCaregiverName() {
		return caregiverName;
	}

	public void setCaregiverName(String caregiverName) {
		this.caregiverName = caregiverName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public boolean isChestIndrawing() {
		return chestIndrawing;
	}

	public void setChestIndrawing(boolean chestIndrawing) {
		this.chestIndrawing = chestIndrawing;
	}

	public Integer getBreathsPerMinute() {
		return breathsPerMinute;
	}

	public void setBreathsPerMinute(Integer breathsPerMinute) {
		this.breathsPerMinute = breathsPerMinute;
	}

	public boolean isSleepyUnconscious() {
		return sleepyUnconscious;
	}

	public void setSleepyUnconscious(boolean sleepyUnconscious) {
		this.sleepyUnconscious = sleepyUnconscious;
	}

	public boolean isPalmarPallor() {
		return palmarPallor;
	}

	public void setPalmarPallor(boolean palmarPallor) {
		this.palmarPallor = palmarPallor;
	}

	public String getMuacTapeColour() {
		return muacTapeColour;
	}

	public void setMuacTapeColour(String muacTapeColour) {
		this.muacTapeColour = muacTapeColour;
	}

	public boolean isSwellingBothFeet() {
		return swellingBothFeet;
	}

	public void setSwellingBothFeet(boolean swellingBothFeet) {
		this.swellingBothFeet = swellingBothFeet;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public boolean isCough() {
		return cough;
	}

	public void setCough(boolean cough) {
		this.cough = cough;
	}

	public Integer getCoughDuration() {
		return coughDuration;
	}

	public void setCoughDuration(Integer coughDuration) {
		this.coughDuration = coughDuration;
	}

	public boolean isDiarrhoea() {
		return diarrhoea;
	}

	public void setDiarrhoea(boolean diarrhoea) {
		this.diarrhoea = diarrhoea;
	}

	public Integer getDiarrhoeaDuration() {
		return diarrhoeaDuration;
	}

	public void setDiarrhoeaDuration(Integer diarrhoeaDuration) {
		this.diarrhoeaDuration = diarrhoeaDuration;
	}

	public boolean isBloodInStool() {
		return bloodInStool;
	}

	public void setBloodInStool(boolean bloodInStool) {
		this.bloodInStool = bloodInStool;
	}

	public boolean isFever() {
		return fever;
	}

	public void setFever(boolean fever) {
		this.fever = fever;
	}

	public Integer getFeverDuration() {
		return feverDuration;
	}

	public void setFeverDuration(Integer feverDuration) {
		this.feverDuration = feverDuration;
	}

	public boolean isConvulsions() {
		return convulsions;
	}

	public void setConvulsions(boolean convulsions) {
		this.convulsions = convulsions;
	}

	public boolean isDifficultyDrinkingOrFeeding() {
		return difficultyDrinkingOrFeeding;
	}

	public void setDifficultyDrinkingOrFeeding(boolean difficultyDrinkingOrFeeding) {
		this.difficultyDrinkingOrFeeding = difficultyDrinkingOrFeeding;
	}

	public boolean isUnableToDrinkOrFeed() {
		return unableToDrinkOrFeed;
	}

	public void setUnableToDrinkOrFeed(boolean unableToDrinkOrFeed) {
		this.unableToDrinkOrFeed = unableToDrinkOrFeed;
	}

	public boolean isVomiting() {
		return vomiting;
	}

	public void setVomiting(boolean vomiting) {
		this.vomiting = vomiting;
	}

	public boolean isVomitsEverything() {
		return vomitsEverything;
	}

	public void setVomitsEverything(boolean vomitsEverything) {
		this.vomitsEverything = vomitsEverything;
	}

	public boolean isRedEye() {
		return redEye;
	}

	public void setRedEye(boolean redEye) {
		this.redEye = redEye;
	}

	public Integer getRedEyeDuration() {
		return redEyeDuration;
	}

	public void setRedEyeDuration(Integer redEyeDuration) {
		this.redEyeDuration = redEyeDuration;
	}

	public boolean isDifficultySeeing() {
		return difficultySeeing;
	}

	public void setDifficultySeeing(boolean difficultySeeing) {
		this.difficultySeeing = difficultySeeing;
	}

	public Integer getDifficultySeeingDuration() {
		return difficultySeeingDuration;
	}

	public void setDifficultySeeingDuration(Integer difficultySeeingDuration) {
		this.difficultySeeingDuration = difficultySeeingDuration;
	}

	public boolean isCannotTreatProblem() {
		return cannotTreatProblem;
	}

	public void setCannotTreatProblem(boolean cannotTreatProblem) {
		this.cannotTreatProblem = cannotTreatProblem;
	}

	public String getCannotTreatProblemDetails() {
		return cannotTreatProblemDetails;
	}

	public void setCannotTreatProblemDetails(String cannotTreatProblemDetails) {
		this.cannotTreatProblemDetails = cannotTreatProblemDetails;
	}

	public Map<String, String> getClassifications() {
		return classifications;
	}

	public void setClassifications(Map<String, String> classifications) {
		this.classifications = classifications;
	}

	public List<TreatmentRecommendation> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<TreatmentRecommendation> treatments) {
		this.treatments = treatments;
	}
	
	public boolean isBreathCounterUsed() {
		return breathCounterUsed;
	}

	public void setBreathCounterUsed(boolean breathCounterUsed) {
		this.breathCounterUsed = breathCounterUsed;
	}

	public boolean isBreathFullTimeAssessment() {
		return breathFullTimeAssessment;
	}

	public void setBreathFullTimeAssessment(boolean breathFullTimeAssessment) {
		this.breathFullTimeAssessment = breathFullTimeAssessment;
	}

	public String getLongitudeLocation() {
		return longitudeLocation;
	}

	public void setLongitudeLocation(String longitudeLocation) {
		this.longitudeLocation = longitudeLocation;
	}

	public String getLatitudeLocation() {
		return latitudeLocation;
	}

	public void setLatitudeLocation(String latitudeLocation) {
		this.latitudeLocation = latitudeLocation;
	}

	public String getSensorHeartRate() {
		return sensorHeartRate;
	}

	public void setSensorHeartRate(String sensorHeartRate) {
		this.sensorHeartRate = sensorHeartRate;
	}

	public String getSensorRespiratoryRate() {
		return sensorRespiratoryRate;
	}

	public void setSensorRespiratoryRate(String sensorRespiratoryRate) {
		this.sensorRespiratoryRate = sensorRespiratoryRate;
	}

	public String getSensorBodyTemperature() {
		return sensorBodyTemperature;
	}

	public void setSensorBodyTemperature(String sensorBodyTemperature) {
		this.sensorBodyTemperature = sensorBodyTemperature;
	}	
	
	public boolean getImmunizationNeeded() {
		return immunizationNeeded;
	}
	
	public void setImmunizationNeeded(boolean immunizationNeeded) {
		this.immunizationNeeded = immunizationNeeded;
	}
		public void setRDTDone(boolean rdtDone) {
		this.rdtDone = rdtDone;
	}
	
	public boolean getRDTDone() {
		return rdtDone;
	}
	public void setRDTResult(String rdtResult) {
		this.rdtResult = rdtResult;
	}
	
	public String getRDTResult() {
		return rdtResult;
	}
	public void setOtherProblems(boolean otherProblems) {
		this.otherProblems= otherProblems;
	}
	
	public boolean getOtherProblems () {
		return this.otherProblems;
	}
}
