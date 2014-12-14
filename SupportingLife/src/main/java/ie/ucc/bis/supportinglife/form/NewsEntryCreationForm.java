package ie.ucc.bis.supportinglife.form;

import java.util.Date;


/**
 * Bean to capture information from News Entry Creation Form
 * 
 * @author TOSullivan
 */

public class NewsEntryCreationForm  {
	
	private String headline;
	private String entry;
	private Date date;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
        StringBuilder stringBuilder = new StringBuilder();  
        stringBuilder.append("\n" + "headline: " + getHeadline() + "\n");
        stringBuilder.append("entry: " + getEntry()  + "\n");
        stringBuilder.append("date: " + getDate() + "\n");        
        return stringBuilder.toString();
	}	
}
