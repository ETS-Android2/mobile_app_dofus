public class Panoplie{

	public static final int NBPARAM = 50;

	private Item[] items;
	/*Caracs*/
	private int[][] stats;
	/* = Celui de la BDD*/
	private int ID;


	//---------------Constru---------------------

	public Panoplie(){

		items = null;
		int[][] stats = new int[0][NBPARAM];
		ID = -1;

	}


	public Panoplie(Item[] items, int[][] stats, int ID){

		this.ID = ID;
		int i;
		for(i=0;i<items.length -1;i++){
			for (int j=0; j<stats.length; j++){
				this.stats[i][j] = stats[i][j];
			}
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
	public int[][] getCaracs(){
		int[][] retour = new int[this.items.length][NBPARAM];
		int i, j;
		for(i=0;i<items.length;i++){
			
			for(j=0;j<NBPARAM;j++){

				retour[i][j] = this.stats[i][j];
			}
			
		}
		return retour;
	}


	/**Getter de toutes les caracs d'une range
	*@return le tableau des caracs (copie profonde)
	**/
	public int[] getCaracs(int i){

		int[] retour = new int[NBPARAM];
		int j;

		for(j=0;j<NBPARAM;j++){

			retour[j] = this.stats[i][j];
		}
			
		return retour;

	}


	/**Getter d'une carac d'un nb d'objet
	*@return la valeur de la carac
	**/
	public int getCarac(int i, int j){
		return stats[i][j];
	}
	

	/**Setter d'une carac
	*@param la valeur de la carac
	**/
	public void setCarac(int i, int j, int val){
		this.stats[i][j] = val;
	}


	// /**Setter de toutes les caracs
	// *@param le tableau des caracs (copie profonde)
	// **/
	// public void setCaracs(int[] tab, int nbItems){

		// if(tab.length == NBPARAM){

			// this.stats = new int[items.length -1][NBPARAM];
			// int i;
			// for(i=0;i<NBPARAM;i++){
			
				// this.stats[i] = tab[i];
			
			// }

		// }
	// }

	//---------------Item--------------------------

	/**Getter des items
	*@return les items
	**/
	public Item[] getItems(){

		Item[] retour = new Item[this.items.length];

		for(int i=0;i<this.items.length;i++){
			
			retour[i] = this.items[i];
			
		}
		return retour;
	}

	/**Getter du nombre d'items
	*@return le nombre d'items
	**/
	public int getNbItems(){

		return this.items.length;
	}

	/**Getter d'un item
	*@return l'item
	**/
	public Item getItem(int i){

		return new Item(this.items[i]);
	}



	//---------------Panoplie----------------------

	/**Getter de la panoplie
	*@return la panoplie
	**/
	public Panoplie getPanoplie(){

		return new Panoplie(this);

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


}

