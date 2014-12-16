package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.NewsEntry;
import ie.ucc.bis.supportinglife.form.NewsEntryCreationForm;
import ie.ucc.bis.supportinglife.utilities.DateUtilities;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl implements NewsDao {

	Logger log = Logger.getLogger(NewsDaoImpl.class); 
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addNewsEntry(NewsEntryCreationForm newsEntryDetails) {
		NewsEntry newsEntry = null;
		
		try {
			// remove dashes from news date
			newsEntryDetails.setNewsDate(newsEntryDetails.getNewsDate().replace("-", " "));
	
			byte[] picture = newsEntryDetails.getPicture().getBytes();
			
			newsEntry = new NewsEntry(newsEntryDetails.getEntry(), newsEntryDetails.getHeadline(),
					DateUtilities.parseDate(newsEntryDetails.getNewsDate(), NewsDao.NEWS_DATE_TIME_FORMAT),
					picture);
		} catch (ParseException e) {
			log.error("Error parsing the news entry date field");
			e.printStackTrace();
		}
		catch (IOException e) {
			log.error("Error obtaining byte array of picture file");
			e.printStackTrace();
		}

		if (newsEntry != null) {
			entityManager.persist(newsEntry);
			// save to DB
			entityManager.flush();
			entityManager.clear();
		}
	}

	@Override
	public List<NewsEntry> getNewsItems() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<NewsEntry> criteriaQuery = criteriaBuilder.createQuery(NewsEntry.class);
		Root<NewsEntry> root = criteriaQuery.from(NewsEntry.class);
					
		criteriaQuery.select(root);
	    TypedQuery<NewsEntry> typedQuery = entityManager.createQuery(criteriaQuery);
	    
	    List<NewsEntry> newsEntries = new ArrayList<NewsEntry>();
	    newsEntries = typedQuery.getResultList();		
		return newsEntries;
	}
}
