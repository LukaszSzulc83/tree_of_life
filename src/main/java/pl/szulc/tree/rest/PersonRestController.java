package pl.szulc.tree.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.service.PersonService;

@RestController
public class PersonRestController {

	@Autowired
	PersonService personService; 
	
	
	@RequestMapping(value = "/persons", method = RequestMethod.POST)
	public String addPerson(@RequestBody PersonDto personDto) {
		return personService.addPerson(personDto);
	}
}
