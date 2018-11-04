package pl.szulc.tree.dao;

import java.util.List;

import pl.szulc.tree.dto.TreeDto;
import pl.szulc.tree.dto.TreeNodeDto;

public interface TreeRepositoryCustom {
	String createTree(TreeDto treeDto);
	String cutTree(TreeDto treeDto);
	String updateTree(TreeDto treeDto);
	List<TreeDto> findAllTrees();
	TreeDto findTreeById(Integer id);
	List<TreeNodeDto> findAllNodesOfTree(Integer treeId);
	void addNodeToTree(Integer treeId, Integer treeNodeId);
	void addNodeListToTree(Integer treeId, List<TreeNodeDto> treeNodeIdList);
}
