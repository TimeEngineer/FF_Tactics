public class Archer extends Combattant {

	private static String nom = "Archer";
	private static int hp = 171;
	private static int mp = 56;
	private static int def = 80;
	private static int move = 4;
	private static int atk = 151;
	private static String nameAtk = " décoche une flèche sur ";
	private static int range = 6;

	public Archer() {
		super(Archer.nom, Archer.hp, Archer.mp, Archer.def, Archer.move, Archer.atk, Archer.range, Archer.nameAtk);
	}
}