package pl.szulc.tree.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.szulc.tree.dto.NewNodeDto;
import pl.szulc.tree.dto.TreeDto;
import pl.szulc.tree.service.TreeService;
@RestController
@ResponseBody
public class TreeRestController {
	@Autowired
	TreeService treeService;
	
	@RequestMapping(value = "/tree", method = RequestMethod.POST)
	public String addTree(@RequestBody TreeDto treeDto) {
		return treeService.createTree(treeDto);
	}
	@RequestMapping(value = "/tree", method = RequestMethod.PUT)
	public String updateTree(@RequestBody TreeDto treeDto) {
		return treeService.updateTree(treeDto);
	}
	
	@RequestMapping(value = "/tree/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TreeDto getProjectById(@PathVariable("id") Integer treeId) {
        return treeService.findTreeById(treeId);
    }
	
	@RequestMapping(value = "/tree", method = RequestMethod.DELETE)
	public String deletePerson(@RequestBody TreeDto treeDto) {
		return treeService.removeTree(treeDto);
	}
	
	@RequestMapping(value = "/node", method = RequestMethod.POST)
    public void addFirstNode(@RequestBody NewNodeDto newNodeDto) {
        treeService.addFirstNodeToTree(newNodeDto);
    }
	
	@RequestMapping(value = "/parentNode", method = RequestMethod.PUT)
    public void addParentNode(@RequestBody NewNodeDto newNodeDto) {
        treeService.addParentNodeToTree(newNodeDto);
    }
	@RequestMapping(value = "/spouseNode", method = RequestMethod.PUT)
    public void addSpouseNode(@RequestBody NewNodeDto newNodeDto) {
        treeService.addSpouseNodeToTree(newNodeDto);
    }
	
	@RequestMapping(value = "/childNode", method = RequestMethod.PUT)
    public void addChildNode(@RequestBody NewNodeDto newNodeDto) {
        treeService.addChildNodeToTree(newNodeDto);
    }
}
