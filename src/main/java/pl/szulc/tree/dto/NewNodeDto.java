package pl.szulc.tree.dto;

public class NewNodeDto {
	private Integer nodeId;
	private Integer treeId;
	private boolean men;
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public Integer getTreeId() {
		return treeId;
	}
	public void setTreeId(Integer treeId) {
		this.treeId = treeId;
	}
	public boolean isMen() {
		return men;
	}
	public void setMen(boolean men) {
		this.men = men;
	}
}
