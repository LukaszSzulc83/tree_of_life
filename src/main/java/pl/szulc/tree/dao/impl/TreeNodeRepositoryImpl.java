package pl.szulc.tree.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import pl.szulc.tree.dao.PersonRepository;
import pl.szulc.tree.dao.TreeNodeRepository;
import pl.szulc.tree.dao.TreeNodeRepositoryCustom;
import pl.szulc.tree.dto.TreeNodeDto;
import pl.szulc.tree.entity.Person;
import pl.szulc.tree.entity.TreeNode;
import pl.szulc.tree.mappers.TreeNodeMapper;
@Transactional
@Repository
public class TreeNodeRepositoryImpl implements TreeNodeRepositoryCustom {
	@Lazy
	@Autowired
	private TreeNodeRepository treeNodeRepository;
	@Autowired
	private TreeNodeMapper treeNodeMapper;
	@Autowired
	private PersonRepository personRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void removeTreeNode(TreeNodeDto treeNodeDto) {
		TreeNode treeNode = treeNodeRepository.findOne(treeNodeDto.getId());
		treeNodeRepository.delete(treeNodeMapper.mapToEntity(treeNode, treeNodeDto));
		treeNodeRepository.flush();
	}

	@Override
	public void updateTreeNode(TreeNodeDto treeNodeDto) {
		TreeNode treeNode = treeNodeRepository.findOne(treeNodeDto.getId());
		entityManager.merge(treeNodeMapper.mapToEntity(treeNode, treeNodeDto));
	}

	@Override
	public TreeNodeDto findTreeNodeById(Integer id) {
		if (id == null) {
			return null;
		}
		return treeNodeMapper.mapToDto(treeNodeRepository.getOne(id));
	}

	@Override
	public void createEmptyTreeNode(Integer treeNodeId) {
		TreeNode treeNode = new TreeNode();
		treeNode.setId(treeNodeId);
		treeNodeRepository.saveAndFlush(treeNode);
	}

	@Override
	public void setPersonInTreeNode(Integer treeNodeId, Integer personId) {
		Person person = personRepository.findOne(personId);
		TreeNode treeNode = treeNodeRepository.findOne(treeNodeId);
		treeNode.setPerson(person);
		treeNodeRepository.saveAndFlush(treeNode);
	}

	@Override
	public void setFatherInTreeNode(Integer treeNodeId, Integer fatherId) {
		Person father = personRepository.findOne(fatherId);
		TreeNode treeNode = treeNodeRepository.findOne(treeNodeId);
		treeNode.setFather(father);
		treeNodeRepository.saveAndFlush(treeNode);
	}

	@Override
	public void setMotherInTreeNode(Integer treeNodeId, Integer motherId) {
		Person mother = personRepository.findOne(motherId);
		TreeNode treeNode = treeNodeRepository.findOne(treeNodeId);
		treeNode.setMother(mother);
		treeNodeRepository.saveAndFlush(treeNode);
	}

	@Override
	public void setSpouseInTreeNode(Integer treeNodeId, Integer spouseId) {
		Person spouse = personRepository.findOne(spouseId);
		TreeNode treeNode = treeNodeRepository.findOne(treeNodeId);
		treeNode.setSpouse(spouse);
		treeNodeRepository.saveAndFlush(treeNode);
		
	}

	@Override
	public void setChildInTreeNode(Integer treeNodeId, Integer childId) {
		Person child = personRepository.findOne(childId);
		TreeNode treeNode = treeNodeRepository.findOne(treeNodeId);
		treeNode.getChildrens().add(child);
		treeNodeRepository.saveAndFlush(treeNode);
	}

}
