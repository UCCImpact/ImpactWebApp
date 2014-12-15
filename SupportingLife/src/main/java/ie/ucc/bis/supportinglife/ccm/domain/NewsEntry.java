package ie.ucc.bis.supportinglife.ccm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Domain class capturing a news entry of the SL project
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_news")
public class NewsEntry implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -7988127078922262992L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;

	@Column(name="headline")
	private String headline;
	
	@Column(name="entry")
	private String entry;
	
	@Column(name="news_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date newsDate;
	
	@Column(name="picture")
	@Lob
	private byte[] picture;

	public NewsEntry() {}

	public NewsEntry(String entry, String headline, Date newsDate, byte[] picture) {
		setHeadline(headline);
		setEntry(entry);
		setNewsDate(newsDate);
		setPicture(picture);
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

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
}
