package pl.szulc.tree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.szulc.tree.dao.PersonRepositoryCustom;
import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.dto.PersonWithChildDto;
import pl.szulc.tree.entity.Person;
import pl.szulc.tree.mappers.PersonMapper;
import pl.szulc.tree.mappers.PersonWithChildDtoToPersonDtoMapper;
import pl.szulc.tree.mappers.TreeMapper;
import pl.szulc.tree.service.PersonService;
import pl.szulc.tree.service.TreeService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepositoryCustom personRepository;
	
	@Autowired
	PersonMapper personMapper;
	
	@Autowired
	PersonWithChildDtoToPersonDtoMapper personWithChildDtoToPersonDtoMapper;
	
	@Autowired
	TreeService treeService;
	
	@Autowired
    TreeMapper treeMapper;
	
	@Override
	public String addOrUpdatePerson(PersonDto personDto) {
		Person existingPerson = personRepository.findById(personDto.getId());
		Person person = personMapper.mapToEntity(existingPerson, personDto);
		person.setTree(treeMapper.mapToEntity(null, treeService.findTreeById(personDto.getTreeID())));
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
	public PersonDto findPersonById(Integer id) {
		return personMapper.mapToDto(personRepository.findById(id));
	}

	@Override
	public List<PersonDto> showAllPersonsFromTreeByTreeName(String treeName) {
		// TODO Auto-generated method stub
		return null;
	}

	private PersonDto setPersonIdOnTree(PersonDto personDto) {
		return null;
	}

	@Override
	public String addParentToChild(PersonWithChildDto personWithChildDto) {
		PersonDto parentDto = personWithChildDtoToPersonDtoMapper.mapToPersonDto(personWithChildDto);
		addOrUpdatePerson(parentDto);
		PersonDto childDto = findPersonById(personWithChildDto.getChildID());
		if (personWithChildDto.isMen()) {
			childDto.setFatherID(Math.multiplyExact(2, childDto.getPersonOnTreeID()));
		} else {
			childDto.setMotherID(Math.addExact(Math.multiplyExact(2, childDto.getPersonOnTreeID()), 1));
		}
		addOrUpdatePerson(childDto);
		return "parentAddToChild-OK";
	}

	@Override
	public String addSpouse(PersonDto personDto) {
		if (personDto.getSpouseID() == 1) {
			List<Person> persons = personRepository.findAllPerson();
			List<PersonDto> personsDto = personMapper.mapPersonEntityListToPersonDtoList(persons);
			personsDto = setNewPersonOnTreeIdInAllPersonsOfTree(personsDto);
			personRepository.addListOfPerson(personMapper.mapPersonDtoListToPersonEntityList(persons, personsDto));
			if (personDto.isMen()) {
				personDto.setPersonOnTreeID(2);
			} else {
				personDto.setPersonOnTreeID(3);
			}
			return addOrUpdatePerson(personDto);
		} else
			//TODO
		return addOrUpdatePerson(personDto);
	}

	private List<PersonDto> setNewPersonOnTreeIdInAllPersonsOfTree(List<PersonDto> personsDto) {
		for (int i = 0; i < personsDto.size(); i++) {
			if (personsDto.get(i).isMen()) {
				personsDto.get(i).setPersonOnTreeID(2 * i);
			} else {
				personsDto.get(i).setPersonOnTreeID(2 * i - 1);
			}
		}
		return personsDto;
	}

}