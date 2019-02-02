package cities.chooser;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDAO {
	@Autowired
	public EntityManager em;
	Logger logger = LoggerFactory.getLogger(CityDAO.class);
	@SuppressWarnings("unchecked")
	public List<String>  getCityName(String start, int atMost) {
		logger.info("In getCityName() method");
		try {
			Query query= em.createNamedQuery("CityEntity.fetchCityName");
			query.setParameter("keyword", start+"%");
			query.setMaxResults(atMost);
			List<String> suggestedCityName=(List<String>) query.getResultList();
			if(suggestedCityName.size()==0) {
			logger.info("No City starting wih word <"+start+"> was found");}
			return suggestedCityName;
			/*
			 * else throw new Exception("No City starting wih word <"+start+"> was found");
			 */
		}catch(Exception e) {
			logger.error("Error while fetching city name suggestion from DB: "+e);
			return null;
		}

		
	}

}
