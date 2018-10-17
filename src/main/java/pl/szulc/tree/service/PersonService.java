package pl.szulc.tree.service;

import java.util.List;

import pl.szulc.tree.dto.PersonDto;

public interface PersonService{
	String addPerson(PersonDto person);
	String removePerson(PersonDto person);
	List<PersonDto> showAllPersons();
	List<PersonDto> showAllPersonsFromTreeByTreeName(String treeName);
	PersonDto findById(Integer id);
	
}