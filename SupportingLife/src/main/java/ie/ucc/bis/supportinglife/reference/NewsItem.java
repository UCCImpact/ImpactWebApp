package ie.ucc.bis.supportinglife.reference;

import ie.ucc.bis.supportinglife.ccm.dao.NewsDaoImpl;
import ie.ucc.bis.supportinglife.utilities.DateUtilities;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class NewsItem {
	public static final String NEWS_DATE_FORMAT = "yyyy MM dd";
	
	private String headline;
	private String entry;
	private String newsDate;
	private MultipartFile picture;
	private String pictureStringFormat;
	private String day;
	private String month;
	private String year;
	
	Logger log = Logger.getLogger(NewsDaoImpl.class); 
	
	public NewsItem(String headline, String entry, String newsDate, String pictureStringFormat) {
		setHeadline(headline);
		setEntry(entry);
		setNewsDate(newsDate);
		setPictureStringFormat(pictureStringFormat);
		if (getNewsDate() != null) {
			try {
				Calendar calendar = Calendar.getInstance();
				// remove dashes from news date
				setNewsDate(getNewsDate().replace("-", " "));
				Date newsItemDate = DateUtilities.parseDate(getNewsDate(), NEWS_DATE_FORMAT);
				calendar.setTime(newsItemDate);
				setDay(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
				setMonth(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
				setYear(String.valueOf(calendar.get(Calendar.YEAR)));
			} catch (ParseException e) {
				log.error("Error parsing the news entry date field");
				e.printStackTrace();
			}
		}
	}
	
	public String getHeadline() {
		return headline;
	}
	
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public String getEntry() {
		return entry;
	}
	
	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	public String getNewsDate() {
		return newsDate;
	}
	
	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}
	
	public MultipartFile getPicture() {
		return picture;
	}
	
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
	public String getPictureStringFormat() {
		return pictureStringFormat;
	}
	
	public void setPictureStringFormat(String pictureStringFormat) {
		this.pictureStringFormat = pictureStringFormat;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
