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
import pl.szulc.tree.dto.PersonPlusDto;
import pl.szulc.tree.service.PersonService;
import pl.szulc.tree.service.TreeNodeService;

@RestController
@ResponseBody
public class PersonRestController {

	@Autowired
	PersonService personService; 
	
	@Autowired
	TreeNodeService treeNodeService;
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public void addPerson(@RequestBody PersonPlusDto personWithNodeDto) {
		treeNodeService.addPersonToNode(personWithNodeDto);
	}
	
	@RequestMapping(value = "/parent", method = RequestMethod.POST)
	public void addParent(@RequestBody PersonPlusDto personWithNodeDto) {
		if (personWithNodeDto.isMen()) {
		treeNodeService.addFatherToNode(personWithNodeDto);
		} else {
		treeNodeService.addMotherToNode(personWithNodeDto);	
		}
	}
	
	@RequestMapping(value = "/spouse", method = RequestMethod.POST)
	public void addSpouse(@RequestBody PersonPlusDto personWithNodeDto) {
		treeNodeService.addSpouseToNode(personWithNodeDto);
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public String updatePerson(@RequestBody PersonDto personDto) {
		return personService.updatePerson(personDto);
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
