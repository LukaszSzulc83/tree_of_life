package pl.szulc.tree.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Person{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "FIRST_NAME", nullable = false, length = 255)
	private String firstName;
	@Column(name = "NAME", nullable = false, length = 255)
	private String name;
	@Column(name = "DATE_OF_BIRTH", nullable = false)
    private Date dateOfBirth;
	@Column(name = "DATE_OF_DEATH", nullable = true)
    private Date dateOfDeath;
	@Column(name = "PLACE_OF_BIRTH", nullable = true, length = 255)
	String placeOfBirth;
	@Column(name = "PLACE_OF_DEATH", nullable = true, length = 255)
    private String placeOfDeath;
	@Column(name = "COMMENTS", nullable = true, length = 1000)
	private String comments;
	@Column(name = "GENERATION", nullable = true)
    private int generation;
	@Column(name = "ACTIVITY", nullable = false)
    private boolean activity;
	@Column(name = "MEN", nullable = false)
	private boolean men;
	@Column(name = "PERSON_ON_TREE_ID", nullable = true)
	private Integer personOnTreeID;
	@Column(name = "MOTHER_ID", nullable = true)
	private Integer motherID;
	@Column(name = "FATHER_ID", nullable = true)
	private Integer fatherID;
	@Column(name = "SPOUSE_ID", nullable = true)
	private Integer spouseID;
    @ManyToOne
    @JoinColumn(name = "tree_id")
	private Tree tree;
    
    
	
	public int getId() {
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
	public int getGeneration() {
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
	public Tree getTree() {
		return tree;
	}
	public void setTree(Tree tree) {
		this.tree = tree;
	}
	public Integer getPersonOnTreeID() {
		return personOnTreeID;
	}
	public void setPersonOnTreeID(Integer personOnTreeID) {
		this.personOnTreeID = personOnTreeID;
	}
	
	
}

