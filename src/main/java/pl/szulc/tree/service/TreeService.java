package pl.szulc.tree.service;

import java.util.List;

import pl.szulc.tree.dto.TreeDto;

public interface TreeService{
	
	String createOrUpdateTree(TreeDto treeDto);
	String removeTree(TreeDto treeDto);
	List<TreeDto> showAllTrees();
	TreeDto findTreeById(Integer id);
}