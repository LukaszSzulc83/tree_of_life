package pl.szulc.tree.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.dto.PersonWithChildDto;
import pl.szulc.tree.service.PersonService;

@RestController
@ResponseBody
public class PersonRestController {

	@Autowired
	PersonService personService; 
	
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public String addPerson(@RequestBody PersonDto personDto) {
		return personService.addOrUpdatePerson(personDto);
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public String addParent(@RequestBody PersonWithChildDto personWithChildDto) {
		return personService.addParentToChild(personWithChildDto);
	}
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PersonDto getProjectById(@PathVariable("id") Integer personId) {
        return personService.findPersonById(personId);
    }
	
	@RequestMapping(value = "/person", method = RequestMethod.DELETE)
	public String deletePerson(@RequestBody PersonDto personDto) {
		return personService.removePerson(personDto);
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public List<PersonDto> getAllPerson(){
		return personService.showAllPersons();
	}
}
