package pl.szulc.tree.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class TreeNode {
	@Id
	private Integer id;
	@OneToOne
	private Person person;
	@OneToOne
	private Person father;
	@OneToOne
	private Person mother;
	@OneToOne
	private Person spouse;
	@OneToMany
	private List<Person> childrens;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Person getFather() {
		return father;
	}
	public void setFather(Person father) {
		this.father = father;
	}
	public Person getMother() {
		return mother;
	}
	public void setMother(Person mother) {
		this.mother = mother;
	}
	public Person getSpouse() {
		return spouse;
	}
	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}
	public List<Person> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<Person> childrens) {
		this.childrens = childrens;
	}
}
