package pl.szulc.tree.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.szulc.tree.entity.Tree;

public interface TreeRepository extends JpaRepository<Tree, Serializable>, TreeRepositoryCustom{
	
}