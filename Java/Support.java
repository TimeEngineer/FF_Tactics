public class Support extends Personnage implements ISupport {

	protected int heal;
	protected int range;
	protected int contrecoup;
	protected String nameHeal;

	public Support(String nom, int hp, int mp, int def, int move, int heal, int range, int contrecoup, String nameHeal) {
		super(nom, hp, mp, def, move);
		this.heal = heal;
		this.range = range;
		this.contrecoup = contrecoup;
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
		"CC " + Integer.toString(contrecoup) + '\n';
	}

	public void soigne(Personnage cible) throws Exception {
		if (this.distance(cible) <= this.range) {
			cible.estCible(heal);
			if (this.contrecoup > 0) {
				this.estCible(-this.contrecoup);
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