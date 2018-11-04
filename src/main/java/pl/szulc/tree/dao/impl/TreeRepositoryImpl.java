package pl.szulc.tree.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import pl.szulc.tree.dao.TreeNodeRepository;
import pl.szulc.tree.dao.TreeRepository;
import pl.szulc.tree.dao.TreeRepositoryCustom;
import pl.szulc.tree.dto.TreeDto;
import pl.szulc.tree.dto.TreeNodeDto;
import pl.szulc.tree.entity.Tree;
import pl.szulc.tree.entity.TreeNode;
import pl.szulc.tree.mappers.TreeMapper;
import pl.szulc.tree.mappers.TreeNodeMapper;
@Transactional
@Repository
public class TreeRepositoryImpl implements TreeRepositoryCustom {

	@Lazy
	@Autowired
	private TreeRepository treeRepository;
	
	@Autowired
	private TreeMapper treeMapper;
	
	@Autowired
	private TreeNodeRepository treeNodeRepository;
	
	@Autowired
	private TreeNodeMapper treeNodeMapper;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public String createTree(TreeDto treeDto) {
		treeRepository.saveAndFlush(treeMapper.mapToEntity(null, treeDto));
		return "create tree - OK";
	}

	@Override
	public String cutTree(TreeDto treeDto) {
		Tree tree = treeRepository.findOne(treeDto.getId());
        treeRepository.delete(tree);
        treeRepository.flush();
		return "cut tree - OK";
	}

	@Override
	public String updateTree(TreeDto treeDto) {
		Tree tree = treeRepository.findOne(treeDto.getId());
		entityManager.merge(treeMapper.mapToEntity(tree, treeDto));
		return "update tree - OK";
	}

	@Override
	public List<TreeDto> findAllTrees() {
		return treeMapper.mapTreeEntityListToTreeDtoList(treeRepository.findAll());
	}

	@Override
	public TreeDto findTreeById(Integer id) {
		if(id == null) {
			return null;
		} 
		return treeMapper.mapToDto(treeRepository.getOne(id));
	}

	@Override
	public List<TreeNodeDto> findAllNodesOfTree(Integer treeId) {
		Tree tree = treeRepository.findOne(treeId);
		return treeNodeMapper.mapTreeNodeEntityListToTreeNodeDtoList(tree.getListOfFamilyMembers());
	}

	@Override
	public void addNodeToTree(Integer treeId, Integer treeNodeId) {
		Tree tree = treeRepository.findOne(treeId);
		TreeNode treeNode = treeNodeRepository.findOne(treeNodeId); 
		tree.getListOfFamilyMembers().add(treeNode);
		entityManager.merge(tree);
		entityManager.flush();
	}
	
	@Override
	public void addNodeListToTree(Integer treeId, List<TreeNodeDto> treeNodeIdList) {
		Tree tree = treeRepository.findOne(treeId);
		for ( int i = 0; i < treeNodeIdList.size(); i++) {
			TreeNode treeNode = treeNodeRepository.findOne(treeNodeIdList.get(i).getId()); 
			tree.getListOfFamilyMembers().set(i, treeNode);
		}
		entityManager.merge(tree);
		entityManager.flush();
	}

}
