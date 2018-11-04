package pl.szulc.tree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.szulc.tree.dao.TreeNodeRepository;
import pl.szulc.tree.dto.PersonDto;
import pl.szulc.tree.dto.PersonPlusDto;
import pl.szulc.tree.dto.TreeNodeDto;
import pl.szulc.tree.service.PersonService;
import pl.szulc.tree.service.TreeNodeService;
import pl.szulc.tree.service.TreeService;

@Service
public class TreeNodeServiceImpl implements TreeNodeService {
	@Autowired
	TreeNodeRepository treeNodeRepository;
    @Autowired
	PersonService personService;
    @Autowired
    TreeService treeService;
	Integer personId = null;
	Integer treeNodeId = null;
	@Override
	public void createEmptyNode(Integer treeNodeId) {
		treeNodeRepository.createEmptyTreeNode(treeNodeId);
	}

	@Override
	public void addPersonToNode(PersonPlusDto personWithNodeDto) {
		PersonDto personDto = personService.addPerson(personWithNodeDto);
		this.personId = personDto.getId();
		this.treeNodeId = personWithNodeDto.getNodeId();
		treeNodeRepository.setPersonInTreeNode(treeNodeId, personId);
	}


	@Override
	public void addFatherToNode(PersonPlusDto personWithNodeDto) {
		addPersonToNode(personWithNodeDto);
		treeNodeRepository.setFatherInTreeNode(treeNodeId/2, personId);
	}
	
	@Override
	public void addMotherToNode(PersonPlusDto personWithNodeDto) {
		addPersonToNode(personWithNodeDto);
		treeNodeRepository.setMotherInTreeNode((treeNodeId-1)/2, personId);
	}

	@Override
	public void addSpouseToNode(PersonPlusDto personWithNodeDto) {
		addPersonToNode(personWithNodeDto);
		if(personWithNodeDto.isMen()) {
		treeNodeRepository.setSpouseInTreeNode(treeNodeId-1, personId);
		treeNodeRepository.setFatherInTreeNode(treeNodeId/2, personId);
		} else {
		treeNodeRepository.setSpouseInTreeNode(treeNodeId+1, personId);	
		treeNodeRepository.setMotherInTreeNode((treeNodeId-1)/2, personId);
		}
	}

	@Override
	public void addChildToNode(PersonPlusDto personWithNodeDto) {
		addPersonToNode(personWithNodeDto);
		treeNodeRepository.setChildInTreeNode(treeNodeId, personId);	
	}

	@Override
	public void addChildrenToNode(Integer treeNodeId, List<Integer> childrenId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TreeNodeDto findTreeNodeById(Integer treeNodeId) {
		return treeNodeRepository.findTreeNodeById(treeNodeId);
	}

	
	


}
