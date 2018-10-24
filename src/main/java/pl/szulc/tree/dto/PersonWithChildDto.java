package pl.szulc.tree.dto;

public class PersonWithChildDto extends PersonDto {
private Integer childID;

public Integer getChildID() {
	return childID;
}

public void setChildID(Integer childID) {
	this.childID = childID;
}
}
