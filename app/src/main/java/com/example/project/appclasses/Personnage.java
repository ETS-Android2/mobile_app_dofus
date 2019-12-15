package com.example.project.appclasses;

import com.example.project.enumdofusm.Classes;
import com.example.project.enumdofusm.JobEnum;
import com.example.project.enumdofusm.Servers;
import com.example.project.enumdofusm.Sex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Personnage implements Serializable {

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////				Attributes		                 ////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	static final long serialVersionUID = 123456789123456789L;

	private int id;
	private String name;
	private int level;
	private Sex sex;
	private Classes cla;
	private int success;
	private Job[] job;
	private int[] carac;
	private Servers server;
	private String desc;
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////					Constructors                  ///////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	/**Constructor of the class
	*@param lvl the level of the character
	*@param id the ID of the character
	*@param
	**/
	public Personnage(int id, String name,int lvl, Sex sex, Classes cla, int success,Job[] job, int[] carac, Servers server, String desc) {
		this.id = id;
		this.level = lvl;
		this.sex = sex;
		this.name = name;
		this.cla = cla;
		this.success = success;
		this.job = job;
		this.carac = carac;
		this.server = server;
		this.desc = desc;
		
	}

	public Personnage(String name,int lvl, Sex sex, Classes cla, int success,Job[] job, int[] carac, Servers server, String desc) {
		this.level = lvl;
		this.sex = sex;
		this.name = name;
		this.cla = cla;
		this.success = success;
		this.job = job;
		this.carac = carac;
		this.server = server;
		this.desc = desc;
	}




	/**Copy Constructor of the class
	*@param p the character to copy
	**/
	public Personnage(Personnage p) {
		this(p.id, p.name, p.level, p.sex, p.cla, p.success, null, null, p.server, p.desc);
		List<Job> jo = new ArrayList<Job>();
		for (Job j : p.getJob()){
		    jo.add(new Job(j.getName(), j.getLevel()));
        }
        Job[] a = new Job[jo.size()];
        a = jo.toArray(a);
		this.setJob(a);

		int[] c = { p.carac[0], p.carac[1], p.carac[2], p.carac[3]};
		this.setCarac(c);
	}


	/**Default Constructor of the class
	**/
	public Personnage() {
		this(0, "Grid", 10, Sex.MALE, Classes.CRA, 0, null, null, Servers.OMBRE, "this is a character");
		Job[] a = {new Job()};
		this.setJob(a);
		int[] b = {10,10,10,10};
		this.setCarac(b);
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

	
	/**Getter for the character's job
	*@return job the character's job
	**/
	public Job[] getJob() {
		return job;
	}
	
	/**Setter for the character's job
	*@param job the new character's job
	**/
	public void setJob(Job[] job) {
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

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Servers getServer() {
		return server;
	}

	public void setServer(Servers server) {
		this.server = server;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////					Other Methods                 ///////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**toString for the character
	*@return the character as a String
	**/
	public String toString(){
		return(name+", "+cla+" level "+level+", has "+success+" success points and is ranked "+job+" "+carac+" in "+server+"\n");
	}
	
	// public Personne clone() throws CloneNotSupportedException { 
        // Personne ref = (Personne) super.clone();
		
		// return ref ; 
    // } 
	
}
