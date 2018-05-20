public class Equilibre extends Personnage implements ICombattant, ISupport {

	protected int atk;
	protected int heal;
	protected int a_range;
	protected int h_range;
	protected int a_contrecoup;
	protected int h_contrecoup;
	protected String nameAtk;
	protected String nameHeal;

	public Equilibre(String nom, int hp, int mp, int def, int move, int atk, int heal, int a_range, int h_range, int a_contrecoup, int h_contrecoup, String nameAtk, String nameHeal) {
		super(nom, hp, mp, def, move);
		this.atk = atk;
		this.heal = heal;
		this.a_range = a_range;
		this.h_range = h_range;
		this.a_contrecoup = a_contrecoup;
		this.h_contrecoup = h_contrecoup;
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
		"CC ATK: " + Integer.toString(a_contrecoup) + '\n' +
		"CC HEAL: " + Integer.toString(h_contrecoup) + '\n';
	}

	public void attaque(Personnage cible) throws Exception {
		if (this.distance(cible) <= this.a_range) {
			int dmg = -atk+cible.def;
			if (dmg >= 0) {
				throw new Exception("Attention vous n'allez pas infliger des dêgats");
			}
			cible.estCible(dmg);
			if (this.a_contrecoup > 0) {
				this.estCible(-this.a_contrecoup);
			}
			System.out.println(nom + nameAtk + cible.nom);
		}
		else {
			throw new Exception("La cible est trop éloigné");
		}
	}

	public void soigne(Personnage cible) throws Exception {
		if (this.distance(cible) <= this.h_range) {
			cible.estCible(heal);
			if (this.h_contrecoup > 0) {
				this.estCible(-this.h_contrecoup);
			}
			System.out.println(nom + nameHeal + cible.nom);
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