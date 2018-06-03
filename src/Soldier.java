public class Soldier extends Equilibre {

	private static String nom = "Soldier";
	private static int hp = 178;
	private static int mp = 50;
	private static int def = 84;
	private static int move = 3;
	private static int atk = 158;
	private static int heal = 138;
	private static String nameAtk = " frappe avec son épée sur ";
	private static String nameHeal = " soigne ";
	private static int a_range = 1;
	private static int h_range = 0;
	
	public Soldier() {
		super(Soldier.nom, Soldier.hp, Soldier.mp, Soldier.def, Soldier.move, Soldier.atk, Soldier.heal, Soldier.a_range, Soldier.h_range, Soldier.nameAtk, Soldier.nameHeal);
	}
}