package ie.ucc.bis.supportinglife.reference;

import org.springframework.web.multipart.MultipartFile;

public class NewsItem {

	private String headline;
	private String entry;
	private String newsDate;
	private MultipartFile picture;
	private String pictureStringFormat;
	
	public NewsItem(String headline, String entry, String newsDate, String pictureStringFormat) {
		setHeadline(headline);
		setEntry(entry);
		setNewsDate(newsDate);
		setPictureStringFormat(pictureStringFormat);
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
}
