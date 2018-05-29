package am3View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuV extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private int gameVHeight, gameVWidth;
	
	private Container container;
	private GridBagLayout gbl;
	
	private JButton solo, twoPc, twoLan, twoNet;
	private int gameChoice;

	public MenuV(){
		
		gameVHeight=this.makeScreenHeightSize();
		gameVWidth=this.makeScreenWidthSize();
		this.setSize(gameVWidth, gameVHeight);
		this.setLocationRelativeTo(this.getParent());
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("AM3-Menu");
		
		container=getContentPane();
		gbl = new GridBagLayout();
		container.setLayout(gbl);
		container.setBackground(new Color(157,238,11));
		
		this.createButtonsNumberPlayers();
		gameChoice=0;
	}
	
	private void createButtonsNumberPlayers(){
		solo = new JButton("1 joueur"); solo.setBackground(new Color(90,55,119)); solo.setForeground(new Color(157,238,11)); solo.setFocusPainted(false);
		this.add(solo, new GridBagConstraints (3,1,5,1,0,25,GridBagConstraints.PAGE_END,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		twoPc = new JButton("2 joueurs"); twoPc.setBackground(new Color(90,55,119)); twoPc.setForeground(new Color(157,238,11)); twoPc.setFocusPainted(false);
		this.add(twoPc, new GridBagConstraints (3,3,5,1,0,25,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		twoLan = new JButton("2 joueurs en réseau local"); twoLan.setBackground(new Color(90,55,119)); twoLan.setForeground(new Color(157,238,11)); twoLan.setFocusPainted(false);
		this.add(twoLan, new GridBagConstraints (3,5,5,1,0,25,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		twoNet = new JButton("2 joueurs via le net");twoNet.setBackground(new Color(90,55,119)); twoNet.setForeground(new Color(157,238,11)); twoNet.setFocusPainted(false);
		this.add(twoNet, new GridBagConstraints (3,7,5,1,0,25,GridBagConstraints.PAGE_START,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

	}
	
	private int makeScreenHeightSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = (int)(screenSize.getHeight()*0.3);		
		return screenHeight;
	}
	
	private int makeScreenWidthSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)(screenSize.getWidth()*0.2);		
		return screenWidth;
	}
	
	public JButton getSolo() {
		return solo;
	}

	public JButton getTwoPc() {
		return twoPc;
	}

	public JButton getTwoLan() {
		return twoLan;
	}

	public JButton getTwoNet() {
		return twoNet;
	}

	public int getGameChoice() {
		return gameChoice;
	}

	public void setGameChoice(int gameChoice) {
		this.gameChoice = gameChoice;
	}
}
