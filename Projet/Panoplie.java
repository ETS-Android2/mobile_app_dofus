public class Item{

	public final NBPARAM = 50;

	private Item[] items;
	/*Caracs*/
	private int[][] stats;
	/* = Celui de la BDD*/
	private int ID;


	//---------------Constru---------------------

	public Panoplie(){

		items = null;
		stats = new int[NBPARAM];
		ID = -1;

	}


	public Panoplie(Item[] items, int[] stats, int ID){

		this.ID = ID;
		int i;
		for(i=0;i<NBPARAM;i++){
			
			this.stats[i] = stats[i];
			
		}

		for(i=0;i<items.length;i++){
			
			this.items[i] = items[i];
			
		}

	}

	public Panoplie(Panoplie base){

		int i;

		this.ID = base.getID();

		for(i=0;i<items.length;i++){
			
			this.items[i] = base.getItem(i);
			
		}

		for(i=0;i<items.length;i++){
			
			this.stats[i] = base.getCaracs(i);
			
		}



	}

	//---------------CARAC---------------------


	/**Getter de toutes les caracs
	*@return le tableau des caracs (copie profonde)
	**/
	public int[] getCaracs(){
		retour = new int[this.items.length][NBPARAM];
		int i, j;
		for(i=0;i<items.length;i++){
			
			for(j=0;j<NBPARAM;j++){

				retour[i][j] = this.stats[i](j]
			}
			
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

