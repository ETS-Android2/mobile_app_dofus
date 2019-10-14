public class Item{

	public final static
	private ItemType type;
	private int [] required;
	private int [] stats;
	private Panoplie panoplie;
	private int ID;
	private String desc;
	private int niveau;

	public Item(){

		type = ItemType.DOFUS;
		required = new int[50];
		stats = new int[50];
		panoplie = null;
		ID = -1;
		desc = "Default Item";

	}

	/*item custom*/
	public Item(ItemType type, ){

		type = ItemType.DOFUS;
		required = new int[50];
		panoplie = null;
		ID = /*regarde la dernière clé de la bdd et ajoute 1*/;
		desc = "Custom Item";

	}

	public Item(int ID){

		/*requete pour get les caracs de l'item dans la bdd*/

	}

	public getType(){return this.type;}
	public getCaracs(){
		retour = new int[50];
		int i;
		for(i=0;i<50;
}

}
