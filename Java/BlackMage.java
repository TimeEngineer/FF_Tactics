public class BlackMage extends Combattant {

	private static String nom = "Black Mage";
	private static int hp = 5;
	private static int mp = 4;
	private static int def = 3;
	private static int move = 3;
	private static int atk = 8;
	private static String nameAtk = " lance une boule de feu sur ";
	private static int range = 4;
	private static int contrecoup = 0;

	public BlackMage() {
		super(BlackMage.nom, BlackMage.hp, BlackMage.mp, BlackMage.def, BlackMage.move, BlackMage.atk, BlackMage.range, BlackMage.contrecoup, BlackMage.nameAtk);
	}
}