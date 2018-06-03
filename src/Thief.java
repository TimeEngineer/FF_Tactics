public class Thief extends Combattant {

	private static String nom = "Thief";
	private static int hp = 161;
	private static int mp = 51;
	private static int def = 79;
	private static int move = 4;
	private static int atk = 150;
	private static String nameAtk = " frappe avec son poignard sur ";
	private static int range = 1;
	
	public Thief() {
		super(Thief.nom, Thief.hp, Thief.mp, Thief.def, Thief.move, Thief.atk, Thief.range, Thief.nameAtk);
	}
}