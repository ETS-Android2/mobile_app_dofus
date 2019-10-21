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
	private Servers server;
	

	/**
	*
	*/
	public Personnage(int lvl, int id, Classes cla, int success, int kolizeum, Align al, Job job, int[] carac,
		Item[] equipement, Personnage spouse, String guild, String alliance, Servers server) {
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
	
	public Personnage(Personnage p) {
		job = new job(p.job);
		this(p.level, p.id, p.cla, p.success, p.kolizeum, p.al, job, p.carac, p.equipement,
		p.spouse, p.guild, p.alliance, p.server);
	}

	
	public int getLevel() {
		return level;
	}
	
	public int getId() {
		return id;
	}
	
	public Classes getCla() {
		return cla;
	}
	
	public int getSuccess() {
		return success;
	}
	
	public int getKolizeum() {
		return kolizeum;
	}
	
	public Align getAl() {
		return al;
	}
	
	public Job getJob() {
		return job;
	}
	
	public int[] getCarac() {
		return carac;
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
