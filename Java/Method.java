import java.util.ArrayList;
import java.util.Iterator;

public class Method {

	public ArrayList<Personnage> newTeam() {
		return new ArrayList<Personnage>();  
	}

	public static void afficheTeam(ArrayList<Personnage> al) {
		for(Personnage p : al) 
			System.out.println(p);
	}

}