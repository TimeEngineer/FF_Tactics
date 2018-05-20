public abstract class Personnage {

	protected String nom;
	protected int hp;
	protected int mp;
	protected int def;
	protected int move;
	protected int[] pos = new int[2];
	protected boolean alive;

	public Personnage(String nom, int hp, int mp, int def, int move) {
		this.nom = nom;
		this.hp = hp;
		this.mp = mp;
		this.def = def;
		this.move = move;
	}

	public int distance(Personnage other) {
		return this.pos[0] - other.pos[0] + this.pos[1] - other.pos[1];
	}

	public void estCible(int nb) {
		this.hp += nb;
		if (this.hp <= 0) {
			this.alive = false;
		}
	}

	public abstract String allInfo();
	
}