package pl.szulc.tree.dto;

import java.util.List;

public class TreeNodeDto {
	private Integer id;
	private PersonDto personDto;
	private PersonDto fatherDto;
	private PersonDto motherDto;
	private PersonDto spouseDto;
	private List<PersonDto> childrenDto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PersonDto getPersonDto() {
		return personDto;
	}

	public void setPersonDto(PersonDto personDto) {
		this.personDto = personDto;
	}

	public PersonDto getFatherDto() {
		return fatherDto;
	}

	public void setFatherDto(PersonDto fatherDto) {
		this.fatherDto = fatherDto;
	}

	public PersonDto getMotherDto() {
		return motherDto;
	}

	public void setMotherDto(PersonDto motherDto) {
		this.motherDto = motherDto;
	}

	public PersonDto getSpouseDto() {
		return spouseDto;
	}

	public void setSpouseDto(PersonDto spouseDto) {
		this.spouseDto = spouseDto;
	}

	public List<PersonDto> getChildrenDto() {
		return childrenDto;
	}

	public void setChildrenDto(List<PersonDto> childrenDto) {
		this.childrenDto = childrenDto;
	}
	
}
