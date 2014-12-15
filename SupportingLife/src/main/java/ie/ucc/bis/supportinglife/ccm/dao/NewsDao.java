package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.NewsEntry;
import ie.ucc.bis.supportinglife.form.NewsEntryCreationForm;

import java.util.List;

public interface NewsDao extends Dao {
	public static final String NEWS_DATE_TIME_FORMAT = "dd MM yyyy";
	
	public void addNewsEntry(NewsEntryCreationForm newsEntry);
	public List<NewsEntry> getNewsItems();
}
