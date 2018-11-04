package pl.szulc.tree.mappers;

import org.springframework.stereotype.Component;

import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.dto.PersonPlusDto;

@Component
public class PersonPlusDtoToPersonDtoMapper {
	public PersonDto mapToPersonDto(PersonPlusDto personWithNodeDto) {
		if (personWithNodeDto != null) {
			PersonDto personDto = new PersonDto();
			personDto.setFirstName(personWithNodeDto.getFirstName());
			personDto.setName(personWithNodeDto.getName());
			personDto.setDateOfBirth(personWithNodeDto.getDateOfBirth());
			personDto.setPlaceOfBirth(personWithNodeDto.getPlaceOfDeath());
			personDto.setDateOfDeath(personWithNodeDto.getDateOfDeath());
			personDto.setPlaceOfDeath(personWithNodeDto.getPlaceOfDeath());
			personDto.setComments(personWithNodeDto.getComments());
			personDto.setActivity(personWithNodeDto.isActive());
			return personDto;
		}
		return null;
	}
}
