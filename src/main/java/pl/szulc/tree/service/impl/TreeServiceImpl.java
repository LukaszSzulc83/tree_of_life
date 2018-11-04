package pl.szulc.tree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.szulc.tree.dao.TreeRepository;
import pl.szulc.tree.dto.NewNodeDto;
import pl.szulc.tree.dto.TreeDto;
import pl.szulc.tree.dto.TreeNodeDto;
import pl.szulc.tree.mappers.TreeMapper;
import pl.szulc.tree.mappers.TreeNodeMapper;
import pl.szulc.tree.service.PersonService;
import pl.szulc.tree.service.TreeNodeService;
import pl.szulc.tree.service.TreeService;

@Service
public class TreeServiceImpl implements TreeService {
	@Autowired
	TreeRepository treeRepository;
	@Autowired
	TreeMapper treeMapper;
	@Autowired
	TreeNodeService treeNodeService;
	@Autowired
	TreeNodeMapper treeNodeMapper;
	@Autowired
	PersonService personService;

	@Override
	public String createTree(TreeDto treeDto) {
		return treeRepository.createTree(treeDto);
	}

	@Override
	public String updateTree(TreeDto treeDto) {
		return treeRepository.updateTree(treeDto);
	}

	@Override
	public String removeTree(TreeDto treeDto) {
		return treeRepository.cutTree(treeDto);
	}

	@Override
	public List<TreeDto> showAllTrees() {
		return null;
	}

	@Override
	public TreeDto findTreeById(Integer id) {
		return treeRepository.findTreeById(id);
	}

	@Override
	public void addFirstNodeToTree(NewNodeDto newNodeDto) {
		Integer newNodeId = null;
		Integer treeId = newNodeDto.getTreeId();
		TreeDto treeDto = findTreeById(treeId);
		if (treeDto.getListOfFamilyMembers() == null) {
			newNodeId = 1;
		}
		treeNodeService.createEmptyNode(newNodeId);
		treeRepository.addNodeToTree(treeId, newNodeId);
	}

	@Override
	public void addParentNodeToTree(NewNodeDto newNodeDto) {
		Integer newNodeId = null;
		Integer treeId = newNodeDto.getTreeId();
		Integer selectedNodeId = newNodeDto.getNodeId();

		if (newNodeDto.isMen()) {
			newNodeId = Math.multiplyExact(selectedNodeId, 2);
		} else {
			newNodeId = Math.addExact(Math.multiplyExact(selectedNodeId, 2), 1);
		}

		treeNodeService.createEmptyNode(newNodeId);
		treeRepository.addNodeToTree(treeId, newNodeId);
	}

	@Override
	public void addSpouseNodeToTree(NewNodeDto newNodeDto) {
		Integer newNodeId = null;
		Integer treeId = newNodeDto.getTreeId();
		Integer selectedNodeId = newNodeDto.getNodeId();
		if (selectedNodeId == 1 ) {
			List<TreeNodeDto> familyMemberListDto = treeRepository.findAllNodesOfTree(treeId);
			List<TreeNodeDto> modificatedMemberListDto = setModificatedFamilyMemberList(familyMemberListDto);
            treeRepository.addNodeListToTree(treeId, modificatedMemberListDto);
            TreeNodeDto treeNodeDto = treeNodeService.findTreeNodeById(selectedNodeId);
			if (treeNodeDto.getPersonDto().isMen()) {
				newNodeId = 3;
			} else {
				newNodeId = 2;
			}
			treeNodeService.createEmptyNode(newNodeId);
			treeRepository.addNodeToTree(treeId, newNodeId);
		} else {
			TreeNodeDto treeNodeDto = treeNodeService.findTreeNodeById(selectedNodeId);
			if (treeNodeDto.getPersonDto().isMen()) {
				newNodeId = selectedNodeId + 1;
			} else {
				newNodeId = selectedNodeId - 1;
			}
			treeNodeService.createEmptyNode(newNodeId);
			treeRepository.addNodeToTree(treeId, newNodeId);
		}
	}

	@Override
	public void addChildNodeToTree(NewNodeDto newNodeDto) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<TreeNodeDto> findAllNodesOfTree(Integer treeId) {
		return null;
	}

//
//	@Override
//	public String addSpouse(PersonDto personDto) {
//		if (personDto.getSpouseID() == 1) {
//			List<Person> persons = personRepository.findAllPerson();
//			List<PersonDto> personsDto = personMapper.mapPersonEntityListToPersonDtoList(persons);
//			personsDto = setNewPersonOnTreeIdInAllPersonsOfTree(personsDto);
//			personRepository.addListOfPerson(personMapper.mapPersonDtoListToPersonEntityList(persons, personsDto));
//			if (personDto.isMen()) {
//				personDto.setPersonOnTreeID(2);
//			} else {
//				personDto.setPersonOnTreeID(3);
//			}
//			return addOrUpdatePerson(personDto);
//		} else
//			//TODO
//		return addOrUpdatePerson(personDto);
//	}
//
	private List<TreeNodeDto> setModificatedFamilyMemberList(List<TreeNodeDto> familyMemberListDto) {
		for (int i = 0; i < familyMemberListDto.size(); i++) {
			if (familyMemberListDto.get(i).getPersonDto().isMen()) {
				if (i < 1) {
					familyMemberListDto.get(i).setId(2);
				}
				familyMemberListDto.get(i).setId(2 * i);
			} else {
				if (i < 1) {
					familyMemberListDto.get(i).setId(3);
				}
				familyMemberListDto.get(i).setId(2 * i - 1);
			}
		}
		return familyMemberListDto;
	}

}