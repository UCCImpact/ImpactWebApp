package ie.ucc.bis.supportinglife.form;

import org.springframework.web.multipart.MultipartFile;



/**
 * Bean to capture information from News Entry Creation Form
 * 
 * @author TOSullivan
 */

public class NewsEntryCreationForm  {
	
	private String headline;
	private String entry;
	private String newsDate;
	private MultipartFile picture;

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

	public String toString() {
        StringBuilder stringBuilder = new StringBuilder();  
        stringBuilder.append("\n" + "headline: " + getHeadline() + "\n");
        stringBuilder.append("entry: " + getEntry()  + "\n");
        stringBuilder.append("news date: " + getNewsDate() + "\n");        
        return stringBuilder.toString();
	}	
}
