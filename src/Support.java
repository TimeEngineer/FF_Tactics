public class Support extends Personnage implements ISupport {

	protected int heal;
	protected int range;
	protected String nameHeal;

	public Support(String nom, int hp, int mp, int def, int move, int heal, int range, String nameHeal) {
		super(nom, hp, mp, def, move);
		this.heal = heal;
		this.range = range;
		this.nameHeal =  nameHeal;
	}

	public String allInfo() {
		String su = " | " + this.getClass().getSuperclass().getName();
		return 
		"NOM : " + super.nom + su + '\n' +
		"HP : " + Integer.toString(super.hp) + '\n' +
		"MP : " + Integer.toString(super.mp) + '\n' +
		"DEF : " + Integer.toString(super.def) + '\n' +
		"MV : " + Integer.toString(super.move) + '\n' +
		"HEAL : " + Integer.toString(heal) + '\n' +
		"RANGE: " + Integer.toString(range) + '\n' +
		"POS: " + Integer.toString(super.posx) + " " + Integer.toString(super.posy);
	}

	public String soigne(Personnage cible) throws Exception {
		if (this.distance(cible) <= this.range) {
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