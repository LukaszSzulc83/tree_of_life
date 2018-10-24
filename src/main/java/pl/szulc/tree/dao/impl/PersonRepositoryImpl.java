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
import pl.szulc.tree.entity.Person;

@Transactional
@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom {
	@Lazy
	@Autowired
	private PersonRepository personRepository;
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public String addPerson(Person person) {
		personRepository.saveAndFlush(person);
		return "save-OK";
	}

	@Override
	public String deletePerson(Person person) {
		personRepository.delete(person);
		personRepository.flush();
		return "delete-OK";
	}

	@Override
	public List<Person> findAllPerson() {
		return personRepository.findAll();
	}

	@Override
	public List<Person> findAllPersonFromTreeByTreeName(String treeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findById(Integer id) {
		if(id == null) {
			return null;
		} 
		return personRepository.getOne(id);
	}

	@Override
	public Person findByNameSurnameAndDateOfBirth(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePerson(Person person) {
		personRepository.saveAndFlush(person);
		return "update-OK";
	}

	@Override
	public String addListOfPerson(List<Person> persons) {
		personRepository.save(persons);
		personRepository.flush();
		return "Tree update - OK";
	}

	@Override
	public String removeAllPersonsFromTree(Integer treeId) {
		return null;
	}

}