package com.example.project.appclasses;

import com.example.project.enumdofusm.Classes;
import com.example.project.enumdofusm.Align;
import com.example.project.enumdofusm.JobEnum;

public class Personnage {

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////				Attributes		                 ////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	private int id;
	private int level;
	private String name;
	private Classes cla;
	private int success;
	private int kolizeum;
	private Align al;
	private Job job;
	private int[] carac;
	private Item[] equipement;
	private Personnage spouse;
	private String guild;
	private String alliance;
	private String server;
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////					Constructors                  ///////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	/**Constructor of the class
	*@param lvl the level of the character
	*@param id the ID of the character
	*@param
	**/
	public Personnage(int id, int lvl, String name, Classes cla, int success, int kolizeum, Align al, Job job, int[] carac,
		Item[] equipement, Personnage spouse, String guild, String alliance, String server) {
		this.id = id;
		this.level = lvl;
		this.name = name;
		this.cla = cla;
		this.success = success;
		this.kolizeum = kolizeum;
		this.al = al;
		this.job = job;
		this.carac = carac;
		this.equipement = equipement;
		this.spouse = spouse;
		this.guild = guild;
		this.alliance = alliance;
		this.server = server;
		
	}
	
	/**Constructor of the class
	*@param lvl the level of the character
	*@param id the ID of the character
	*@param
	**/
	public Personnage(int id, int lvl, String name, Classes cla, int success, int kolizeum, Align al, JobEnum jobn, int joblvl, int[] carac,
		Item[] equipement, Personnage spouse, String guild, String alliance, String server) {
		this.id = id;
		this.level = lvl;
		this.name = name;
		this.cla = cla;
		this.success = success;
		this.kolizeum = kolizeum;
		this.al = al;
		this.job = new Job(jobn, joblvl);
		this.carac = carac;
		this.equipement = equipement;
		this.spouse = spouse;
		this.guild = guild;
		this.alliance = alliance;
		this.server = server;
		
	}


	/**Copy Constructor of the class
	*@param p the character to copy
	**/
	public Personnage(Personnage p) {
		this(p.id, p.level, p.name, p.cla, p.success, p.kolizeum, p.al, null, p.carac, p.equipement, p.spouse, p.guild, p.alliance, p.server);
		job = new Job(p.job);
		this.setJob(job);
	}


	/**Default Constructor of the class
	**/
	public Personnage() {
		this(0, 10, "Grid", Classes.CRA, 0, 0, Align.NEUTRAL, null, null, null, null, "Overgeared", "alliance", "server");
	}
	
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////					Getters and Setters                  ////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	/**Getter for the character's id
	*@return id the character's id
	**/
	public int getId() {
		return id;
	}
	
	/**Setter for the character's id
	*@param id the new character's id
	**/
	public void setId(int id) {
		this.id = id;
	}
	
	/**Getter for the character's level
	*@return level the character's level
	**/
	public int getLevel() {
		return level;
	}
	
	/**Setter for the character's level
	*@param level the new character's level
	**/
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**Getter for the character's name
	*@return name the character's name
	**/
	public String getName() {
		return name;
	}
	
	/**Setter for the character's name
	*@param name the new character's name
	**/
	public void setName(String name) {
		this.name = name;
	}
	
	/**Getter for the character's class
	*@return cla the character's class
	**/
	public Classes getCla() {
		return cla;
	}
	
	/**Setter for the character's class
	*@param cla the new character's class
	**/
	public void setCla(Classes cla) {
		this.cla = cla;
	}
	
	/**Getter for the character's success points
	*@return success the character's success points
	**/
	public int getSuccess() {
		return success;
	}
	
	/**Setter for the character's success points
	*@param success the new character's success points
	**/
	public void setSuccess(int success) {
		this.success = success;
	}
	
	/**Getter for the character's kolizeum ranking
	*@return kolizeum the character's kolizeum ranking
	**/
	public int getKolizeum() {
		return kolizeum;
	}
	
	/**Setter for the character's kolizeum ranking
	*@param kolizeum the new character's kolizeum ranking
	**/
	public void setKolizeum(int kolizeum) {
		this.kolizeum = kolizeum;
	}
	
	/**Getter for the character's alignment
	*@return al the character's alignment
	**/
	public Align getAl() {
		return al;
	}
	
	/**Setter for the character's alignment
	*@param al the new character's alignment
	**/
	public void setAl(Align al) {
		this.al = al;
	}
	
	/**Getter for the character's job
	*@return job the character's job
	**/
	public Job getJob() {
		return job;
	}
	
	/**Setter for the character's job
	*@param job the new character's job
	**/
	public void setJob(Job job) {
		this.job = job;
	}
	
	/**Getter for the character's stats
	*@return carac the character's stats
	**/
	public int[] getCarac() {
		return carac;
	}
	
	/**Setter for the character's stats
	*@param carac the new character's stats
	**/
	public void setCarac(int[] carac) {
		this.carac = carac;
	}
	
	
	/**Getter for the character's equipement
	*@return equipement the character's equipement
	**/
	public Item[] getEquipement(){
		return equipement;
	}
	
	/**Setter for the character's equipement
	*@param equipement the new character's equipement
	**/
	public void setEquipement(Item[] equipement){
		this.equipement = equipement;
	}
	
	/**Setter for the character's equipement
	*@param equipement the new piece of character's equipement
	*@param position the position of the equipement
	**/
	public void setEquipement(Item equipement,int position){
		this.equipement[position] = equipement;
	}
	
	/**Getter for the character's spouse
	*@return spouse the character's spouse
	**/
	public Personnage getSpouse(){
		return spouse;
	}
	
	/**Setter for the character's spouse
	*@param spouse the character's new spouse
	**/
	public void setSpouse(Personnage spouse){
		this.spouse = spouse;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////					Other Methods                 ///////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**toString for the character
	*@return the character as a String
	**/
	public String toString(){
		return(name+", "+cla+" level "+level+", has "+success+" success points and is ranked "+kolizeum+" at the kolizeum. "+al+" "+job+" "+carac+" "+equipement+" is married to {{{{"+spouse.getName()+"}}}} and is part of "+guild+" which is part of "+alliance+" in "+server+"\n");	
	}
	
	// public Personne clone() throws CloneNotSupportedException { 
        // Personne ref = (Personne) super.clone();
		
		// return ref ; 
    // } 
	
}
