package pl.szulc.tree.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import pl.szulc.tree.dao.PersonRepository;
import pl.szulc.tree.dao.PersonRepositoryCustom;
import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.entity.Person;
import pl.szulc.tree.mappers.PersonMapper;

@Transactional
@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom {
	@Lazy
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PersonMapper personMapper;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public PersonDto addPerson(PersonDto personDto) { 
	    Person person = null;
	    person = personMapper.mapToEntity(person, personDto);
		personRepository.saveAndFlush(person);
		return personMapper.mapToDto(person);
	}

	@Override
	public String deletePerson(PersonDto personDto) {
		Person person = personRepository.findOne(personDto.getId());
		personRepository.delete(person);
		personRepository.flush();
		return "delete-OK";
	}

	@Override
	public List<PersonDto> findAllPerson() {
		return personMapper.mapPersonEntityListToPersonDtoList(personRepository.findAll());
	}

	@Override
	public List<PersonDto> findAllPersonFromTreeByTreeName(String treeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDto findById(Integer id) {
		if(id == null) {
			return null;
		} 
		return personMapper.mapToDto(personRepository.getOne(id));
	}

	@Override
	public PersonDto findByNameSurnameAndDateOfBirth(PersonDto personDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePerson(PersonDto personDto) {
		Person person = personRepository.findOne(personDto.getId());
		entityManager.merge(personMapper.mapToEntity(person, personDto));
		return "update-OK";
	}

}