package pl.szulc.tree.service;

import java.util.List;

import pl.szulc.tree.dto.NewNodeDto;
import pl.szulc.tree.dto.TreeDto;
import pl.szulc.tree.dto.TreeNodeDto;

public interface TreeService{
	
	String createTree(TreeDto treeDto);
	String updateTree(TreeDto treeDto);
	String removeTree(TreeDto treeDto);
	List<TreeDto> showAllTrees();
	TreeDto findTreeById(Integer id);
	void addFirstNodeToTree(NewNodeDto newNodeDto);
	void addParentNodeToTree(NewNodeDto newNodeDto);
	void addSpouseNodeToTree(NewNodeDto newNodeDto);
	void addChildNodeToTree(NewNodeDto newNodeDto);
	List<TreeNodeDto> findAllNodesOfTree(Integer treeId);
}