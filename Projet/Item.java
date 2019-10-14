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

	public Item(){

		type = ItemType.DOFUS;
		required = new int[50];
		stats = new int[50];
		fm = new int[50];
		panoplie = null;
		ID = -1;
		desc = "Default Item";

	}

	/**Constructeur d'items
	*@param type de l'item
	*@param ID dans la bdd
	**/
	
	public Item(ItemType type, int ID){

		/*GET DE LA BDD les infos via ID*/
		this.type = type;

	}
	
	/*Pour les items custom : Gestion à part de la bdd (local)

	public Item(int ID){

		/*requete pour get les caracs de l'item dans la bdd*/

	}

	/**Getter du type
	*@return le type de l'item
	**/
	public TypeItem getType(){return this.type;}

	/**Getter de toutes les caracs
	*@return le tableau des caracs (copie profonde)
	**/
	public getCaracs(){
		retour = new int[50];
		int i;
		for(i=0;i<50;i++){
			
			retour[i] = this.stats[i];
			
		}
		return retour;
	}

	/**Getter d'une carac
	*@return la valeur de la carac
	**/
	public getCarac(int i){
		return stats[i];
	}
	
	/**Getter de toutes les pre-requis
	*@return le tableau des caracs (copie profonde)
	**/
	public getReq(){
		retour = new int[50];
		int i;
		for(i=0;i<50;i++){
			
			retour[i] = this.required[i];
			
		}
		return retour;
	}

	/**Getter de toutes les caracs fm
	*@return le tableau des caracs fm (copie profonde)
	**/
	public getFm(){
		retour = new int[50];
		int i;
		for(i=0;i<50;i++){
			
			retour[i] = this.fm[i];
			
		}
		return retour;
	}
}
