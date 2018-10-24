package pl.szulc.tree.mappers;

import org.springframework.stereotype.Component;

import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.dto.PersonWithChildDto;
@Component
public class PersonWithChildDtoToPersonDtoMapper {
	public PersonDto mapToPersonDto(PersonWithChildDto personWithChildDto){
		if (personWithChildDto != null) {
			PersonDto personDto = new PersonDto();
			personDto.setFirstName(personWithChildDto.getFirstName());
			personDto.setName(personWithChildDto.getName());
			personDto.setDateOfBirth(personWithChildDto.getDateOfBirth());
			personDto.setPlaceOfBirth(personWithChildDto.getPlaceOfDeath());
			personDto.setDateOfDeath(personWithChildDto.getDateOfDeath());
			personDto.setPlaceOfDeath(personWithChildDto.getPlaceOfDeath());
			personDto.setComments(personWithChildDto.getComments());
			personDto.setActivity(personWithChildDto.isActive());
			personDto.setPersonOnTreeID(personWithChildDto.getPersonOnTreeID());
			personDto.setMotherID(personWithChildDto.getMotherID());
			personDto.setFatherID(personWithChildDto.getFatherID());
			return personDto;
		}
		return null;
	}
}
