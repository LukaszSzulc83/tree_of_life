package pl.szulc.tree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.szulc.tree.dao.PersonRepositoryCustom;
import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.dto.PersonPlusDto;
import pl.szulc.tree.mappers.PersonMapper;
import pl.szulc.tree.mappers.PersonPlusDtoToPersonDtoMapper;
import pl.szulc.tree.mappers.TreeMapper;
import pl.szulc.tree.service.PersonService;
import pl.szulc.tree.service.TreeNodeService;
import pl.szulc.tree.service.TreeService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepositoryCustom personRepository;
	
	@Autowired
	PersonMapper personMapper;
	@Autowired
	TreeNodeService treeNodeService;
	@Autowired
	TreeService treeService;
	@Autowired
	PersonPlusDtoToPersonDtoMapper personWithNodeDtoToPersonDtoMapper; 
	@Autowired
    TreeMapper treeMapper;
	
	@Override
	public PersonDto addPerson(PersonPlusDto personWithNodeDto) {
		PersonDto personDto = personWithNodeDtoToPersonDtoMapper.mapToPersonDto(personWithNodeDto);
		return personRepository.addPerson(personDto);
	}
	
	@Override
	public String updatePerson(PersonDto personDto) {
		return personRepository.updatePerson(personDto);
	}

	@Override
	public String removePerson(PersonDto personDto) {
		return personRepository.deletePerson(personDto);
	}

	@Override
	public List<PersonDto> showAllPersons() {
		return personRepository.findAllPerson();
	}

	@Override
	public PersonDto findPersonById(Integer id) {
		return personRepository.findById(id);
	}

	@Override
	public PersonDto findByNameSurnameAndDateOfBirth(PersonDto personDto) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<PersonDto> showAllPersonsFromTreeByTreeName(String treeName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private PersonDto setPersonIdOnTree(PersonDto personDto) {
//		return null;
//	}

//	

}