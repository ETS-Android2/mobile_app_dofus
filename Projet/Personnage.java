public class Personnage {

	private int level;
	private int id;
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
	

	/**Constructor of the class
	*@param lvl the level of the character
	*@param id the ID of the character
	*@param
	**/
	public Personnage(int lvl, int id, Classes cla, int success, int kolizeum, Align al, Job job, int[] carac,
		Item[] equipement, Personnage spouse, String guild, String alliance, String server) {
		this.level = lvl;
		this.id = id;
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


	/**Copy Constructor of the class
	*@param p the character to copy
	**/
	public Personnage(Personnage p) {
		this(p.level, p.id, p.cla, p.success, p.kolizeum, p.al, null, p.carac, p.equipement, p.spouse, p.guild, p.alliance, p.server);
		job = new Job(p.job);
		this.setJob(job);
	}


	/**Default Constructor of the class
	**/
	public Personnage() {
		this(0, 0, Classes.CRA, 0, 0, Align.NEUTRAL, null, null, null, null, "Overgeared", "alliance", "server");
	}
	
	/**Getter for the character's level
	*@return level the character's level
	**/
	public int getLevel() {
		return level;
	}
	
	/**Getter for the character's id
	*@return id the character's id
	**/
	public int getId() {
		return id;
	}
	
	/**Getter for the character's class
	*@return cla the character's class
	**/
	public Classes getCla() {
		return cla;
	}
	
	/**Getter for the character's success points
	*@return success the character's success points
	**/
	public int getSuccess() {
		return success;
	}
	
	/**Getter for the character's kolizeum ranking
	*@return kolizeum the character's kolizeum ranking
	**/
	public int getKolizeum() {
		return kolizeum;
	}
	
	/**Getter for the character's alignment
	*@return al the character's alignment
	**/
	public Align getAl() {
		return al;
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
	
	public int[] getCarac() {
		return carac;
	}
	
	public Item[] getEquipement(){
		return equipement;
	}
	
	public Personnage getSpouse(){
		return spouse;
	}
	
	// public void setNom(String nom) {
		// this.nom = nom;
	// }

	// /**
	// * Retourne le prénom de la personne.
	// * @return le prénom de la personne
	// */    
	// public String getPrenom() {
		// return prenom;
	// }
	
	
	// public String toString(){
		// return(nom+" "+prenom);	
	// }
	
	// public Personne clone() throws CloneNotSupportedException { 
        // Personne ref = (Personne) super.clone();
		
		// return ref ; 
    // } 
	
	// public boolean equals(Personne p) {
		// return ((this.nom.equals(p.nom))&&(this.prenom.equals(p.prenom)));
	// }
}
