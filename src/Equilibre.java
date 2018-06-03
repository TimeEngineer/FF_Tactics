public class Equilibre extends Personnage implements ICombattant, ISupport {

	protected int atk;
	protected int heal;
	protected int a_range;
	protected int h_range;
	protected String nameAtk;
	protected String nameHeal;

	public Equilibre(String nom, int hp, int mp, int def, int move, int atk, int heal, int a_range, int h_range, String nameAtk, String nameHeal) {
		super(nom, hp, mp, def, move);
		this.atk = atk;
		this.heal = heal;
		this.a_range = a_range;
		this.h_range = h_range;
		this.nameAtk = nameAtk;
		this.nameHeal = nameHeal;
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
		"HEAL : " + Integer.toString(heal) + '\n' +
		"RANGE ATK: " + Integer.toString(a_range) + '\n' +
		"RANGE HEAL: " + Integer.toString(h_range) + '\n' +
		"POS: " + Integer.toString(super.posx) + " " + Integer.toString(super.posy);
	}

	public String attaque(Personnage cible) throws Exception {
		if (this.distance(cible) <= this.a_range) {
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

	public String soigne(Personnage cible) throws Exception {
		if (this.distance(cible) <= this.h_range) {
			if (super.mp < 10) {
				throw new Exception("Pas assez de mana");
			}
			cible.estCible(heal);
			super.mp -= 10;
			return nom + nameHeal + cible.nom + " (" + cible.hp + ")";
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