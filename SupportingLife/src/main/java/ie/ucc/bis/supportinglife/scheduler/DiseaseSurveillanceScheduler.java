package ie.ucc.bis.supportinglife.scheduler;

import ie.ucc.bis.supportinglife.mail.MailHandler;
import ie.ucc.bis.supportinglife.reference.AskLookSymptomsEnum;
import ie.ucc.bis.supportinglife.scheduler.interfaces.DiseaseSurveillanceSchedulerInf;
import ie.ucc.bis.supportinglife.service.SupportingLifeServiceInf;
import ie.ucc.bis.supportinglife.surveillance.SurveillancePeriodStats;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DiseaseSurveillanceScheduler implements DiseaseSurveillanceSchedulerInf {
	
	private static final String PRODUCTION_ENVIRONMENT = "production";
	private static final int TWENTY_FOUR_HOUR_TIME_PERIOD = 86400000;
	
	private SupportingLifeServiceInf supportingLifeServiceInf;
	private MailHandler mailHandler;
	
	Logger log = Logger.getLogger(DiseaseSurveillanceScheduler.class); 
 
	@Override
	@Scheduled(fixedDelay=TWENTY_FOUR_HOUR_TIME_PERIOD) // perform disease surveillance daily
	public void performCholeraScheduledDiseaseSurveillanceCheck() {
		log.info("Commencing scheduled task: disease surveillance check :: " + new Date());
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	    if (ctx.getEnvironment().getActiveProfiles().length == 0 || ctx.getEnvironment().getActiveProfiles()[0].equalsIgnoreCase(PRODUCTION_ENVIRONMENT)) {
	    	// have access to SMTP server so distribute notification email
	    	log.info("Production Environment :: " + new Date());
	    	
	    	// 1. Populate list of symptoms in which we're interested
	    	List<String> symptoms =  Arrays.asList(AskLookSymptomsEnum.DIARRHOEA.name());
	    	
			// 2. pull back total data record figures where diarrhoea has been diagnosed in a 24-hour, 7 day, and 30 day time period
	    	SurveillancePeriodStats surveillancePeriodStats = supportingLifeServiceInf.performDiseaseSurveillancePeriodCheck(symptoms);
	    	
	    	log.info("Surveillance Period Stats \n\n 24 Hour Time Period: " 
		    		   + surveillancePeriodStats.getTwentyFourHours() +
		    		   "\n 7 Day Time Period: " 
		    		   + surveillancePeriodStats.getSevenDays() + 
		    		   "\n 30 Day Time Period: "
		    		   + surveillancePeriodStats.getThirtyDays());
	    	
	    	String[] emailRecipients = {"C.Heavin@ucc.ie", "T.OSullivan@ucc.ie",
		    		   "Y.OConnor@ucc.ie", "deirdre.ryan@ucc.ie",
		    		   "Bo.Andersson@ics.lu.se", "j.odonoghue@imperial.ac.uk",
		    		   "wcsg@lukeinternational.no", "jennyhsieh@lukeinternational.no",
		    		   "gbchirambo@yahoo.co.uk","victoria.e.hardy@outlook.com", "supplifeucc@gmail.com"};
	    	
			// Velocity Email Formatting
	        mailHandler.sendMail("supplifeucc@gmail.com",
	        		emailRecipients,
	    		   "Disease Surveillance Automated Email", 
	    		   surveillancePeriodStats);

	    }
	    else {
	    	// we're operating in a dev environment so no access to SMTP and unable 
	    	// to distribute email
	    	log.info("Development Environment :: " + new Date());
	    	log.info("Operating in a dev environment so no access to SMTP server and unable to distribute email");
	    }
	    ctx.close();
		
		log.info("Completed scheduled task: disease surveillance check :: " + new Date() + "\n\n");
	}

	public SupportingLifeServiceInf getSupportingLifeServiceInf() {
		return supportingLifeServiceInf;
	}

	public void setSupportingLifeServiceInf(
			SupportingLifeServiceInf supportingLifeServiceInf) {
		this.supportingLifeServiceInf = supportingLifeServiceInf;
	}

	public MailHandler getMailHandler() {
		return mailHandler;
	}

	public void setMailHandler(MailHandler mailHandler) {
		this.mailHandler = mailHandler;
	}
}

