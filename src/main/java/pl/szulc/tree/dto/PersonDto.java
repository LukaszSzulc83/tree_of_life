package pl.szulc.tree.dto;



import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonDto{

		private Integer id;
		private String firstName;
		private String name;
		@JsonFormat(pattern="yyyy-MM-dd")
	    private Date dateOfBirth;
		@JsonFormat(pattern="yyyy-MM-dd")
	    private Date dateOfDeath;
		String placeOfBirth;
	    private String placeOfDeath;
		private String comments;
	    private Integer generation;
	    private boolean men;
	    private boolean activity;
	    private Integer personOnTreeID;
	    private Integer motherID;
		private Integer fatherID;
		private Integer spouseID;
		private Integer treeID;
	    
	    public Integer getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public Date getDateOfDeath() {
			return dateOfDeath;
		}
		public void setDateOfDeath(Date dateOfDeath) {
			this.dateOfDeath = dateOfDeath;
		}
		public String getPlaceOfBirth() {
			return placeOfBirth;
		}
		public void setPlaceOfBirth(String placeOfBirth) {
			this.placeOfBirth = placeOfBirth;
		}
		public String getPlaceOfDeath() {
			return placeOfDeath;
		}
		public void setPlaceOfDeath(String placeOfDeath) {
			this.placeOfDeath = placeOfDeath;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public Integer getGeneration() {
			return generation;
		}
		public void setGeneration(int generation) {
			this.generation = generation;
		}
		public boolean isActive() {
			return activity;
		}
		public void setActivity(boolean activity) {
			this.activity = activity;
		}

		public boolean isMen() {
			return men;
		}
		public void setMen(boolean men) {
			this.men = men;
		}
		
		public Integer getPersonOnTreeID() {
			return personOnTreeID;
		}
		public void setPersonOnTreeID(Integer personOnTreeID) {
			this.personOnTreeID = personOnTreeID;
		}
		public Integer getMotherID() {
			return motherID;
		}
		public void setMotherID(Integer motherID) {
			this.motherID = motherID;
		}
		public Integer getFatherID() {
			return fatherID;
		}
		public void setFatherID(Integer fatherID) {
			this.fatherID = fatherID;
		}
		
		public Integer getSpouseID() {
			return spouseID;
		}
		public void setSpouseID(Integer spouseID) {
			this.spouseID = spouseID;
		}
		public Integer getTreeID() {
			return treeID;
		}
		public void setTreeID(Integer treeID) {
			this.treeID = treeID;
		}
	
}