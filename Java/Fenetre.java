import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
	private JButton rm1;
	private JButton rm2;
	private JTextArea area1;
	private JTextArea area2;

	// Global
	private boolean game = false;
	private DefaultListModel<Personnage> team1;
	private DefaultListModel<Personnage> team2;
	private DefaultListModel<Personnage> charlist;


	// Selection
	private Personnage perso1;
	private Personnage perso2;
	private Personnage selected;

	// Phase Combat
	private JButton bTour;
	private JButton bPasser;
	private JButton bAtk1;
	private JButton bHeal1;
	private JButton bMove1;
	private JButton bAtk2;
	private JButton bHeal2;
	private JButton bMove2;
	private JButton ok;
	private boolean turn = true;
	private JTextArea textCombat;
	private boolean waitAtk1 = false;
	private boolean waitAtk2 = false;
	private boolean waitHeal1 = false;
	private boolean waitHeal2 = false;
	private boolean waitMove1 = false;
	private boolean waitMove2 = false;
	private boolean canMove = true;
	private JPanel map;
	private int selectedx = 0;
	private int selectedy = 0;
	private int team = 0;
	private final static int size = 5;
	private JButton[][] a = new JButton[size][size];
	
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
			panelCombat1.setLayout(new GridLayout(3,1));
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
			panelCombat2.setLayout(new GridLayout(3,1));
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
			// Button Move1
			bMove1 = new JButton("Bouge");
			bMove1.setPreferredSize(new Dimension(100, 30));
			// JList1
			list1 = new JList<Personnage>(team1);
			list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list1.setPreferredSize(new Dimension(150,100));
			// JTextArea1
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
			// Button Move
			bMove2 = new JButton("Bouge");
			bMove2.setPreferredSize(new Dimension(100, 30));
			// JList2
			list2 = new JList<Personnage>(team2);
			list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list2.setPreferredSize(new Dimension(150,100));
			// JTextArea2
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
			// Button Rm1
			rm1 = new JButton("Retirer de mon équipe");
			rm1.setPreferredSize(new Dimension(280,30));
			// Button Add2
			add2 = new JButton("Ajouter à mon équipe");
			add2.setPreferredSize(new Dimension(280,30));
			// Button Rm2
			rm2 = new JButton("Retirer de mon équipe");
			rm2.setPreferredSize(new Dimension(280,30));
			panel3.add(add1);
			panel3.add(rm1);
			panelJoueur1.add(panel3);
			panel4.add(add2);
			panel4.add(rm2);
			panelJoueur2.add(panel4);
			// Button OK
			ok = new JButton("OK");
			ok.setPreferredSize(new Dimension(100,30));
			// Button Tour
			bTour = new JButton("Tour JOUEUR 1");
			bTour.setPreferredSize(new Dimension(280,30));
			// Button Passer son Tour
			bPasser = new JButton("Passer son tour");
			bPasser.setPreferredSize(new Dimension(280,30));
			// JTextArea
			textCombat = new JTextArea();
			textCombat.setEditable(false);
			// JPanelMap
			map = new JPanel();
			map.setBounds(0,0,280,280);
			map.setLayout(new GridLayout(size,size));
			map.setBackground(Color.gray);

			// 16 Buttons
			int i;
			int j;
			for (i = 0 ; i < size ; i++) {
				for (j = 0 ; j < size ; j++) {
					a[i][j] = new JButton();
					a[i][j].setPreferredSize(new Dimension(30,30));
					a[i][j].addActionListener(new ButtonListener());
					a[i][j].setBackground(Color.black);
				}
			}
			for (i = 0 ; i < size ; i++) {
				for (j = 0 ; j < size ; j++) {
					map.add(a[i][j]);
				}
			}
			list = new JList<Personnage>(charlist);
			list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setVisibleRowCount(1);
			panelCharList.add(new JScrollPane(list));
			panel.add(panelCharList);
			panelGo.add(go);
			panel.add(panelGo);

		f.setVisible(true);

		// ADD ACTION LISTENER ------------------------------------------------
		bPasser.addActionListener(new ButtonListener());
		bAtk1.addActionListener(new ButtonListener());
		bHeal1.addActionListener(new ButtonListener());
		bMove1.addActionListener(new ButtonListener());
		bAtk2.addActionListener(new ButtonListener());
		bHeal2.addActionListener(new ButtonListener());
		bMove2.addActionListener(new ButtonListener());
		add1.addActionListener(new ButtonListener());
		add2.addActionListener(new ButtonListener());
		rm1.addActionListener(new ButtonListener());
		rm2.addActionListener(new ButtonListener());
		go.addActionListener(new ButtonListener());
		ok.addActionListener(new ButtonListener());
		list1.addListSelectionListener(new ListSelectionListener() {
	      	public void valueChanged(ListSelectionEvent e) {
	      		if (!list1.isSelectionEmpty()) {
		      		attributeColor(selectedx,selectedy);
		      		perso1 = list1.getSelectedValue();
		      		selectedx = perso1.get_posx();
		      		selectedy = perso1.get_posy();
		      		a[selectedx][selectedy].setBackground(Color.green);
		      		if (game && turn) {
		      			if (perso1.getClass().getSuperclass() == Combattant.class) {
			      			panelCombat1.remove(bHeal1);
			      			panelCombat1.add(bAtk1);
			      			if (canMove)
			      				panelCombat1.add(bMove1);
			      			panelCombat1.repaint();
			      		}
			      		else if (perso1.getClass().getSuperclass() == Support.class) {
			      			panelCombat1.remove(bAtk1);
			      			panelCombat1.add(bHeal1);
			      			if (canMove)
			      				panelCombat1.add(bMove1);
			      			panelCombat1.repaint();
			      		}
			      		else {
			      			panelCombat1.add(bAtk1);
			      			panelCombat1.add(bHeal1);
			      			if (canMove)
			      				panelCombat1.add(bMove1);
			      			panelCombat1.repaint();
			      		}
		      		}
		      		String data = perso1.allInfo();
		      		area1.setText(data);
		      	}
		    }
	    });
	    list2.addListSelectionListener(new ListSelectionListener() {
	      	public void valueChanged(ListSelectionEvent e) {
	      		if (!list2.isSelectionEmpty()) {
	      			attributeColor(selectedx,selectedy);
		      		perso2 = list2.getSelectedValue();
		      		selectedx = perso2.get_posx();
		      		selectedy = perso2.get_posy();
		      		a[selectedx][selectedy].setBackground(Color.green);
		      		if (game && !turn) {
		      			if (perso2.getClass().getSuperclass() == Combattant.class) {
			      			panelCombat2.remove(bHeal2);
			      			panelCombat2.add(bAtk2);
			      			if (canMove)
			      				panelCombat2.add(bMove2);
			      			panelCombat2.repaint();
			      		}
			      		else if (perso2.getClass().getSuperclass() == Support.class) {
			      			panelCombat2.remove(bAtk2);
			      			panelCombat2.add(bHeal2);
			      			if (canMove)
			      				panelCombat2.add(bMove2);
			      			panelCombat2.repaint();
			      		}
			      		else {
			      			panelCombat2.add(bAtk2);
			      			panelCombat2.add(bHeal2);
			      			if (canMove)
			      				panelCombat2.add(bMove2);
			      			panelCombat2.repaint();
			      		}
			      	}
	      			String data = perso2.allInfo();
	      			area2.setText(data);
	      		}
		    }
	    });
	    list.addListSelectionListener(new ListSelectionListener() {
	      	public void valueChanged(ListSelectionEvent e) {
	      		if (!list.isSelectionEmpty()) {
	      			selected = list.getSelectedValue();
	      		}
		    }
	    });
	}


	// FUNCTIONS -----------------------------------------------------------------
	public void selectTarget() {
		textCombat.setText("Sélectionner une cible");
		panelGo.add(ok);
		panelGo.repaint();
		waitAtk1 = false;
		waitAtk2 = false;
		waitHeal1 = false;
		waitHeal2 = false;
		waitMove1 = false;
		waitMove2 = false;
	}

	public void selectDest() {
		textCombat.setText("Sélectionner une case");
		waitAtk1 = false;
		waitAtk2 = false;
		waitHeal1 = false;
		waitHeal2 = false;
		waitMove1 = false;
		waitMove2 = false;
	}

	public void removeAllButton1() {
		panelCombat1.remove(bAtk1);
		panelCombat1.remove(bHeal1);
		panelCombat1.remove(bMove1);
		panelCombat1.repaint();
	}

	public void removeAllButton2() {
		panelCombat2.remove(bAtk2);
		panelCombat2.remove(bHeal2);
		panelCombat2.remove(bMove2);
		panelCombat2.repaint();
	}

	public void clearAllSelect() {
		if (!list1.isSelectionEmpty())
			list1.clearSelection();
		if (!list2.isSelectionEmpty())
			list2.clearSelection();
	}

	public boolean no_collision(int a, int b) {
		int k;
		Personnage p;
		for (k = 0 ; k < team1.getSize() ; k++) {
			p = team1.elementAt(k);
			if (p.get_posx() == a && p.get_posy() == b) {
				return false;
			}
		}
		for (k = 0 ; k < team2.getSize() ; k++) {
			p = team2.elementAt(k);
			if (p.get_posx() == a && p.get_posy() == b) {
				return false;
			}
		}
		return true;
	}

	public void attributeColor(int x, int y) {
		int i;
		Personnage p;
		for (i = 0 ; i < team1.getSize() ; i++) {
			p = team1.elementAt(i);
			if (p.get_posx() == x && p.get_posy() == y) {
				a[x][y].setBackground(Color.red);
				return;
			}
		}
		for (i = 0 ; i < team2.getSize() ; i++) {
			p = team2.elementAt(i);
			if (p.get_posx() == x && p.get_posy() == y) {
				a[x][y].setBackground(Color.blue);
				return;
			}
		}
		a[x][y].setBackground(Color.black);
	}

	public Personnage getPersonnage(int x,int y) {
		int i;
		Personnage p;
		for (i = 0 ; i < team1.getSize() ; i++) {
			p = team1.elementAt(i);
			if (p.get_posx() == x && p.get_posy() == y) {
				team = 1;
				return p;
			}
		}
		for (i = 0 ; i < team2.getSize() ; i++) {
			p = team2.elementAt(i);
			if (p.get_posx() == x && p.get_posy() == y) {
				a[x][y].setBackground(Color.blue);
				team = 2;
				return p;
			}
		}
		team = 0;
		return null;
	}

	private class ButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == go && team1.getSize() > 0 && team2.getSize() > 0) {
				textCombat.setText("La partie vient de commencer");
				panel3.remove(add1);
				panel4.remove(add2);
				panel3.remove(rm1);
				panel4.remove(rm2);
				panelGo.remove(go);
				panel.remove(panelCharList);
				panel.add(textCombat);
				panel3.add(map);
				panel4.add(bTour);
				panel4.add(bPasser);
				panel3.repaint();
				panel4.repaint();
				panelGo.repaint();
				panel.repaint();
				clearAllSelect();
				int k;
				int i = 0;
				int j = 0;
				for (k = 0 ; k < team1.getSize() ; k++) {
					if (i == size) {
						i = 0;
						j += 1;
					}
					team1.elementAt(k).set_pos(i,j);
					a[i][j].setBackground(Color.red);
					i += 1;
				}
				i = 0;
				j = 0;
				for (k = 0 ; k < team2.getSize() ; k++) {
					if (i == size) {
						i = 0;
						j += 1;
					}
					team2.elementAt(k).set_pos(size-1-i,size-1-j);
					a[size-1-i][size-1-j].setBackground(Color.blue);
					i += 1;
				}
				map.repaint();
				game = true;
			}
			if (e.getSource() == add1) {
				if (!list.isSelectionEmpty()) {
					try {
						team1.addElement(selected.clone());
					}
					catch (Exception except) {
						System.out.println(except.getMessage());
					}
				}
			}
			if (e.getSource() == add2) {
				if (!list.isSelectionEmpty()) {
					try {
						team2.addElement(selected.clone());
					}
					catch (Exception except) {
						System.out.println(except.getMessage());
					}
				}
			}
			if (e.getSource() == rm1) {
				if (!list1.isSelectionEmpty()) {
					team1.removeElement(perso1);
				}

			}
			if (e.getSource() == rm2) {
				if (!list2.isSelectionEmpty()) {
					team2.removeElement(perso2);
				}
			}
			if (e.getSource() == bAtk1) {
				selectTarget();
				waitAtk1 = true;
			}
			if (e.getSource() == bHeal1) {
				selectTarget();
				waitHeal1 = true;
			}
			if (e.getSource() == bAtk2) {
				selectTarget();
				waitAtk2 = true;
			}
			if (e.getSource() == bHeal2) {
				selectTarget();
				waitHeal2 = true;
			}
			if (e.getSource() == bMove1) {
				selectDest();
				panelGo.remove(ok);
				panelGo.repaint();
				waitMove1 = true;
			}
			if (e.getSource() == bMove2) {
				selectDest();
				panelGo.remove(ok);
				panelGo.repaint();
				waitMove2 = true;
			}
			if (e.getSource() == bPasser) {
				if (turn) {
					removeAllButton1();
					clearAllSelect();
					canMove = true;
					waitAtk1 = false;
					waitHeal1 = false;
					waitMove1 = false;
					turn = false;
					bTour.setText("Tour JOUEUR 2");
				}
				else {
					removeAllButton2();
					clearAllSelect();
					canMove = true;
					waitAtk2 = false;
					waitHeal2 = false;
					waitMove2 = false;
					turn = true;
					bTour.setText("Tour JOUEUR 1");
				}
			}
			int i;
			int j;

			// POUR OPTIMISER ON AURAIT PU CHERCHER LE PAS DANS LE RAYON DU JOUEUR SELECTIONNE
			if (waitMove1) {
				for (i = 0 ; i < size ; i++) {
					for (j = 0 ; j < size ; j++) {
						if (e.getSource() == a[i][j] && perso1.distance(i,j) <= perso1.get_move() && no_collision(i,j)) {
							a[perso1.get_posx()][perso1.get_posy()].setBackground(Color.black);
							perso1.set_pos(i,j);
							a[i][j].setBackground(Color.red);
							removeAllButton1();
							waitMove1 = false;
							canMove = false;
							clearAllSelect();
							break;
						}
					}
				}
			}
			if (waitMove2) {
				for (i = 0 ; i < size ; i++) {
					for (j = 0 ; j < size ; j++) {
						if (e.getSource() == a[i][j] && perso2.distance(i,j) <= perso2.get_move() && no_collision(i,j)) {
							a[perso2.get_posx()][perso2.get_posy()].setBackground(Color.black);
							perso2.set_pos(i,j);
							a[i][j].setBackground(Color.blue);
							removeAllButton2();
							waitMove2 = false;
							canMove = false;
							clearAllSelect();
							break;
						}
					}
				}
			}

			for (i = 0 ; i < size ; i++) {
				for (j = 0 ; j < size ; j++) {
					Personnage p = getPersonnage(i,j);
					if (e.getSource() == a[i][j] && p != null) {
						attributeColor(selectedx,selectedy);
						if (team == 1) {
							perso1 = p;
							list1.setSelectedValue(perso1,false);
			      			selectedx = perso1.get_posx();
			      			selectedy = perso1.get_posy();
						}
						else if (team == 2) {
							perso2 = p;
							list2.setSelectedValue(perso2,false);
			      			selectedx = perso2.get_posx();
			      			selectedy = perso2.get_posy();
						}
			      		a[selectedx][selectedy].setBackground(Color.green);
			      		if (game && turn) {
			      			if (perso1.getClass().getSuperclass() == Combattant.class) {
				      			panelCombat1.remove(bHeal1);
				      			panelCombat1.add(bAtk1);
				      			if (canMove)
				      				panelCombat1.add(bMove1);
				      			panelCombat1.repaint();
				      		}
				      		else if (perso1.getClass().getSuperclass() == Support.class) {
				      			panelCombat1.remove(bAtk1);
				      			panelCombat1.add(bHeal1);
				      			if (canMove)
				      				panelCombat1.add(bMove1);
				      			panelCombat1.repaint();
				      		}
				      		else {
				      			panelCombat1.add(bAtk1);
				      			panelCombat1.add(bHeal1);
				      			if (canMove)
				      				panelCombat1.add(bMove1);
				      			panelCombat1.repaint();
				      		}
			      		}
			      		else if (game && !turn) {
			      			if (perso2.getClass().getSuperclass() == Combattant.class) {
				      			panelCombat2.remove(bHeal2);
				      			panelCombat2.add(bAtk2);
				      			if (canMove)
				      				panelCombat2.add(bMove2);
				      			panelCombat2.repaint();
				      		}
				      		else if (perso2.getClass().getSuperclass() == Support.class) {
				      			panelCombat2.remove(bAtk2);
				      			panelCombat2.add(bHeal2);
				      			if (canMove)
				      				panelCombat2.add(bMove2);
				      			panelCombat2.repaint();
				      		}
				      		else {
				      			panelCombat2.add(bAtk2);
				      			panelCombat2.add(bHeal2);
				      			if (canMove)
				      				panelCombat2.add(bMove2);
				      			panelCombat2.repaint();
				      		}
				      	}
				      	if (team == 1) {
				      		String data = perso1.allInfo();
		      				area1.setText(data);
				      	}
				      	else if (team == 2) {
				      		String data = perso2.allInfo();
		      				area2.setText(data);
				      	}
		      			break;
					}
				}
			}

			if (e.getSource() == ok) {
				String data;
				if (waitAtk1) {
					if (list2.isSelectionEmpty()) {
						textCombat.setText("Sélection vide");
					}
					else {
						try {
							if (perso1 instanceof Combattant)
								data = ((Combattant)perso1).attaque(perso2);
							else
								data = ((Equilibre)perso1).attaque(perso2);
							textCombat.setText(data);
							removeAllButton1();
		      				panelGo.remove(ok);
							panelGo.repaint();
							waitAtk1 = false;
							turn = false;
							bTour.setText("Tour JOUEUR 2");
							canMove = true;
							if (!perso2.get_alive()) {
								team2.removeElement(perso2);
								a[perso2.get_posx()][perso2.get_posy()].setBackground(Color.black);
							}
							clearAllSelect();
						}
						catch (Exception except) {
							textCombat.setText(except.getMessage());
						}
					}
				}
				else if (waitAtk2) {
					if (list1.isSelectionEmpty()) {
						textCombat.setText("Sélection vide");
					}
					else {
						try {
							if (perso2 instanceof Combattant)
								data = ((Combattant)perso2).attaque(perso1);
							else
								data = ((Equilibre)perso2).attaque(perso1);
							textCombat.setText(data);
							removeAllButton2();
		      				panelGo.remove(ok);
							panelGo.repaint();
							waitAtk2 = false;
							turn = true;
							bTour.setText("Tour JOUEUR 1");
							canMove = true;
							if (!perso1.get_alive()) {
								team1.removeElement(perso1);
								a[perso1.get_posx()][perso1.get_posy()].setBackground(Color.black);
							}
							clearAllSelect();
						}
						catch (Exception except) {
							textCombat.setText(except.getMessage());
						}
					}
				}
				else if (waitHeal1) {
					Personnage perso = perso1;
					if (list1.isSelectionEmpty()) {
						textCombat.setText("Sélection vide");
					}
					else {
						try {
							if (perso instanceof Support)
								data = ((Support)perso).soigne(perso1);
							else
								data = ((Equilibre)perso).soigne(perso1);
							textCombat.setText(data);
							removeAllButton1();
		      				panelGo.remove(ok);
							panelGo.repaint();
							waitHeal1 = false;
							turn = false;
							bTour.setText("Tour JOUEUR 2");
							canMove = true;
							clearAllSelect();
						}
						catch (Exception except) {
							textCombat.setText(except.getMessage());
						}
					}
				}
				else if (waitHeal2) {
					Personnage perso = perso2;
					if (list2.isSelectionEmpty()) {
						textCombat.setText("Sélection vide");
					}
					else {
						try {
							if (perso instanceof Support)
								data = ((Support)perso).soigne(perso2);
							else
								data = ((Equilibre)perso).soigne(perso2);
							textCombat.setText(data);
							removeAllButton2();
		      				panelGo.remove(ok);
							panelGo.repaint();
							waitHeal2 = false;
							turn = true;
							bTour.setText("Tour JOUEUR 1");
							canMove = true;
							clearAllSelect();
						}
						catch (Exception except) {
							textCombat.setText(except.getMessage());
						}
					}
				}
				if (team1.getSize() == 0) {
					textCombat.setText("Victoire de l'équipe 2");
					panel1.remove(list1);
					panel1.repaint();
					panel2.remove(list2);
					panel2.repaint();
					panel3.remove(map);
					panel3.repaint();
					panel4.remove(bTour);
					panel4.remove(bPasser);
					panel4.repaint();
				}
				else if (team2.getSize() == 0) {
					textCombat.setText("Victoire de l'équipe 1");
					panel1.remove(list1);
					panel1.repaint();
					panel2.remove(list2);
					panel2.repaint();
					panel3.remove(map);
					panel3.repaint();
					panel4.remove(bTour);
					panel4.remove(bPasser);
					panel4.repaint();
				}
			}
		}
	}

}