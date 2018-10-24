package pl.szulc.tree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.szulc.tree.dao.TreeRepository;
import pl.szulc.tree.dto.TreeDto;
import pl.szulc.tree.entity.Tree;
import pl.szulc.tree.mappers.TreeMapper;
import pl.szulc.tree.service.TreeService;


@Service
public class TreeServiceImpl implements TreeService {
	@Autowired
	TreeRepository treeRepository;
	@Autowired
	TreeMapper treeMapper;

	@Override
	public String createOrUpdateTree(TreeDto treeDto) {
		Tree tree = treeRepository.findTreeById(treeDto.getId());
		return treeRepository.createTree(treeMapper.mapToEntity(tree, treeDto));
	}

	@Override
	public String removeTree(TreeDto treeDto) {
		Tree tree = treeRepository.findTreeById(treeDto.getId());
		return treeRepository.cutTree(tree);
	}

	@Override
	public List<TreeDto> showAllTrees() {
		return null;
	}

	@Override
	public TreeDto findTreeById(Integer id) {
		return treeMapper.mapToDto(treeRepository.findTreeById(id));
	}

}