package pl.szulc.tree.service;

import java.util.List;

import pl.szulc.tree.dto.PersonPlusDto;
import pl.szulc.tree.dto.TreeNodeDto;

public interface TreeNodeService {
 void createEmptyNode(Integer nodeId);
 void addPersonToNode(PersonPlusDto personWithNodeDto);
 void addFatherToNode(PersonPlusDto personWithNodeDto);
 void addMotherToNode(PersonPlusDto personWithNodeDto);
 void addSpouseToNode(PersonPlusDto personWithNodeDto);
 void addChildToNode(PersonPlusDto personWithNodeDto);
 void addChildrenToNode(Integer treeNodeId, List<Integer> childrenId);
 TreeNodeDto findTreeNodeById(Integer treeNodeId);
}
