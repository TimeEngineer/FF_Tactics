public class Combattant extends Personnage implements ICombattant {

	protected int atk;
	protected int range;
	protected int contrecoup;
	protected String nameAtk;

	public Combattant(String nom, int hp, int mp, int def, int move, int atk, int range, int contrecoup, String nameAtk) {
		super(nom, hp, mp, def, move);
		this.atk = atk;
		this.range = range;
		this.contrecoup = contrecoup;
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
		"CC : " + Integer.toString(contrecoup) + '\n';
	}

	public void attaque(Personnage cible) throws Exception {
		if (this.distance(cible) <= this.range) {
			int dmg = -atk+cible.def; 
			if (dmg >= 0) {
				throw new Exception("Attention vous n'allez pas infliger des dêgats");
			}
			cible.estCible(dmg);
			if (this.contrecoup > 0) {
				this.estCible(-this.contrecoup);
			}
			System.out.println(nom + nameAtk + cible.nom);
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