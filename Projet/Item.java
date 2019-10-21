public class Item{

	public final NBPARAM = 50;
	
	private ItemType type;
	
	/*Pre-requis*/
	private int [] required;
	
	/*Caracs*/
	private int [] stats;
	
	/*Forgemagie*/
	private int [] fm;
	
	private Panoplie panoplie;
	
	/* = Celui de la BDD*/
	private int ID;
	private String desc;
	private int niveau;


	//---------------Constru---------------------

	public Item(){

		type = ItemType.DOFUS;
		required = new int[NBPARAM];
		stats = new int[NBPARAM];
		fm = new int[NBPARAM];
		panoplie = null;
		ID = -1;
		desc = "Default Item";
		niveau = 1;

	}

	/**Constructeur d'items
	*@param type de l'item
	*@param ID dans la bdd
	**/
	
	public Item(ItemType type, int ID){

		/*GET DE LA BDD les infos via ID*/
		this.type = type;

	}
	
	/*Pour les items custom : Gestion  part de la bdd (local)

	public Item(int ID){

		/*requete pour get les caracs de l'item dans la bdd*/

	}


	/**Constructeur par copie
	*@param item a copier
	**/
	public Item(Item base){

		int i;
		this.type = base.getType();
		this.required = new int[NBPARAM];

		for(i=0;i<NBPARAM;i++){
			
			this.required[i] = base.getReq()[i];
			
		}

		this.stats = new int[NBPARAM];

		for(i=0;i<NBPARAM;i++){
			
			this.stats[i] = base.getCarac(i);
			
		}

		this.fm = new int[NBPARAM];

		for(i=0;i<NBPARAM;i++){
			
			this.fm[i] = base.getFm()[i];
			
		}

		panoplie = new Panoplie(base.getPanoplie());
		ID = base.getID();
		desc = base.getDesc();
		niveau = base.getLevel();

	}

	//---------------Type----------------------

	/**Getter du type
	*@return le type de l'item
	**/
	public TypeItem getType(){return this.type;}


	/**Setter du type
	*@param le type de l'item
	**/
	public void setType(ItemType type){this.type = type;}


	//---------------CARAC---------------------


	/**Getter de toutes les caracs
	*@return le tableau des caracs (copie profonde)
	**/
	public int[] getCaracs(){
		retour = new int[NBPARAM];
		int i;
		for(i=0;i<NBPARAM;i++){
			
			retour[i] = this.stats[i];
			
		}
		return retour;
	}

	/**Getter d'une carac
	*@return la valeur de la carac
	**/
	public int getCarac(int i){
		return stats[i];
	}
	
	/**Setter d'une carac
	*@param la valeur de la carac
	**/
	public void setCarac(int i, int val){
		this.stats[i] = val;
	}

	/**Setter de toutes les caracs
	*@param le tableau des caracs (copie profonde)
	**/
	public void getCaracs(int[] tab){

		if(tab.length == NBPARAM){

			this.stats = new int[NBPARAM];
			int i;
			for(i=0;i<NBPARAM;i++){
			
				this.stats[i] = tab[i];
			
			}

		}
	}


	//---------------Prereq----------------------

	/**Getter de toutes les pre-requis
	*@return le tableau des caracs (copie profonde)
	**/

	public int[] getReq(){
		retour = new int[NBPARAM];
		int i;
		for(i=0;i<NBPARAM;i++){
			
			retour[i] = this.required[i];
			
		}
		return retour;
	}

	/**Setter de tous les pre req
	*@param le tableau des pre req (copie profonde)
	**/
	public void setReq(int [] tab){

		if(tab.length == NBPARAM){

			this.stats = new int[NBPARAM];
			int i;
			for(i=0;i<NBPARAM;i++){
			
				this.stats[i] = tab[i];
			
			}

		}
	}


	//---------------Prereq----------------------

	/**Getter de toutes les caracs fm
	*@return le tableau des caracs fm (copie profonde)
	**/
	public int[] getFm(){
		retour = new int[NBPARAM];
		int i;
		for(i=0;i<NBPARAM;i++){
			
			retour[i] = this.fm[i];
			
		}
		return retour;
	}

	/**Setter de fm (RESET)
	*@param le tableau de fm (copie profonde)
	**/
	public void setFm(int [] tab){

		if(tab.length == NBPARAM){

			this.stats = new int[NBPARAM];
			int i;
			for(i=0;i<NBPARAM;i++){
			
				this.stats[i] = tab[i];
			
			}

		}
	}

	/**Setter de fm (SIMPLE)
	*@param la case du tableau et la valeur)
	**/
	public void setFm(int i, int val){

		this.stats[i] = val;
	}


	//---------------Panoplie----------------------

	/**Getter de la panoplie
	*@return la panoplie
	**/
	public Panoplie getPanoplie(){

		return new Panoplie(this.panoplie);

	}
	
	/**Setter de la panoplie
	*@param la panoplie
	**/
	public void setPanoplie(Panoplie panoplie){

		this.panoplie = new Panoplie(this.panoplie):
	}


	//---------------ID----------------------

	/**Getter de l'ID
	*@return l'ID
	**/
	public int getID(){return this.ID;}

	/**Setter de l'ID
	*@param l'ID
	**/
	public void setID(int ID){this.ID = ID;}

	//---------------desc----------------------

	/**Getter de la desc
	*@return la desc
	**/
	public String getDesc(){

		return this.desc;
	}

	/**Setter de la desc
	*@param la desc
	**/
	public void setDesc(String desc){
		this.desc = desc
	}


	//---------------niveau----------------------

	/**Getter du niveau
	*@return le niveau
	**/
	public int getLevel(){
		return this.niveau;
	}

	/**Setter du niveau
	*@param le niveau
	**/
	public void setLevel(int niveau){
		this.niveau = niveau;
	}

}

