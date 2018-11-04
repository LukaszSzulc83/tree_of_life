package pl.szulc.tree.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.szulc.tree.dto.TreeNodeDto;
import pl.szulc.tree.entity.TreeNode;
@Component
public class TreeNodeMapper {
	
	
	public TreeNode mapToEntity(TreeNode treeNode, TreeNodeDto treeNodeDto) {
		if (treeNode == null) {
			treeNode = new TreeNode();
		}

		if (treeNodeDto != null) {
			treeNode.setId(treeNodeDto.getId());
			return treeNode;
		}
		return null;
	}

	public TreeNodeDto mapToDto(TreeNode treeNode) {
		if (treeNode != null) {
			TreeNodeDto treeNodeDto = new TreeNodeDto();
			treeNodeDto.setId(treeNode.getId());
			return treeNodeDto;
		}
		return null;
	}
	
	public List<TreeNodeDto> mapTreeNodeEntityListToTreeNodeDtoList(List<TreeNode> treeNodes) {
		List<TreeNodeDto> treeNodesDto = new ArrayList<>();
		for (int i = 0; i < treeNodes.size(); i++) {
			treeNodesDto.add(mapToDto(treeNodes.get(i)));
		}
		return treeNodesDto;
	}

}
