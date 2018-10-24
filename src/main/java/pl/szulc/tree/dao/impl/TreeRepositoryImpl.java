package pl.szulc.tree.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import pl.szulc.tree.dao.TreeRepository;
import pl.szulc.tree.dao.TreeRepositoryCustom;
import pl.szulc.tree.entity.Tree;
@Repository
public class TreeRepositoryImpl implements TreeRepositoryCustom {

	@Lazy
	@Autowired
	private TreeRepository treeRepository;
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public String createTree(Tree tree) {
		treeRepository.saveAndFlush(tree);
		return "create tree - OK";
	}

	@Override
	public String cutTree(Tree tree) {
        treeRepository.delete(tree);
        treeRepository.flush();
		return "cut tree - OK";
	}

	@Override
	public String updateTree(Tree tree) {
		treeRepository.saveAndFlush(tree);
		return "update tree - OK";
	}

	@Override
	public List<Tree> findAllTrees() {
		return treeRepository.findAll();
	}

	@Override
	public Tree findTreeById(Integer id) {
		if(id == null) {
			return null;
		} 
		return treeRepository.getOne(id);
	}

}
