package pl.szulc.tree.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.szulc.tree.dto.TreeNodeDto;
import pl.szulc.tree.entity.TreeNode;
@Component
public class TreeNodeMapper {
	@Autowired
	PersonMapper personMapper;
	public TreeNode mapToEntity(TreeNode treeNode, TreeNodeDto treeNodeDto) {
		if (treeNode == null) {
			treeNode = new TreeNode();
		}
		if (treeNodeDto != null) {
			treeNode.setId(treeNodeDto.getId());
			treeNode.setPerson(personMapper.mapToEntity(treeNode.getPerson(), treeNodeDto.getPersonDto()));
			treeNode.setFather(personMapper.mapToEntity(treeNode.getFather(), treeNodeDto.getFatherDto()));
			treeNode.setMother(personMapper.mapToEntity(treeNode.getMother(), treeNodeDto.getMotherDto()));
			treeNode.setSpouse(personMapper.mapToEntity(treeNode.getSpouse(), treeNodeDto.getSpouseDto()));
			treeNode.setChildrens(personMapper.mapPersonDtoListToPersonEntityList(treeNode.getChildrens(), treeNodeDto.getChildrenDto()));
			return treeNode;
		}
		return null;
	}

	public TreeNodeDto mapToDto(TreeNode treeNode) {
		if (treeNode != null) {
			TreeNodeDto treeNodeDto = new TreeNodeDto();
			treeNodeDto.setId(treeNode.getId());
			treeNodeDto.setPersonDto(personMapper.mapToDto(treeNode.getPerson()));
			treeNodeDto.setFatherDto(personMapper.mapToDto(treeNode.getFather()));
			treeNodeDto.setMotherDto(personMapper.mapToDto(treeNode.getMother()));
			treeNodeDto.setSpouseDto(personMapper.mapToDto(treeNode.getSpouse()));
			treeNodeDto.setChildrenDto(personMapper.mapPersonEntityListToPersonDtoList(treeNode.getChildrens()));
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
