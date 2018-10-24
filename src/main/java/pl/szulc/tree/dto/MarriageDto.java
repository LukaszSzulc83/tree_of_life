package pl.szulc.tree.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MarriageDto {
	private Integer id;
	private Integer husbandID;
	private Integer wifeID;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfMarriage;
	private String placeOfMarriage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHusbandID() {
		return husbandID;
	}
	public void setHusbandID(Integer husbandID) {
		this.husbandID = husbandID;
	}
	public Integer getWifeID() {
		return wifeID;
	}
	public void setWifeID(Integer wifeID) {
		this.wifeID = wifeID;
	}
	public Date getDateOfMarriage() {
		return dateOfMarriage;
	}
	public void setDateOfMarriage(Date dateOfMarriage) {
		this.dateOfMarriage = dateOfMarriage;
	}
	public String getPlaceOfMarriage() {
		return placeOfMarriage;
	}
	public void setPlaceOfMarriage(String placeOfMarriage) {
		this.placeOfMarriage = placeOfMarriage;
	}
}
