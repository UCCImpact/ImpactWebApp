package ie.ucc.bis.supportinglife.mail;

import ie.ucc.bis.supportinglife.surveillance.SurveillancePeriodStats;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class MailHandler implements ResourceLoaderAware {
	
	private static final String CONTENT_ID = "Content-ID";

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
	private ResourceLoader resourceLoader;
	
	public void sendMail(final String from, final String to, final String subject, final SurveillancePeriodStats surveillancePeriodStats) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true); // multipart
			    
				message.setTo(to);
				message.setFrom(from);
				message.setSubject(subject);
				message.setSentDate(new Date());
				
				Map model = new HashMap();                 
				model.put("surveillancePeriodStats", surveillancePeriodStats);

				MimeBodyPart part = new MimeBodyPart();
				String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "diseaseSurveillanceMessage.vm", "UTF-8", model);
				part.setContent(body, "text/html");
				
				// Create a new part for the SL Logo and set the CID image identifier
				MimeBodyPart slLogoImagePart = new MimeBodyPart();
				FileDataSource fileDataSourceLogo = new FileDataSource(getResource("resources/images/supporting_life_logo.jpg").getFile());
				slLogoImagePart.setDataHandler(new DataHandler(fileDataSourceLogo));
				slLogoImagePart.setHeader(CONTENT_ID, "<slLogo>");
				
				// Create a new part for the bar chart image and set the CID image identifier
				MimeBodyPart barChartImgPart = new MimeBodyPart();
				FileDataSource fileDataSourceBarChart = new FileDataSource(getResource("resources/images/surveillance_bar_chart.jpg").getFile());
				barChartImgPart.setDataHandler(new DataHandler(fileDataSourceBarChart));
				barChartImgPart.setHeader(CONTENT_ID, "<barChart>");
				
				// Create a new part for the euFlag image and set the CID image identifier
				MimeBodyPart euFlagImgPart = new MimeBodyPart();
				FileDataSource fileDataSourceFlag = new FileDataSource(getResource("resources/images/eu-flag.png").getFile());
				euFlagImgPart.setDataHandler(new DataHandler(fileDataSourceFlag));
				euFlagImgPart.setHeader(CONTENT_ID, "<euFlag>");
						
				Multipart multiPart = new MimeMultipart();
				multiPart.addBodyPart(part);
				multiPart.addBodyPart(slLogoImagePart);
				multiPart.addBodyPart(barChartImgPart);
				multiPart.addBodyPart(euFlagImgPart);

				// Set the message's content
				mimeMessage.setContent(multiPart, "text/html");
			}
		};
		mailSender.send(preparator);
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
 
	public Resource getResource(String location){
		return resourceLoader.getResource(location);
	}
}

