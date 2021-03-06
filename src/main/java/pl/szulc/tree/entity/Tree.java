package pl.szulc.tree.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tree{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "TREE_NAME", nullable = false)
	private String treeName;
	@OneToMany(mappedBy = "tree")
	private List<TreeNode>listOfFamilyMembers;
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	public List<TreeNode> getListOfFamilyMembers() {
		return listOfFamilyMembers;
	}
	public void setListOfFamilyMembers(List<TreeNode> listOfFamilyMembers) {
		this.listOfFamilyMembers = listOfFamilyMembers;
	}
		
}
