package pl.szulc.tree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.szulc.tree.dao.PersonDaoCustom;
import pl.szulc.tree.dao.PersonDaoCustom;
import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.entity.Person;
import pl.szulc.tree.mappers.PersonMapper;
import pl.szulc.tree.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonDaoCustom personRepository;
	
	@Autowired
	PersonMapper personMapper;

	@Override
	public String addPerson(PersonDto personDto) {
		Person person = personMapper.mapToEntity(null, personDto);
		return personRepository.addPerson(person);
	}

	@Override
	public String removePerson(PersonDto personDto) {
		Person person = personRepository.findById(personDto.getId());
		return personRepository.deletePerson(person);
	}

	@Override
	public List<PersonDto> showAllPersons() {
		return personMapper.mapPersonEntityListToPersonDtoList(personRepository.findAllPerson());
	}

	@Override
	public PersonDto findById(Integer id) {
		return personMapper.mapToDto(personRepository.findById(id));
	}

	@Override
	public List<PersonDto> showAllPersonsFromTreeByTreeName(String treeName) {
		// TODO Auto-generated method stub
		return null;
	}

}