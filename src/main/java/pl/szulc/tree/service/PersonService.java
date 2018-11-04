package pl.szulc.tree.service;

import java.util.List;

import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.dto.PersonPlusDto;

public interface PersonService{
	PersonDto addPerson(PersonPlusDto personDto);
	String updatePerson(PersonDto personDto);
	String removePerson(PersonDto personDto);
	List<PersonDto> showAllPersons();
	PersonDto findPersonById(Integer id);
	PersonDto findByNameSurnameAndDateOfBirth(PersonDto personDto);
	
}