package pl.szulc.tree.dao;

import java.util.List;

import pl.szulc.tree.dto.PersonDto;

public interface PersonRepositoryCustom {
	
	PersonDto addPerson(PersonDto person);
	String deletePerson(PersonDto person);
	String updatePerson(PersonDto person);
	List<PersonDto> findAllPerson();
	List<PersonDto> findAllPersonFromTreeByTreeName(String treeName);
	PersonDto findById(Integer id);
	PersonDto findByNameSurnameAndDateOfBirth(PersonDto person);
}
