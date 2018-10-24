package pl.szulc.tree.dao;

import java.util.List;

import pl.szulc.tree.entity.Person;

public interface PersonRepositoryCustom {
	
	String addPerson(Person person);
	String deletePerson(Person person);
	String updatePerson(Person person);
	List<Person> findAllPerson();
	List<Person> findAllPersonFromTreeByTreeName(String treeName);
	Person findById(Integer id);
	Person findByNameSurnameAndDateOfBirth(Person person);
	String addListOfPerson (List<Person> persons);
	String removeAllPersonsFromTree(Integer treeId);

}
