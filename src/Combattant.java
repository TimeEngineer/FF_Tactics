public class Combattant extends Personnage implements ICombattant {

	protected int atk;
	protected int range;
	protected String nameAtk;

	public Combattant(String nom, int hp, int mp, int def, int move, int atk, int range, String nameAtk) {
		super(nom, hp, mp, def, move);
		this.atk = atk;
		this.range = range;
		this.nameAtk = nameAtk;
	}

	public String allInfo() {
		String su = " | " + this.getClass().getSuperclass().getName();
		return 
		"NOM : " + super.nom + su + '\n' +
		"HP : " + Integer.toString(super.hp) + '\n' +
		"MP : " + Integer.toString(super.mp) + '\n' +
		"DEF : " + Integer.toString(super.def) + '\n' +
		"MV : " + Integer.toString(super.move) + '\n' +
		"ATK : " + Integer.toString(atk) + '\n' +
		"RANGE : " + Integer.toString(range) + '\n' +
		"POS: " + Integer.toString(super.posx) + " " + Integer.toString(super.posy);
	}

	public String attaque(Personnage cible) throws Exception {
		if (this.distance(cible) <= this.range) {
			if (super.getClass() == BlackMage.class) {
				if (super.mp < 10) {
					throw new Exception("Pas assez de mana");
				}
				super.mp -= 10;
			}
			int dmg = -atk+cible.def; 
			if (dmg >= 0) {
				throw new Exception("Attention vous n'allez pas infliger des dêgats");
			}
			cible.estCible(dmg);
			return nom + nameAtk + cible.nom + " (" + cible.hp + ")";
		}
		else {
			throw new Exception("La cible est trop éloigné");
		}
	}

	public String toString()
	{
		return super.nom;
	}
}