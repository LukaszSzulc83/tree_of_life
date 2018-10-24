package pl.szulc.tree.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.entity.Person;

@Component
public class PersonMapper {
	
	public Person mapToEntity(Person person, PersonDto personDto) {

		if (person == null) {
			person = new Person();
		}

		if (personDto != null) {
			person.setFirstName(personDto.getFirstName());
			person.setName(personDto.getName());
			person.setDateOfBirth(personDto.getDateOfBirth());
			person.setPlaceOfBirth(personDto.getPlaceOfBirth());
			person.setDateOfDeath(personDto.getDateOfDeath());
			person.setPlaceOfDeath(personDto.getPlaceOfDeath());
			person.setComments(personDto.getComments());
			person.setActivity(personDto.isActive());
			person.setPersonOnTreeID(personDto.getPersonOnTreeID());
			person.setMotherID(personDto.getMotherID());
			person.setFatherID(personDto.getFatherID());
			person.setSpouseID(personDto.getSpouseID());
			return person;
		}
		return null;
	}

	public PersonDto mapToDto(Person person) {
		if (person != null) {
			PersonDto personDto = new PersonDto();
			personDto.setId(person.getId());
			personDto.setFirstName(person.getFirstName());
			personDto.setName(person.getName());
			personDto.setDateOfBirth(person.getDateOfBirth());
			personDto.setPlaceOfBirth(person.getPlaceOfDeath());
			personDto.setDateOfDeath(person.getDateOfDeath());
			personDto.setPlaceOfDeath(person.getPlaceOfDeath());
			personDto.setComments(person.getComments());
			personDto.setActivity(person.isActive());
			personDto.setPersonOnTreeID(person.getPersonOnTreeID());
			personDto.setMotherID(person.getMotherID());
			personDto.setFatherID(person.getFatherID());
			personDto.setSpouseID(person.getSpouseID());
			personDto.setTreeID(person.getTree().getId());
			return personDto;
		}
		return null;
	}

	public List<PersonDto> mapPersonEntityListToPersonDtoList(List<Person> persons) {
		List<PersonDto> personsDto = new ArrayList<>();
		for (int i = 0; i < persons.size(); i++) {
			personsDto.add(mapToDto(persons.get(i)));
		}
		return personsDto;
	}

	public List<Person> mapPersonDtoListToPersonEntityList(List<Person> persons, List<PersonDto> personsDto) {
		for (int i = 0; i < personsDto.size(); i++) {
			persons.add(mapToEntity(persons.get(i), personsDto.get(i)));
		}
		return persons;
	}
}
