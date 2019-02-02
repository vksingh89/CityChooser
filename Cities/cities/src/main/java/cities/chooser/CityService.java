package cities.chooser;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CityService {
@Autowired
public CityDAO cityDAO;
Logger logger = LoggerFactory.getLogger(CityService.class);
public List<String> suggestCity(String start, int atMost) throws Exception{
	logger.info("In suggestCity() method");
	List<String> citynameSuggestions= new ArrayList<String>();
	if(start.isEmpty()) {
		throw new Exception("Start character set can not be empty");
	}
	if(Integer.toString(atMost)==null || atMost==0) {
		throw new Exception("count can not be zero");
	}
	citynameSuggestions=cityDAO.getCityName(start, atMost);
	
	return citynameSuggestions;
}
}
