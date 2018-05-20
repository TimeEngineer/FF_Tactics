public class Thief extends Combattant {

	private static String nom = "Thief";
	private static int hp = 6;
	private static int mp = 1;
	private static int def = 3;
	private static int move = 4;
	private static int atk = 7;
	private static String nameAtk = " frappe avec son poignard sur ";
	private static int range = 1;
	private static int contrecoup = 0;
	
	public Thief() {
		super(Thief.nom, Thief.hp, Thief.mp, Thief.def, Thief.move, Thief.atk, Thief.range, Thief.contrecoup, Thief.nameAtk);
	}
}