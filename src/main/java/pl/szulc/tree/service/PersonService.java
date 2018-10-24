package pl.szulc.tree.service;

import java.util.List;

import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.dto.PersonWithChildDto;

public interface PersonService{
	String addOrUpdatePerson(PersonDto person);
	String addParentToChild(PersonWithChildDto personWithChild);
	String removePerson(PersonDto person);
	List<PersonDto> showAllPersons();
	List<PersonDto> showAllPersonsFromTreeByTreeName(String treeName);
	PersonDto findPersonById(Integer id);
	String addSpouse (PersonDto personDto);
	
}