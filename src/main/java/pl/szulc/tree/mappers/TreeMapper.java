package pl.szulc.tree.mappers;

import pl.szulc.tree.dto.TreeDto;
import pl.szulc.tree.entity.Tree;

public class TreeMapper {
public Tree mapToEntity(Tree tree, TreeDto treeDto) {	
		if (tree == null) {
			tree = new Tree();
		}
		
		if (treeDto != null) {
			tree.setId(treeDto.getId());
			tree.setTreeName(treeDto.getTreeName());
			return tree;
		}
		return null;
	}
	
	public TreeDto mapToDto(Tree tree){
		if (tree != null) {
			TreeDto treeDto = new TreeDto();
			treeDto.setId(tree.getId());
			treeDto.setTreeName(tree.getTreeName());
			return treeDto;
		}
		return null;
	}
	
}
