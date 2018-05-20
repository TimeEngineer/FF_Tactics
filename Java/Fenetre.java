import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Fenetre  {

	// Initialisation
	private JPanel panelJoueur1;
	private JPanel panelJoueur2;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panelCombat1;
	private JPanel panelCombat2;
	private JPanel panel;
	private JPanel panelGo;
	private JPanel panelCharList;
	private JList<Personnage> list1;
	private JList<Personnage> list2;
	private JList<Personnage> list;
	private JButton go;
	private JButton add1;
	private JButton add2;
	private JTextArea area1;
	private JTextArea area2;

	// Global
	private boolean game = false;
	private DefaultListModel<Personnage> team1;
	private DefaultListModel<Personnage> team2;
	private DefaultListModel<Personnage> charlist;


	// Selection
	private int firstIndex1;
	private int lastIndex1;
	private int selected1;
	private Personnage perso1;
	private int firstIndex2;
	private int lastIndex2;
	private int selected2;
	private Personnage perso2;
	private int firstIndex;
	private int lastIndex;
	private int selected;

	// Phase Combat
	private JButton bAtk1;
	private JButton bHeal1;
	private JButton bAtk2;
	private JButton bHeal2;
	
	public Fenetre() {
		JFrame f = new JFrame("FF Tactics");
		team1 = new DefaultListModel<Personnage>();
		team2 = new DefaultListModel<Personnage>();
		charlist = new DefaultListModel<Personnage>();
		charlist.addElement(new Soldier());
		charlist.addElement(new Archer());
		charlist.addElement(new Thief());
		charlist.addElement(new BlackMage());
		charlist.addElement(new WhiteMage());
		//team1.add(new Archer());
		//team1.add(new WhiteMage());
		//team1.add(new Soldier());
		//team1.add(new Thief());
		//team1.add(new BlackMage());
		//team2.add(new Archer());
		//team2.add(new WhiteMage());
		//team2.add(new Soldier());
		//team2.add(new Thief());
		//team2.add(new BlackMage());

		f.setSize(800,700);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.getContentPane().setBackground(Color.gray);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Init Panel
			panelJoueur1 = new JPanel();
			panelJoueur1.setLayout(new GridLayout(3,1));
			panelJoueur1.setBounds(110,0,280,500); // 1. left marge 2. top marge 3. vertical size 4. horizontal size 
			panelJoueur1.setBackground(Color.gray);
			panel1 = new JPanel();
			panel1.setBackground(Color.gray);
			panelCombat1 = new JPanel();
			panelCombat1.setLayout(new GridLayout(2,1));
			panelCombat1.setBackground(Color.gray);
			panel3 = new JPanel();
			panel3.setBackground(Color.gray);

			panelJoueur2 = new JPanel();
			panelJoueur2.setLayout(new GridLayout(3,1));
			panelJoueur2.setBounds(405,0,280,500); // 1. left marge 2. top marge 3. vertical size 4. horizontal size 
			panelJoueur2.setBackground(Color.gray);
			panel2 = new JPanel();
			panel2.setBackground(Color.gray);
			panelCombat2 = new JPanel();
			panelCombat2.setLayout(new GridLayout(2,1));
			panelCombat2.setBackground(Color.gray);
			panel4 = new JPanel();
			panel4.setBackground(Color.gray);

			panel = new JPanel();
			panel.setBounds(0,500,800,200);
			panel.setLayout(new GridLayout(2,1));
			panel.setBackground(Color.gray);
			panelGo = new JPanel();
			panelGo.setBackground(Color.gray);
			panelCharList = new JPanel();
			panelCharList.setBackground(Color.gray);

			f.add(panelJoueur1);
			f.add(panelJoueur2);
			f.add(panel);
		
		// CAMP 1
			// Button Atk1
			bAtk1 = new JButton("Attaque");
			bAtk1.setPreferredSize(new Dimension(100, 30));
			// Button Heal1
			bHeal1 = new JButton("Soigne");
			bHeal1.setPreferredSize(new Dimension(100, 30));
			// JList1
			list1 = new JList<Personnage>(team1);
			list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// JTextField1
			area1 = new JTextArea();
			area1.setEditable(false);

			panel1.add(new JScrollPane(list1));
			panel1.add(panelCombat1);
			panelJoueur1.add(panel1);
			panelJoueur1.add(area1);

		// CAMP 2
			// Button Atk2
			bAtk2 = new JButton("Attaque");
			bAtk2.setPreferredSize(new Dimension(100, 30));
			// Button Heal2
			bHeal2 = new JButton("Soigne");
			bHeal2.setPreferredSize(new Dimension(100, 30));
			// JList2
			list2 = new JList<Personnage>(team2);
			list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// JTextField2
			area2 = new JTextArea();
			area2.setEditable(false);

			panel2.add(panelCombat2);
			panel2.add(new JScrollPane(list2));
			panelJoueur2.add(panel2);
			panelJoueur2.add(area2);

		// GAME
			// Button Go
			go = new JButton("GO");
			go.setPreferredSize(new Dimension(100,30));
			// Button Add1
			add1 = new JButton("Ajouter à mon équipe");
			add1.setPreferredSize(new Dimension(280,30));
			// Button Add2
			add2 = new JButton("Ajouter à mon équipe");
			add2.setPreferredSize(new Dimension(280,30));
			panel3.add(add1);
			panelJoueur1.add(panel3);
			panel4.add(add2);
			panelJoueur2.add(panel4);
	
			list = new JList<Personnage>(charlist);
			list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setVisibleRowCount(1);
			panelCharList.add(new JScrollPane(list));
			panel.add(panelCharList);
			panelGo.add(go);
			panel.add(panelGo);

		f.setVisible(true);

		bAtk1.addActionListener(new ButtonListener());
		bHeal1.addActionListener(new ButtonListener());
		bAtk2.addActionListener(new ButtonListener());
		bHeal1.addActionListener(new ButtonListener());
		add1.addActionListener(new ButtonListener());
		add2.addActionListener(new ButtonListener());
		go.addActionListener(new ButtonListener());
		list1.addListSelectionListener(new ListSelectionListener() {
	      	public void valueChanged(ListSelectionEvent e) {
	      		int first = e.getFirstIndex();
	      		int last = e.getLastIndex();
	      		if (e.getValueIsAdjusting()) {
		      		if ((firstIndex1 != first && lastIndex1 == last) || firstIndex1 == last || (firstIndex1 == first && lastIndex1 == last && selected1 == last))
		      		{
		      			perso1 = team1.elementAt(first);
		      			selected1 = first;
		      		}
		      		else
		      		{
		      			perso1 = team1.elementAt(last);
		      			selected1 = last;
		      		}
		      		if (perso1.getClass().getSuperclass() == Combattant.class) {
		      			panelCombat1.remove(bHeal1);
		      			panelCombat1.add(bAtk1);
		      			panelCombat1.repaint();
		      		}
		      		else if (perso1.getClass().getSuperclass() == Support.class) {
		      			panelCombat1.remove(bAtk1);
		      			panelCombat1.add(bHeal1);
		      			panelCombat1.repaint();
		      		}
		      		else {
		      			panelCombat1.add(bAtk1);
		      			panelCombat1.add(bHeal1);
		      			panelCombat1.repaint();
		      		}
		      		firstIndex1 = first;
		      		lastIndex1 = last;
		      		String data = perso1.allInfo();
		      		area1.setText(data);
		      	}
		    }
	    });
	    list2.addListSelectionListener(new ListSelectionListener() {
	      	public void valueChanged(ListSelectionEvent e) {
	      		int first = e.getFirstIndex();
	      		int last = e.getLastIndex();
	      		if (e.getValueIsAdjusting()) {
		      		if ((firstIndex2 != first && lastIndex2 == last) || firstIndex2 == last || (firstIndex2 == first && lastIndex2 == last && selected2 == last))
		      		{
		      			perso2 = team2.elementAt(first);
		      			selected2 = first;
		      		}
		      		else
		      		{
		      			perso2 = team2.elementAt(last);
		      			selected2 = last;
		      		}
		      		if (perso2.getClass().getSuperclass() == Combattant.class) {
		      			panelCombat2.remove(bHeal2);
		      			panelCombat2.add(bAtk2);
		      			panelCombat2.repaint();
		      		}
		      		else if (perso2.getClass().getSuperclass() == Support.class) {
		      			panelCombat2.remove(bAtk2);
		      			panelCombat2.add(bHeal2);
		      			panelCombat2.repaint();
		      		}
		      		else {
		      			panelCombat2.add(bAtk2);
		      			panelCombat2.add(bHeal2);
		      			panelCombat2.repaint();
		      		}
		      		firstIndex2 = first;
		      		lastIndex2 = last;
		      		String data = perso2.allInfo();
		      		area2.setText(data);
		      	}
		    }
	    });
	    list.addListSelectionListener(new ListSelectionListener() {
	      	public void valueChanged(ListSelectionEvent e) {
	      		int first = e.getFirstIndex();
	      		int last = e.getLastIndex();
	      		if (e.getValueIsAdjusting()) {
		      		if ((firstIndex != first && lastIndex == last) || firstIndex == last || (firstIndex == first && lastIndex == last && selected == last))
		      		{
		      			selected = first;
		      		}
		      		else
		      		{
		      			selected = last;
		      		}
		      		firstIndex = first;
		      		lastIndex = last;
		      	}
		    }
	    });
	}

	private class ButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == go) {
				panel3.remove(add1);
				panel4.remove(add2);
				panelGo.remove(go);
				panel3.repaint();
				panel4.repaint();
				panelGo.repaint();
				game = true;
			}
			if (e.getSource() == add1)
			{
				team1.addElement(charlist.elementAt(selected));
				list1 = new JList<Personnage>(team1);

			}
			if (e.getSource() == add2)
			{
				team2.addElement(charlist.elementAt(selected));
				list2 = new JList<Personnage>(team2);

			}
			if (e.getSource() == bAtk1)
				panelCombat2.remove(bAtk2);
				panelCombat2.repaint();
			if (e.getSource() == bHeal1)
			if (e.getSource() == bAtk2)
			{}
		}
	}

}