package cities.chooser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

	@Autowired
	public CityService cityService;

	@RequestMapping(path = "/suggest_cities", method = RequestMethod.GET)
	public ResponseEntity<?> suggestCities(@RequestParam("start") String start, @RequestParam("atmost") int atMost)
			throws Exception {
		String ERROR_MSG = "No City was found wstarting with word: " + start;

		List<String> suggestedCities = cityService.suggestCity(start, atMost);
		if (suggestedCities.size() != 0)
			return new ResponseEntity<List<String>>(suggestedCities, HttpStatus.OK);
		else {
			return new ResponseEntity<>(ERROR_MSG, HttpStatus.NOT_FOUND);
		}
	}

}
