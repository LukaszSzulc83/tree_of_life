package pl.szulc.tree.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.szulc.tree.dto.TreeDto;
import pl.szulc.tree.entity.Tree;


@Component
public class TreeMapper {
	
	public Tree mapToEntity(Tree tree, TreeDto treeDto) {
		if (tree == null) {
			tree = new Tree();
		}

		if (treeDto != null) {
			tree.setTreeName(treeDto.getTreeName());
			return tree;
		}
		return null;
	}

	public TreeDto mapToDto(Tree tree) {
		if (tree != null) {
			TreeDto treeDto = new TreeDto();
			treeDto.setId(tree.getId());
			treeDto.setTreeName(tree.getTreeName());
			return treeDto;
		}
		return null;
	}
	
	public List<TreeDto> mapTreeEntityListToTreeDtoList(List<Tree> trees) {
		List<TreeDto> treesDto = new ArrayList<>();
		for (int i = 0; i < trees.size(); i++) {
			treesDto.add(mapToDto(trees.get(i)));
		}
		return treesDto;
	}

}
