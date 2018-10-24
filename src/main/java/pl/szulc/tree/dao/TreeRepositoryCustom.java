package pl.szulc.tree.dao;

import java.util.List;

import pl.szulc.tree.entity.Tree;

public interface TreeRepositoryCustom {
	String createTree(Tree tree);
	String cutTree(Tree tree);
	String updateTree(Tree tree);
	List<Tree> findAllTrees();
	Tree findTreeById(Integer id);
}
