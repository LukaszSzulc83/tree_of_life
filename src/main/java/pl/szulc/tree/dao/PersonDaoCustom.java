package pl.szulc.tree.dao;

import java.util.List;

import pl.szulc.tree.entity.Person;

public interface PersonDaoCustom {
	
	String addPerson(Person person);
	String deletePerson(Person person);
	List<Person> findAllPerson();
	List<Person> findAllPersonFromTreeByTreeName(String treeName);
	Person findById(Integer id);
	Person findByNameSurnameAndDateOfBirth(Person person);

}
