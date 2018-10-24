package pl.szulc.tree.dto;

import java.util.List;

public class TreeDto {
	private Integer id;
	private String treeName;
	private List<PersonDto>listOfFamilyMembers;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	public List<PersonDto> getListOfFamilyMembers() {
		return listOfFamilyMembers;
	}
	public void setListOfFamilyMembers(List<PersonDto> listOfFamilyMembers) {
		this.listOfFamilyMembers = listOfFamilyMembers;
	}
	
	
}
