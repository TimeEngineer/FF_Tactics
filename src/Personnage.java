import java.lang.*;

public abstract class Personnage implements Cloneable {

	protected String nom;
	protected int hp;
	protected int mp;
	protected int def;
	protected int move;
	protected int posx;
	protected int posy;
	protected boolean alive = true;

	public Personnage(String nom, int hp, int mp, int def, int move) {
		this.nom = nom;
		this.hp = hp;
		this.mp = mp;
		this.def = def;
		this.move = move;
	}
	@Override
	protected Personnage clone() throws CloneNotSupportedException{    
	  return(Personnage) super.clone();
	}
	public boolean get_alive() {
		return this.alive;
	}

	public int get_posx() {
		return this.posx;
	}

	public int get_posy() {
		return this.posy;
	}

	public int get_move() {
		return this.move;
	}

	public void set_pos(int a, int b) {
		this.posx = a;
		this.posy = b;
	}

	public int distance(Personnage other) {
		return Math.abs(this.posx - other.posx) + Math.abs(this.posy - other.posy);
	}
	public int distance(int a, int b) {
		return Math.abs(this.posx - a) + Math.abs(this.posy - b);
	}

	public void estCible(int nb) {
		this.hp += nb;
		if (this.hp <= 0) {
			this.alive = false;
		}
	}

	public abstract String allInfo();
	
}