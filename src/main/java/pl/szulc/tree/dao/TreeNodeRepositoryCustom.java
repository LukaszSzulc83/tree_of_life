package pl.szulc.tree.dao;

import pl.szulc.tree.dto.TreeNodeDto;

public interface TreeNodeRepositoryCustom {
	void createEmptyTreeNode(Integer treeNodeId);
	void setPersonInTreeNode(Integer treeNodeId, Integer personId);
	void setFatherInTreeNode(Integer treeNodeId, Integer fatherId);
	void setMotherInTreeNode(Integer treeNodeId, Integer motherId);
	void setSpouseInTreeNode(Integer treeNodeId, Integer personId);
	void setChildInTreeNode(Integer treeNodeId, Integer personId);
	void removeTreeNode(TreeNodeDto treeNodeDto);
	void updateTreeNode(TreeNodeDto treeNodeDto);
	TreeNodeDto findTreeNodeById(Integer id);
}
