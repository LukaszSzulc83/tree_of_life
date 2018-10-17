package pl.szulc.tree.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.szulc.tree.dao.PersonDaoCustom;
import pl.szulc.tree.dao.PersonDao;
import pl.szulc.tree.entity.Person;

@Repository
public class PersonDaoImpl implements PersonDaoCustom  {
	@Autowired
	PersonDao personDao;

	@Override
	public String addPerson(Person person) {
		personDao.saveAndFlush(person);
		return "save-OK";
	}

	@Override
	public String deletePerson(Person person) {
		personDao.delete(person);
		personDao.flush();	
		return "delete-OK";
	}

	@Override
	public List<Person> findAllPerson() {
		return personDao.findAll();
	}

	@Override
	public List<Person> findAllPersonFromTreeByTreeName(String treeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findById(Integer id) {
		return personDao.getOne(id);
	}

	@Override
	public Person findByNameSurnameAndDateOfBirth(Person person) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}